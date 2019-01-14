package com.management.service.impl;

import com.management.dao.ProjectApplicationMapper;
import com.management.dao.ProjectCategoryMapper;
import com.management.dao.ReviewExpertMapper;
import com.management.dao.UserMapper;
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
import java.util.*;

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

    private static final int EXPERT_REVIEW = 2;
    private static final int MEETING_REVIEW = 3;
    private static final int REVIEW_FAILED = 6;
    private static final int LEADER_REVIEW = 4;
    private static final int EXPERT_NOT_FINISH = 2;
    private static final int EXPERT_IDENTITY = 3;
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
            for(int i = 0; i < cou; i++) {
                applicantType.append(applicantList.get(i));
                if(i != cou - 1) {
                    applicantType.append("|");
                }
            }
            projectCategory.setApplicantType(applicantType.toString());
            projectCategory.setMaxMoney(projectCategoryInfo.getMaxMoney());
            projectCategory.setProjectCategoryDescriptionAddress(projectCategoryInfo.getProjectDescriptionAddress());
            projectCategory.setIsExistMeetingReview(projectCategoryInfo.getIsExistMeetingReview());
            projectCategory.setIsInterimReportActivated(2);
            projectCategory.setApplicationStartTime(applicationStartTime);
            projectCategory.setApplicationEndTime(applicationEndTime);
            projectCategory.setProjectStartTime(projectStartTime);
            projectCategory.setProjectEndTime(projectEndTime);
            projectCategory.setStatistics(0);
            projectCategory.setIsApproved(1);
            projectCategory.setIsConcludingReportActivated(2);
            StringBuilder experts = new StringBuilder();
            List<String> list = projectCategoryInfo.getExpertList();
            if(list.isEmpty()) {
                return ResultTool.error("专家列表不能为空");
            }
            int len = list.size();
            for(int i = 0; i < len; i++) {
                experts.append(list.get(i));
                if(i < len - 1) {
                    experts.append("|");
                }
            }
            projectCategory.setExpertList(experts.toString());
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
        for(String applicantType : applicantTypeArray) {
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
        String[] expertArray = projectCategory.getExpertList().split("\\|");
        List<ExpertListInfo> list = new LinkedList<>();
        for(String expertId : expertArray) {
            User user = userMapper.selectByPrimaryKey(expertId);
            ExpertListInfo info = new ExpertListInfo();
            info.setUserName(user.getUserName());
            info.setUserId(user.getUserId());
            info.setPhone(user.getPhone());
            info.setMail(user.getMail());
            info.setDepartment(user.getDepartment());
            list.add(info);
        }
        res.setExpertList(list);
        ReportInfo interimInfo = new ReportInfo();
        if(projectCategory.getIsInterimReportActivated() == 1) {
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
        if(projectCategory.getIsConcludingReportActivated() == 1) {

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
        if(projectCategoryList.isEmpty()) {
            return ResultTool.error("您没有开通任何的项目大类");
        }
        List<AdminListInfo> resList = new LinkedList<>();
        for(ProjectCategory projectCategory : projectCategoryList) {
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
            projectCategory.setIsExistMeetingReview(projectCategoryInfo.getIsExistMeetingReview());
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
        for (ProjectApplication application: list) {
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
            if(project.getIsMeeting()) {
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
    public Result oneJudge(OneJudgeInfo info) {
        ProjectApplication res = projectApplicationMapper
                .selectByPrimaryKey(info.getApplicationId());
        ProjectCategory category = projectCategoryMapper
                .selectByPrimaryKey(res.getProjectCategoryId());
        if(info.getJudge()) {
            res.setReviewPhase(EXPERT_REVIEW);
            String[] experts = category.getExpertList().split("\\|");
            for(String expertId : experts) {
                User user = userMapper.selectByPrimaryKey(expertId);
                ReviewExpert expert = new ReviewExpert();
                expert.setExpertId(expertId);
                expert.setExpertName(user.getUserName());
                expert.setProjectApplicationId(info.getApplicationId());
                expert.setIsFinished(EXPERT_NOT_FINISH);
                try {
                    reviewExpertMapper.insert(expert);
                } catch (Exception e ) {
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
        ProjectApplication application =projectApplicationMapper
                .selectByPrimaryKey(info.getApplicationId());
        if(info.getIsPassed()) {
            application.setReviewPhase(LEADER_REVIEW);
            application.setMeetingReviewMessage(info.getMsg());
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
        for(User user : list) {
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
                .andPrincipalIdEqualTo(userId)
            .andApplicationEndTimeGreaterThan(new Date());
        List<ProjectCategory> list = projectCategoryMapper.selectByExample(example);
        if(list.isEmpty()) {
            return ResultTool.error("你没有创建任何的项目大类");
        }
        List<AdminJudgeTotalInfo> resList = new LinkedList<>();
        for(ProjectCategory category : list) {
            ProjectApplicationExample applicationExample = new ProjectApplicationExample();
            applicationExample.createCriteria()
                    .andProjectCategoryIdEqualTo(category.getProjectCategoryId())
                    .andReviewPhaseEqualTo(reviewPhase);
            List<ProjectApplication> applicationList = projectApplicationMapper
                    .selectByExample(applicationExample);
            if(applicationList.isEmpty()) continue;
            AdminJudgeTotalInfo res = new AdminJudgeTotalInfo();
            res.setApplicationDeadLine(timetoString(category.getApplicationEndTime()));
            res.setProjectCategoryId(category.getProjectCategoryId());
            res.setProjectCategoryName(category.getProjectCategoryName());
            for(ProjectApplication application : applicationList) {
                res.setProjectId(application.getProjectApplicationId());
                res.setProjectApplicationDownloadAddress(application
                        .getProjectApplicationUploadAddress());
                res.setProjectName(application.getProjectName());
                res.setDescription(application.getProjectDescription());
                if(reviewPhase == EXPERT_REVIEW) {
                    res.setExpertOpinion(getExpertOpinionList(application.getProjectApplicationId()));
                }
                resList.add(res);
            }
        }
        return ResultTool.success(resList);
    }


    private List<ExpertOpinionInfo> getExpertOpinionList(int projectId) {
        ReviewExpertExample reviewExpertExample = new ReviewExpertExample();
        reviewExpertExample.createCriteria()
                .andProjectApplicationIdEqualTo(projectId);
        List<ReviewExpert> reviewExpertList = reviewExpertMapper
                .selectByExample(reviewExpertExample);
        List<ExpertOpinionInfo> list = new LinkedList<>();
        for (ReviewExpert reviewExpert : reviewExpertList) {
            ExpertOpinionInfo expertOpinionInfo = new ExpertOpinionInfo();
            expertOpinionInfo.setExpertId(reviewExpert.getExpertId());
            expertOpinionInfo.setExpertName(reviewExpert.getExpertName());
            expertOpinionInfo.setIsFinished(reviewExpert.getIsFinished());
            if(reviewExpert.getIsFinished() == 1) {
                expertOpinionInfo.setFinalOpinion(reviewExpert.getFinalOpinion());
                expertOpinionInfo.setReviewOpinion(reviewExpert.getReviewOpinion());
                expertOpinionInfo.setScore(reviewExpert.getScore());
            }
            list.add(expertOpinionInfo);
        }
        return list;
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

}
