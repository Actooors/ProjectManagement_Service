package com.management.service.impl;

import com.management.dao.*;
import com.management.model.entity.*;
import com.management.model.jsonrequestbody.*;
import com.management.model.jsonrequestbody.ProjectCategoryInfo;
import com.management.model.ov.Result;
import com.management.model.ov.resultsetting.*;
import com.management.service.AdminService;
import com.management.tools.ResultTool;
import com.management.tools.TimeTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

import static com.management.service.impl.LeaderServiceImpl.PROJECT_INDEX_STATE;
import static com.management.tools.TimeTool.timetoString;

/**
 * @program: management
 * @description: 业务员层
 * @author: xw
 * @create: 2018-07-30 17:21
 */

@Service

public class AdminServiceImpl implements AdminService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserMapper userMapper;

    @Resource
    private ProjectCategoryMapper projectCategoryMapper;

    @Resource
    private ProjectApplicationMapper projectApplicationMapper;

    @Resource
    private ReviewExpertMapper reviewExpertMapper;

    @Resource
    private ProjectProgressMapper projectProgressMapper;

    private static final int EXPERT_REVIEW = 2;
    private static final int MEETING_REVIEW = 3;
    private static final int REVIEW_FAILED = 6;
    private static final int LEADER_REVIEW = 4;
    private static final int EXPERT_NOT_FINISH = 2;
    private static final int EXPERT_IDENTITY = 3;
    private static final int FINISH_APPLICATION = 5;
    private static final int ADMIN_INDEX = 8;
    /**
     * @Description: 创建项目类别
     * @Param: projectCategoryInfo
     * @Return: Result
     * @Author: xw
     * @Date: 18-7-30d
     */
    @Override
    public Result createProjectCategory(User adminUser, ProjectCategoryInfo projectCategoryInfo) {
        /*将字符串时间格式转化为Date时间类型*/
        Date applicationStartTime = TimeTool.stringToTime(projectCategoryInfo.getApplicationStartTime());
        Date applicationEndTime = TimeTool.stringToTime(projectCategoryInfo.getApplicationEndTime());
        Date projectStartTime = TimeTool.stringToTime(projectCategoryInfo.getProjectStartTime());
        Date projectEndTime = TimeTool.stringToTime(projectCategoryInfo.getProjectEndTime());

        /*根据业务员id查询到业务员的信息及专家的id*/
        ProjectCategory projectCategory = new ProjectCategory();
        try {
            projectCategory.setReviewLeaderId(adminUser.getLeaderId());
            projectCategory.setProjectCategoryName(projectCategoryInfo.getProjectName());
            projectCategory.setProjectCategoryDescription(projectCategoryInfo.getProjectDescription());
            projectCategory.setProjectApplicationDownloadAddress(projectCategoryInfo.getProjectApplicationDownloadAddress());
            projectCategory.setPrincipalId(adminUser.getUserId());
            projectCategory.setPrincipalName(adminUser.getUserName());
            projectCategory.setPrincipalPhone(projectCategoryInfo.getPrincipalPhone());
            projectCategory.setProjectType(projectCategoryInfo.getProjectType());
            StringBuilder applicantType = new StringBuilder();
            List<Integer> applicantList = projectCategoryInfo.getApplicantType();
            int cou = applicantList.size();
            for (int i = 0; i < cou; i++) {
                applicantType.append(applicantList.get(i));
                if (i != cou - 1) {
                    applicantType.append("|");
                }
            }
            projectCategory.setApplicantType(applicantType.toString());
            projectCategory.setMaxMoney(projectCategoryInfo.getMaxMoney());
            projectCategory.setProjectCategoryDescriptionAddress(projectCategoryInfo.getProjectDescriptionAddress());
            if (projectCategoryInfo.getIsExistMeetingReview().equals(true)) {
                projectCategory.setIsExistMeetingReview(1);
            } else {
                projectCategory.setIsExistMeetingReview(2);
            }
            projectCategory.setIsInterimReportActivated(2);
            projectCategory.setApplicationStartTime(applicationStartTime);
            projectCategory.setApplicationEndTime(applicationEndTime);
            projectCategory.setProjectStartTime(projectStartTime);
            projectCategory.setProjectEndTime(projectEndTime);
            projectCategory.setStatistics(0);
            projectCategory.setIsApproved(1);
            projectCategory.setIsConcludingReportActivated(2);
//            StringBuilder experts = new StringBuilder();
//            List<String> list = projectCategoryInfo.getExpertList();
//            if(list.isEmpty()) {
//                return ResultTool.error("专家列表不能为空");
//            }
//            int len = list.size();
//            for(int i = 0; i < len; i++) {
//                experts.append(list.get(i));
//                if(i < len - 1) {
//                    experts.append("|");
//                }
//            }
//            projectCategory.setExpertList(experts.toString());
            projectCategoryMapper.insert(projectCategory);

            return ResultTool.success();
        } catch (Exception e) {
            return ResultTool.error(e.toString());
        }
    }

    /**
     * @Description: 根据项目大类查找项目大类的具体信息然后加入到AdminListInfo中
     * @Param: [projectCategory]
     * @Return: com.management.model.ov.resultsetting.AdminListInfo
     * @Author: 0GGmr0
     * @Date: 2019-01-12
     */
    private AdminListInfo addInfoToAdminListInfo(ProjectCategory projectCategory) {
        AdminListInfo res = new AdminListInfo();
        res.setProjectCategoryId(projectCategory.getProjectCategoryId());
        res.setProjectName(projectCategory.getProjectCategoryName());
        res.setProjectDescription(projectCategory
                .getProjectCategoryDescription());
        res.setProjectDescriptionAddress(projectCategory
                .getProjectCategoryDescriptionAddress());
        res.setPrincipalPhone(projectCategory.getPrincipalPhone());
        res.setProjectType(ConstCorrespond.PROJECT_TYPE[projectCategory.getProjectType()]);
        String[] applicantTypeArray = projectCategory.getApplicantType().split("\\|");
        int cou = 0;
        for (String applicantType : applicantTypeArray) {
            applicantTypeArray[cou++] = ConstCorrespond
                    .APPLICAN_TYPE[Integer.parseInt(applicantType)];
        }
        List<String> applicantTypeTrueList = new LinkedList<>(
                Arrays.asList(applicantTypeArray));
        res.setApplicantType(applicantTypeTrueList);
        res.setMaxMoney(projectCategory.getMaxMoney());
        res.setProjectApplicationDownloadAddress(projectCategory
                .getProjectApplicationDownloadAddress());
        res.setIsExistMeetingReview(projectCategory.getIsExistMeetingReview());
        res.setApplicationStartTime(timetoString(projectCategory
                .getApplicationStartTime()));
        res.setApplicationEndTime(timetoString(projectCategory
                .getApplicationEndTime()));
        res.setProjectStartTime(timetoString(projectCategory
                .getProjectStartTime()));
        res.setProjectEndTime(timetoString(projectCategory
                .getProjectEndTime()));

        ReportInfo interimInfo = new ReportInfo();
        if (projectCategory.getIsInterimReportActivated() == 1) {
            interimInfo.setDeadline(timetoString(projectCategory
                    .getInterimReportEndTime()));
            interimInfo.setIsReportActivated(true);
            interimInfo.setStartTime(timetoString(projectCategory
                    .getInterimReportStartTime()));
            interimInfo.setReportTemplateAddress(projectCategory
                    .getInterimReportDownloadAddress());
            res.setInterimReport(interimInfo);
        } else {
            interimInfo.setIsReportActivated(false);
        }
        res.setInterimReport(interimInfo);
        ReportInfo concludingInfo = new ReportInfo();
        if (projectCategory.getIsConcludingReportActivated() == 1) {

            concludingInfo.setDeadline(timetoString(projectCategory
                    .getConcludingReportEndTime()));
            concludingInfo.setIsReportActivated(true);
            concludingInfo.setStartTime(timetoString(projectCategory
                    .getConcludingReportStartTime()));
            concludingInfo.setReportTemplateAddress(projectCategory
                    .getConcludingReportDownloadAddress());
            res.setConcludingReport(concludingInfo);
        } else {
            concludingInfo.setIsReportActivated(false);
        }
        res.setConcludingReport(concludingInfo);
        return res;
    }


    /**
     * @Description: 根据项目大类的id查找创建的项目大类的信息
     * @Param: [projectCategoryId]
     * @Return: com.management.model.ov.Result
     * @Author: 0GGmr0
     * @Date: 2019-01-12
     */
    @Override
    public Result queryOneProjectCategory(Integer projectCategoryId) {
        ProjectCategory projectCategory = projectCategoryMapper
                .selectByPrimaryKey(projectCategoryId);
        return ResultTool.success(addInfoToAdminListInfo(projectCategory));
    }

    /**
     * @Description: 业务员根据自己的ID查询创建的项目类别信息
     * @Param: userId
     * @Return: ProjectCategory
     * @Author: xw
     * @Date: 18-7-31
     */
    @Override
    public Result queryProjectCategory(String userId) {
        ProjectCategoryExample projectCategoryExample = new ProjectCategoryExample();
        projectCategoryExample.createCriteria()
                .andPrincipalIdEqualTo(userId);
        List<ProjectCategory> projectCategoryList = projectCategoryMapper.selectByExample(projectCategoryExample);
        if (projectCategoryList.isEmpty()) {
            return ResultTool.error("您没有开通任何的项目大类");
        }
        List<AdminListInfo> resList = new LinkedList<>();
        for (ProjectCategory projectCategory : projectCategoryList) {
            resList.add(addInfoToAdminListInfo(projectCategory));
        }
        return ResultTool.success(resList);

    }

    /**
     * @Description: 根据项目号查找项目后更新内容
     * @Param: UpdateProjectCategoryInfo
     * @Return: Result
     * @Author: xw
     * @Date: 18-12-18
     */
    @Override
    public Result updateProjectCategoryInfo(UpdateProjectCategoryInfo updateProjectCategoryInfo) {

        ProjectCategory projectCategory = projectCategoryMapper.selectByPrimaryKey(updateProjectCategoryInfo.getProjectCategoryId());
        ProjectCategoryInfo projectCategoryInfo = updateProjectCategoryInfo.getProjectCategoryInfo();
        /*将字符串时间格式转化为Date时间类型*/
        Date applicationStartTime = TimeTool.stringToTime(projectCategoryInfo.getApplicationStartTime());
        Date applicationEndTime = TimeTool.stringToTime(projectCategoryInfo.getApplicationEndTime());
        Date projectStartTime = TimeTool.stringToTime(projectCategoryInfo.getProjectStartTime());
        Date projectEndTime = TimeTool.stringToTime(projectCategoryInfo.getProjectEndTime());
        try {
            projectCategory.setProjectCategoryName(projectCategoryInfo.getProjectName());
            projectCategory.setProjectCategoryDescription(projectCategoryInfo.getProjectDescription());
            projectCategory.setProjectApplicationDownloadAddress(projectCategoryInfo.getProjectApplicationDownloadAddress());
            projectCategory.setPrincipalPhone(projectCategoryInfo.getPrincipalPhone());
//            projectCategory.setApplicantType(projectCategoryInfo.getApplicantType());
            projectCategory.setMaxMoney(projectCategoryInfo.getMaxMoney());
            projectCategory.setProjectCategoryDescriptionAddress(projectCategoryInfo.getProjectDescriptionAddress());
            if (projectCategoryInfo.getIsExistMeetingReview().equals(true)) {
                projectCategory.setIsExistMeetingReview(1);
            } else {
                projectCategory.setIsExistMeetingReview(2);
            }
            projectCategory.setApplicationStartTime(applicationStartTime);
            projectCategory.setApplicationEndTime(applicationEndTime);
            projectCategory.setProjectStartTime(projectStartTime);
            projectCategory.setProjectEndTime(projectEndTime);
            projectCategoryMapper.updateByPrimaryKey(projectCategory);

            Result result = ResultTool.success();
            result.setMessage("成功");
            return result;

        } catch (Exception e) {
            Result result = ResultTool.error();
            result.setMessage("失败");
            return result;
        }
    }

    /**
     * @Description: 根据项目大类id查找到相应项目大类并删除
     * @Param: projectCategoryId
     * @Return: Result
     * @Author: xw
     * @Date: 18-12-19
     */
    @Override
    public Result deleteProjectCategory(DeleteProjectCategoryInfo info) {
        int projectCategoryId = info.getProjectCategoryId();
        ProjectCategory projectCategory = projectCategoryMapper.selectByPrimaryKey(projectCategoryId);
        try {
            if (projectCategory != null) {
                projectCategoryMapper.deleteByPrimaryKey(projectCategoryId);
            } else {
                return ResultTool.error("没有这个id的项目大类");
            }
        } catch (Exception e) {
            return ResultTool.error(e.toString());
        }
        ProjectApplicationExample example = new ProjectApplicationExample();
        example.createCriteria()
                .andProjectCategoryIdEqualTo(projectCategoryId);
        List<ProjectApplication> list = projectApplicationMapper.selectByExample(example);
        for (ProjectApplication application : list) {
            application.setFailureReason("业务员取消了这个项目类别，申请无效");
            application.setReviewPhase(REVIEW_FAILED);
            try {
                projectApplicationMapper.updateByPrimaryKeySelective(application);
            } catch (Exception e) {
                return ResultTool.error(e.toString());
            }
        }
        return ResultTool.success();
    }


    /**
     * @Description: someoneAllProjectCategory的实现
     * @Param: [userId]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-15
     */
    @Override
    public Result someoneAllProjectCategory(String userId) {
        ProjectCategoryExample projectCategoryExample = new ProjectCategoryExample();
        projectCategoryExample.createCriteria()
                .andPrincipalIdEqualTo(userId);
        List<ProjectCategory> projectCategoryList = projectCategoryMapper.selectByExample(projectCategoryExample);
        if (projectCategoryList.isEmpty()) {
            return ResultTool.error("这个业务员没有开通过项目大类");
        }
        List<SomeoneAllProjectCategoryInfo> resList = new LinkedList<>();
        for (ProjectCategory projectCategory : projectCategoryList) {
            SomeoneAllProjectCategoryInfo res = new SomeoneAllProjectCategoryInfo();
            res.setFinishPeople(projectCategory.getStatistics());
            res.setProjectCategoryName(projectCategory.getProjectCategoryName());
            res.setProjectDeadline(timetoString(projectCategory.getProjectEndTime()));
            res.setType(projectCategory.getProjectType());
            resList.add(res);
        }
        return ResultTool.success(resList);
    }


    /**
     * @Description: chooseProjectMeeting接口的实现
     * @Param: [info]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-15
     */
    @Override
    public Result chooseProjectMeeting(ChooseProjectMeeting info) {
        List<ProjectMeetingInfo> meetingList = info.getMeetingList();
        if (meetingList.isEmpty()) {
            return ResultTool.error("不能给予空的上会项目列表");
        }
        for (ProjectMeetingInfo project : meetingList) {
            ProjectApplication projectApplication = projectApplicationMapper
                    .selectByPrimaryKey(project.getApplicationId());
            if (project.getIsMeeting()) {
                projectApplication.setReviewPhase(MEETING_REVIEW);
            } else {
                projectApplication.setReviewPhase(REVIEW_FAILED);
                projectApplication.setFailureReason(project.getMsg());
            }
            try {
                projectApplicationMapper.updateByPrimaryKeySelective(projectApplication);
            } catch (Exception e) {
                return ResultTool.error(e.toString());
            }
        }
        return ResultTool.success();
    }


    @Override
    public Result secondJudge(SecondJudgeInfo info) {
        ProjectApplication res = projectApplicationMapper
                .selectByPrimaryKey(info.getApplicationId());
        if (info.getJudge()) {
            if (res.getIsMeeting() == 1) {
                res.setReviewPhase(MEETING_REVIEW);
            } else {
                res.setReviewPhase(LEADER_REVIEW);
            }
        } else {
            res.setReviewPhase(REVIEW_FAILED);
            res.setFailureReason(info.getMsg());
        }
        try {
            projectApplicationMapper.updateByPrimaryKeySelective(res);
        } catch (Exception e) {
            return ResultTool.error(e.toString());
        }
        return ResultTool.success();
    }

    @Override
    public Result oneJudge(OneJudgeInfo info) {
        ProjectApplication res = projectApplicationMapper
                .selectByPrimaryKey(info.getApplicationId());
        if (info.getJudge()) {
            res.setReviewPhase(EXPERT_REVIEW);
            List<String> list = info.getExpertList();
            if (list.isEmpty()) {
                return ResultTool.error("专家列表不能为空");
            }
            for (String expertId : list) {
                User user = userMapper.selectByPrimaryKey(expertId);
                ReviewExpert expert = new ReviewExpert();
                expert.setExpertId(expertId);
                expert.setExpertName(user.getUserName());
                expert.setProjectApplicationId(info.getApplicationId());
                expert.setIsFinished(EXPERT_NOT_FINISH);
                try {
                    reviewExpertMapper.insert(expert);
                } catch (Exception e) {
                    return ResultTool.error(e.toString());
                }
            }
        } else {
            res.setReviewPhase(REVIEW_FAILED);
            res.setFailureReason(info.getMsg());
        }
        try {
            projectApplicationMapper.updateByPrimaryKeySelective(res);
        } catch (Exception e) {
            return ResultTool.error(e.toString());
        }
        return ResultTool.success();
    }

    @Override
    public Result meetingReview(MeetingResult info) {
        ProjectApplication application = projectApplicationMapper
                .selectByPrimaryKey(info.getApplicationId());
        if (info.getJudge()) {
            application.setReviewPhase(LEADER_REVIEW);
            application.setMeetingReviewMessage(info.getMsg());
            if(info.getProjectMoney() != null){
                application.setProjectMoney(info.getProjectMoney());
            }
        } else {
            application.setReviewPhase(REVIEW_FAILED);
            application.setFailureReason(info.getMsg());
        }
        try {
            projectApplicationMapper.updateByPrimaryKeySelective(application);
        } catch (Exception e) {
            return ResultTool.error(e.toString());
        }
        return ResultTool.success();
    }

    @Override
    public Result findExpertList() {
        UserExample example = new UserExample();
        example.createCriteria()
                .andIdentityEqualTo(EXPERT_IDENTITY);
        List<User> list = userMapper.selectByExample(example);
        List<ExpertListInfo> resList = new LinkedList<>();
        for (User user : list) {
            ExpertListInfo res = new ExpertListInfo();
            res.setDepartment(user.getDepartment());
            res.setMail(user.getMail());
            res.setPhone(user.getPhone());
            res.setUserId(user.getUserId());
            res.setUserName(user.getUserName());
            resList.add(res);
        }
        return ResultTool.success(resList);
    }

    @Override
    public Result findReviewPhaseList(String userId, int reviewPhase) {
        ProjectCategoryExample example = new ProjectCategoryExample();
        example.createCriteria()
                .andPrincipalIdEqualTo(userId);
//                .andApplicationEndTimeGreaterThan(new Date());
        List<ProjectCategory> list = projectCategoryMapper.selectByExample(example);
        if (list.isEmpty()) {
            return ResultTool.error("你没有创建任何的项目大类");
        }
        List<AdminJudgeTotalInfo> resList = new LinkedList<>();
        for (ProjectCategory category : list) {
            if(reviewPhase != 9) {
                ProjectApplicationExample applicationExample = new ProjectApplicationExample();
                applicationExample.createCriteria()
                        .andProjectCategoryIdEqualTo(category.getProjectCategoryId())
                        .andReviewPhaseEqualTo(reviewPhase);
                List<ProjectApplication> applicationList = projectApplicationMapper
                        .selectByExample(applicationExample);
                if (applicationList.isEmpty()) continue;
                for (ProjectApplication application : applicationList) {
                    AdminJudgeTotalInfo res = new AdminJudgeTotalInfo();
                    res.setApplicationDeadLine(timetoString(category.getApplicationEndTime()));
                    res.setProjectCategoryId(category.getProjectCategoryId());
                    res.setProjectCategoryName(category.getProjectCategoryName());
                    res.setProjectId(application.getProjectApplicationId());
                    res.setProjectDownloadAddress(application
                            .getProjectApplicationUploadAddress());
                    res.setProjectName(application.getProjectName());
                    res.setDescription(application.getProjectDescription());
                    res.setProjectMaxMoney(category.getMaxMoney());
                    res.setProjectMoney(application.getProjectMoney());
                    if (reviewPhase == EXPERT_REVIEW) {
                        res.setExpertOpinion(getExpertOpinionList(application.getProjectApplicationId()));
                    }
                    if (reviewPhase == ADMIN_INDEX) {
                        res.setIndexContent(application.getProjectIndex());
                    }
                    resList.add(res);
                }
            }else{
                    ProjectProgressExample progressExample = new ProjectProgressExample();
                    progressExample.createCriteria()
                            .andProjectCategoryIdEqualTo(category.getProjectCategoryId())
                            .andProjectProcessEqualTo(3)
                            .andIsFinishedConcludingReportEqualTo(1);
                    List<ProjectProgress> projectProgressList = projectProgressMapper.selectByExample(progressExample);
                    for(ProjectProgress projectProgress : projectProgressList){
                        ProjectApplication application = projectApplicationMapper.selectByPrimaryKey(projectProgress.getProjectProgressId());
                        AdminJudgeTotalInfo res = new AdminJudgeTotalInfo();
                        res.setApplicationDeadLine(timetoString(category.getApplicationEndTime()));
                        res.setProjectCategoryId(category.getProjectCategoryId());
                        res.setProjectCategoryName(category.getProjectCategoryName());
                        res.setProjectId(application.getProjectApplicationId());
                        res.setProjectDownloadAddress(projectProgress.getConcludingReportUploadAddress());
                        res.setProjectName(application.getProjectName());
                        res.setDescription(application.getProjectDescription());
                        res.setProjectMaxMoney(category.getMaxMoney());
                        res.setProjectMoney(application.getProjectMoney());
                        resList.add(res);
                    }
                }
            }

        return ResultTool.success(resList);
    }


    ExpertOpinionMain getExpertOpinionList(int projectId) {
        ReviewExpertExample reviewExpertExample = new ReviewExpertExample();
        reviewExpertExample.createCriteria()
                .andProjectApplicationIdEqualTo(projectId);
        List<ReviewExpert> reviewExpertList = reviewExpertMapper
                .selectByExample(reviewExpertExample);
        List<ExpertOpinionInfo> list = new LinkedList<>();
        int totalNum = 0;
        int finishNum = 0;
        double ave = 0;
        for (ReviewExpert reviewExpert : reviewExpertList) {
            ExpertOpinionInfo expertOpinionInfo = new ExpertOpinionInfo();
            expertOpinionInfo.setExpertId(reviewExpert.getExpertId());
            expertOpinionInfo.setExpertName(reviewExpert.getExpertName());
            expertOpinionInfo.setIsFinished(reviewExpert.getIsFinished());
            if (reviewExpert.getIsFinished() == 1) {
                finishNum++;
                expertOpinionInfo.setFinalOpinion(reviewExpert.getFinalOpinion());
                expertOpinionInfo.setReviewOpinion(reviewExpert.getReviewOpinion());
                expertOpinionInfo.setScore(reviewExpert.getScore());
                ave += Double.parseDouble(reviewExpert.getScore());
            }
            list.add(expertOpinionInfo);
            totalNum++;
        }
        ExpertOpinionMain res = new ExpertOpinionMain();
        res.setExpertOpinionInfoList(list);
        res.setFinishNum(finishNum);
        res.setTotalNum(totalNum);
        if (totalNum != 0) {
            double percentage = 100.0 * finishNum / totalNum;
            BigDecimal bd = new BigDecimal(percentage);
            res.setPercentage(bd.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
            res.setAverage(ave / totalNum);
        }
        return res;
    }


    /**
     * @Description: expertOpinionList接口的实现
     * @Param: [projectId]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-1
     */
    @Override
    public Result expertOpinionList(int projectId) {
        return ResultTool.success(getExpertOpinionList(projectId));

    }

    /**
     * @Description: 业务员开通中期报告/结题报告
     * @Param: [reportMessage]
     * @Return: com.management.model.ov.Result
     * @Author: 0GGmr0
     * @Date: 2019-01-14
     */
    @Override
    public Result createReport(ReportMessage reportMessage) {
        ProjectCategory projectCategory = projectCategoryMapper.selectByPrimaryKey(reportMessage.getProjectCategoryId());
        //中期报告
        ProjectProgressExample example = new ProjectProgressExample();
        example.createCriteria()
                .andProjectCategoryIdEqualTo(projectCategory.getProjectCategoryId());
        List<ProjectProgress> projectProgresses = projectProgressMapper.selectByExample(example);

        if (reportMessage.getType() == 1) {
            projectCategory.setInterimReportDownloadAddress(reportMessage.getReportAddress());
            projectCategory.setIsInterimReportActivated(1);
            projectCategory.setInterimReportStartTime(TimeTool.stringToTime(reportMessage.getStartTime()));
            projectCategory.setInterimReportEndTime(TimeTool.stringToTime(reportMessage.getDeadline()));
            // 业务员开通中期报告，所有项目的阶段全部变为中期报告阶段
            for (ProjectProgress projectProgress : projectProgresses) {
                projectProgress.setProjectProcess(2);
                projectProgressMapper.updateByPrimaryKeySelective(projectProgress);
            }
        } else {
            projectCategory.setConcludingReportDownloadAddress(reportMessage.getReportAddress());
            projectCategory.setIsConcludingReportActivated(1);
            projectCategory.setConcludingReportStartTime(TimeTool.stringToTime(reportMessage.getStartTime()));
            projectCategory.setConcludingReportEndTime(TimeTool.stringToTime(reportMessage.getDeadline()));
            // 业务员开通结题报告，所有项目的阶段全部变为结题报告阶段
            for (ProjectProgress projectProgress : projectProgresses) {
                projectProgress.setProjectProcess(3);
                projectProgressMapper.updateByPrimaryKeySelective(projectProgress);
            }
        }
        projectCategoryMapper.updateByPrimaryKey(projectCategory);
        Map<String, String> time = new HashMap<>();
        time.put("startTime", TimeTool.timetoString(TimeTool.stringToTime(reportMessage.getStartTime())));
        time.put("endTime", TimeTool.timetoString(TimeTool.stringToTime(reportMessage.getDeadline())));
        return ResultTool.success(time);
    }

    /**
     * @Description: 业务员和领导我的项目一栏: 业务员及领导查询自己负责的立项的项目
     * @Param: [userId]
     * @Return: Result
     * @Author: xw
     * @Date: 19-1-25
     */
    public Result AdminQueryProject(String userId){
        List<ProjectTotalInfo> buildProject = new LinkedList<>();
        List<ProjectTotalInfo> middleProject = new LinkedList<>();
        List<ProjectTotalInfo> finalProject = new LinkedList<>();
        List<ProjectTotalInfo> finishProject = new LinkedList<>();
        List<ProjectTotalInfo> failedProject = new LinkedList<>();
        //查找到业务员负责的项目申请信息列表
        List<ProjectApplication> applicationList = projectApplicationMapper
                .queryAllProgressAndFailProject(userId);

        for(ProjectApplication application : applicationList){
            ProjectProgress progress = projectProgressMapper
                    .selectByPrimaryKey(application.getProjectApplicationId());
            ProjectTotalInfo info = new ProjectTotalInfo();
            info.setDescription(application.getProjectDescription());
            info.setProjectApplicationId(application.getProjectApplicationId());
            info.setProjectName(application.getProjectName());
            //查询到相应的项目大类
            ProjectCategory projectCategory = projectCategoryMapper
                    .selectByPrimaryKey(application.getProjectCategoryId());
            info.setProjectCategory(projectCategory.getProjectCategoryName());
            info.setProjectCategoryId(projectCategory.getProjectCategoryId());
            //处理已经立项的项目
            if(application.getReviewPhase().equals(5)){
                info.setReviewPhase(ConstCorrespond
                        .PROJECT_PROGRESS[progress.getProjectProcess()]);
                //获取当前时间,只给用户提供在中期报告和结题报告提交时间段内的项目
                Date nowTime = new Date();
                switch (progress.getProjectProcess()) {
                    case 1 : {
                        info.setTime(timetoString(progress.getProjectcreatetime()));
                        info.setStatus(1);
                        buildProject.add(info);
                        break;
                    }
                    case 2 : {
                        Date InterimReportEndTime = projectCategory.getInterimReportEndTime();
                        Date InterimReportStartTime = projectCategory.getInterimReportStartTime();
                        if(projectCategory.getIsInterimReportActivated()==1) {
                            if(!InterimReportStartTime.before(nowTime)) {
                                info.setStatus(3);
                            } else if(InterimReportEndTime.after(nowTime)) {
                                info.setReportAddress(projectCategory.getInterimReportDownloadAddress());
                                info.setStatus(1);
                            } else {
                                info.setStatus(2);
                            }
                        }
                        info.setTime(timetoString(InterimReportEndTime));
                        middleProject.add(info);
                        break;
                    }
                    case 3 :{
                        Date ConcludingReportEndTime = projectCategory.getConcludingReportEndTime();
                        Date ConcludingReportStartTime = projectCategory.getConcludingReportStartTime();
                        if(projectCategory.getIsConcludingReportActivated() == 1) {
                            if(!ConcludingReportStartTime.before(nowTime)) {
                                info.setStatus(3);
                            } else if(ConcludingReportEndTime.after(nowTime)) {
                                info.setReportAddress(projectCategory.getConcludingReportDownloadAddress());
                                info.setStatus(1);
                            } else {
                                info.setStatus(2);
                            }
                        }
                        info.setTime(timetoString(ConcludingReportEndTime));
                        finalProject.add(info);
                        break;
                    }
                    case 4: {
                        info.setTime(timetoString(projectCategory.getProjectEndTime()));
                        info.setStatus(1);
                        finishProject.add(info);
                        break;
                    }
                    case 5: {
                        info.setFailMessage(progress.getConcludingReportFailureReason());
                        failedProject.add(info);
                    }
                }
            }

            if(application.getReviewPhase().equals(6)){
                info.setFailMessage(application.getFailureReason());
                failedProject.add(info);
            }
        }
        FindProjectInfo res = new FindProjectInfo();
        res.setBuildProject(buildProject);
        res.setMiddleProject(middleProject);
        res.setFinalProject(finalProject);
        res.setFinishProject(finishProject);
        res.setFailProject(failedProject);
        return ResultTool.success(res);
    }


    @Override
    public Result judgeMission(MeetingResult info) {
        ProjectApplication projectApplication = projectApplicationMapper.selectByPrimaryKey(info.getApplicationId());
        if(info.getJudge()) {
            projectApplication.setReviewPhase(FINISH_APPLICATION);
            projectApplication.setProjectIndexState(true);

            ProjectProgress projectProgress = new ProjectProgress();
            projectProgress.setProjectProgressId(projectApplication.getProjectApplicationId());
            projectProgress.setIsFinishedConcludingReport(2);
            projectProgress.setIsFinishedInterimReport(2);
            projectProgress.setProjectProcess(1);
            projectProgress.setProjectCategoryId(projectApplication.getProjectCategoryId());
            projectProgress.setUserId(projectApplication.getUserId());
            projectProgress.setProjectName(projectApplication.getProjectName());
            projectProgress.setDescription(projectApplication.getProjectDescription());
            projectProgress.setUserName(projectApplication.getUserName());
            projectProgress.setDepartment(projectApplication.getDepartment());
            try {
                projectProgressMapper.insert(projectProgress);
            } catch (Exception e) {
                return ResultTool.error("审核通过后创建项目的projectprogress失败，理由为" + e.toString());
            }
        } else {
            projectApplication.setProjectIndexState(false);
            projectApplication.setFailureReason(info.getMsg());
            projectApplication.setReviewPhase(PROJECT_INDEX_STATE);
        }
        try {
            projectApplicationMapper.updateByPrimaryKeySelective(projectApplication);
        }catch (Exception e) {
            return ResultTool.error("在审核任务书通过后更新数据库出错，报错信息为" + e.toString());
        }
        return ResultTool.success();
    }


    @Override
    public Result judgeFinalReport(MeetingResult info) {
        ProjectProgress projectProgress  = projectProgressMapper.selectByPrimaryKey(info.getApplicationId());
        if(info.getJudge()) {
            projectProgress.setProjectProcess(4);
        } else {
            projectProgress.setConcludingReportFailureReason(info.getMsg());
            projectProgress.setIsFinishedConcludingReport(2);
            projectProgress.setProjectProcess(5);
        }
        projectProgressMapper.updateByPrimaryKeySelective(projectProgress);
        return ResultTool.success();
    }
}
