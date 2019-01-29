package com.management.service.impl;

import com.management.dao.*;
import com.management.model.entity.*;
import com.management.model.jsonrequestbody.*;
import com.management.model.ov.Result;
import com.management.model.ov.resultsetting.*;
import com.management.model.ov.resultsetting.ProjectCategoryInfo;
import com.management.service.UserService;
import com.management.tools.AuthTool;
import com.management.tools.JwtUtil;
import com.management.tools.ResultTool;
import com.management.tools.TimeTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

import static com.management.model.ov.resultsetting.ConstCorrespond.FINAL_PROGRESS;
import static com.management.model.ov.resultsetting.ConstCorrespond.MIDDLE_PROGRESS;
import static com.management.tools.TimeTool.*;
import static com.management.tools.TimeTool.timetoString;

/**
 * @program: management
 * @description: 登录接口的业务实现
 * @author: ggmr
 * @create: 2018-07-29 17:21
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ProjectApplicationMapper projectApplicationMapper;

    @Resource
    private ProjectCategoryMapper projectCategoryMapper;

    @Resource
    private ProjectMemberMapper projectMemberMapper;

    @Resource
    private ProjectProgressMapper projectProgressMapper;

    @Resource
    private ReviewExpertMapper reviewExpertMapper;

    @Resource
    private JwtUtil jwtUtil;

    private static final int LOGIN_ENABLE = 1;
    private static final int STATE_TWO = 2;
    private static final int REVIEW_FAILED = 6;
    private static final int REVIEW_LAST_PHASE = 5;
    private static final int REVIEW_PROJECT_INDEX = 7;//待提交任务书阶段
    /**
     * @Description: 根据参数生成登录返回需要的信息
     * @Param: [userId, identity, userName]
     * @Return: com.management.model.ov.resultsetting.LoginResponse
     * @Author: ggmr
     * @Date: 18-7-29
     */
    private LoginResponse setLoginResponse(String userId, Integer identity,
                                           String userName) {
        LoginResponse response = new LoginResponse();
        response.setToken(jwtUtil.createJwt(userId, identity));
        response.setIdentity(identity);
        response.setUserId(userId);
        response.setUserName(userName);
        return response;
    }

    /**
     * @Description: login接口的实现
     * @Param: [loginUser]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-7-29
     */
    @Override
    public Result login(LoginInfo loginUser) {
        //先判断账号和密码是否输入为空
        if (loginUser == null || loginUser.getUserId() == null || "".equals(loginUser.getUserId())
                || "".equals(loginUser.getPassword()) || loginUser.getPassword() == null) {
            return ResultTool.error("账号或密码不能为空");
        }
        User existedUser = userMapper.selectByPrimaryKey(loginUser.getUserId());
        //如果该账户在数据库已经存在
        if (existedUser != null) {
            //如果该账户的账号密码验证正确并且可以登录
            if (AuthTool.getAuth(loginUser.getUserId(), loginUser.getPassword()) &&
                    existedUser.getIsAbleLogin() == LOGIN_ENABLE) {
                return ResultTool.success(setLoginResponse(loginUser.getUserId(),
                        existedUser.getIdentity(), existedUser.getUserName()));
                //如果密码输入错误
            } else if (!AuthTool.getAuth(loginUser.getUserId(), loginUser.getPassword())) {
                return ResultTool.error("密码输入错误");
                //如果该账户登录权限为禁止登陆
            } else {
                return ResultTool.error("您没有权限登录该系统");
            }
        } else {
            // 请求上海大学登陆接口查看有没有该用户，有的话该用户进入我们的数据库，没有的话返回登陆失败的信息
            if (AuthTool.getAuth(loginUser.getUserId(), loginUser.getPassword())) {
                User newUser = AuthTool.getInfo(loginUser.getUserId());
                //如果返回了newUser，说明操作正常
                if (newUser != null) {
                    newUser.setIdentity(1);
                    newUser.setIsAbleLogin(1);
                    userMapper.insert(newUser);

                    return ResultTool.success(setLoginResponse(loginUser.getUserId(),
                            1, newUser.getUserName()));
                    //如果没有得到newUser，说明验证异常
                } else {
                    return ResultTool.error("验证过程中发生异常,一般是由于工号/学号无效!");
                }
                //直接去上海大学接口验证仍然发生了错误，说明账号或者密码输入错误
            } else {
                return ResultTool.error("账号或密码输入错误");
            }
        }

    }

    /**
     * @Description: isTimeOut接口的实现
     * @Param: [projectCategoryId, type]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-7-31
     */
    @Override
    public Result isTimeOut(Integer projectCategoryId, Integer type) {
        ProjectCategory projectCategory = projectCategoryMapper
                .selectByPrimaryKey(projectCategoryId);
        if (projectCategory == null) {
            return ResultTool.error("不存在这个id的项目大类");
        } else {
            int isTimeOut = 1;
            Date cur = new Date(),
                    compareTime;
            switch (type) {
                case 1:
                    compareTime = projectCategory.getApplicationEndTime();
                    break;
                case 2:
                    compareTime = projectCategory.getInterimReportEndTime();
                    break;
                case 3:
                    compareTime = projectCategory.getConcludingReportEndTime();
                    break;
                case 4:
                    compareTime = projectCategory.getProjectEndTime();
                    break;
                default:
                    return ResultTool.error("给予的type类型有误");
            }
            if (cur.before(compareTime)) {
                isTimeOut = 2;
            }
            return ResultTool.success(new IsTimeOutInfo(isTimeOut));
        }
    }

    /**
     * @Description: findAllProjectCategory接口的实现
     * @Param: [projectCategoryType]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-7-31
     */
    @Override
    public Result findAllProjectCategory(Integer projectCategoryType) {
        ProjectCategoryExample projectCategoryExample = new ProjectCategoryExample();
        projectCategoryExample.createCriteria()
                .andProjectTypeEqualTo(projectCategoryType)
                .andApplicationEndTimeGreaterThan(new Date())
                .andIsApprovedEqualTo(1);
        List<ProjectCategory> projectCategoryList = projectCategoryMapper
                .selectByExample(projectCategoryExample);
        if (projectCategoryList.isEmpty()) {
            return ResultTool.error("该类别没有可申报项目");
        }
        List<ProjectCategoryListInfo> list = new LinkedList<>();

        for (ProjectCategory projectCategory : projectCategoryList) {
            ProjectCategoryListInfo projectCategoryListInfo = new ProjectCategoryListInfo();
            projectCategoryListInfo.setApplicantType(projectCategory.getApplicantType());
            projectCategoryListInfo.setApplicationDeadline(TimeTool.timetoString(projectCategory.getApplicationEndTime()));
            projectCategoryListInfo.setProjectCategoryName(projectCategory.getProjectCategoryName());
            list.add(projectCategoryListInfo);
        }
        return ResultTool.success(list);
    }

    /**
     * @Description: findProjectCategoryInfo接口的实现
     * @Param: [projectCategoryId]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-7-31
     */
    @Override
    public Result findProjectCategoryInfo(Integer projectCategoryId) {
        ProjectCategory projectCategory = projectCategoryMapper.selectByPrimaryKey(projectCategoryId);
        if (projectCategory == null) {
            return ResultTool.error("不存在这个Id的项目大类");
        }
        ProjectCategoryInfo projectCategoryInfo = new ProjectCategoryInfo();
        projectCategoryInfo.setProjectCategoryName(projectCategory.getProjectCategoryName());
        projectCategoryInfo.setApplicantType(projectCategory.getApplicantType());
        projectCategoryInfo.setProjectCategoryDescription(projectCategory.getProjectCategoryDescription());
        projectCategoryInfo.setProjectCategoryDescriptionAddress(projectCategory.getProjectCategoryDescriptionAddress());
        projectCategoryInfo.setProjectType(projectCategory.getProjectType());
        projectCategoryInfo.setPrincipalId(projectCategory.getPrincipalId());
        projectCategoryInfo.setPrincipalName(projectCategory.getPrincipalName());
        projectCategoryInfo.setMaxMoney(projectCategory.getMaxMoney());
        projectCategoryInfo.setReviewLeaderName(projectCategory.getReviewLeaderName());
        projectCategoryInfo.setProjectApplicationDownloadAddress(projectCategory.getProjectApplicationDownloadAddress());
        projectCategoryInfo.setApplicationStartTime(TimeTool.timetoString(projectCategory.getApplicationStartTime()));
        projectCategoryInfo.setApplicationDeadLine(TimeTool.timetoString(projectCategory.getApplicationEndTime()));
        projectCategoryInfo.setProjectStartTime(TimeTool.timetoString(projectCategory.getProjectStartTime()));
        projectCategoryInfo.setProjectDeadline(TimeTool.timetoString(projectCategory.getProjectEndTime()));
        return ResultTool.success(projectCategoryInfo);
    }

    /**
     * @Description: waitJudgeProjectList接口的实现
     * @Param: [leaderId]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-15
     */
    @Override
    public Result waitJudgeProjectList(Integer projectCategoryId, Integer type) {
        ProjectApplicationExample pExample = new ProjectApplicationExample();
        pExample.createCriteria()
                .andProjectCategoryIdEqualTo(projectCategoryId)
                .andReviewPhaseEqualTo(type);
        List<ProjectApplication> list = projectApplicationMapper.selectByExample(pExample);
        if (list.isEmpty()) {
            return ResultTool.error("当前并没有需要审核的项目");
        }
        List<WaitJudgeProjectInfo> resList = new LinkedList<>();
        for (ProjectApplication projectApplication : list) {
            WaitJudgeProjectInfo res = new WaitJudgeProjectInfo();
            res.setDescription(projectApplication.getProjectDescription());
            res.setProjectId(projectApplication.getProjectApplicationId());
            res.setProjectName(projectApplication.getProjectName());
            resList.add(res);
        }
        return ResultTool.success(resList);
    }

    /**
     * @Description: projectJudgeResult接口的实现
     * @Param: [projectId, info]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-15
     */
    @Override
    public Result projectJudgeResult(IsProjectPassedPostInfo info) {
        ProjectApplication projectApplication = projectApplicationMapper.selectByPrimaryKey(info.getProjectId());
        if (projectApplication == null) {
            return ResultTool.error("不存在这个id的项目");
        }
        int judge = info.getIsPassed();
        if (judge == STATE_TWO) {
            projectApplication.setFailureReason(info.getMessage());
            projectApplication.setReviewPhase(REVIEW_FAILED);
        } else {
            projectApplication.setReviewPhase(projectApplication.getReviewPhase() + 1);
        }
        projectApplicationMapper.updateByPrimaryKeySelective(projectApplication);
        return ResultTool.success();
    }


    /**
     * @Description: 获取全部的可申报项目
     * @Param: [userId]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 2018/12/17
     */
    @Override
    public Result getAllAviProject() {

        ProjectCategoryExample example = new ProjectCategoryExample();
        example.createCriteria()
                .andApplicationEndTimeGreaterThan(new Date());
        List<ProjectCategory> projectCategoryList = projectCategoryMapper
                .selectByExample(example);
        if (projectCategoryList.isEmpty()) {
            return ResultTool.success(new LinkedList<AviProjectCategoryInfo>());
        }
        //根据项目类别的int值排序
        Collections.sort(projectCategoryList);
        //获取到最大的项目类别
        int maxType = projectCategoryList.get(0).getProjectType();
        //根据排序好的结果，先遍历的创建包含这些type的内容，
        // 然后去遍历projectCategoryList内容找到符合当前条件的加进去
        List<AviProjectCategoryInfo> resList = new LinkedList<>();
        for (int i = maxType, count = 0, len = projectCategoryList.size(); i >= 1; i--) {
            for (; count < len; count++) {
                if (projectCategoryList.get(count).getProjectType() == i) {
                    AviProjectCategoryInfo info = new AviProjectCategoryInfo();
                    ProjectCategory p = projectCategoryList.get(count);
                    info.setType(ConstCorrespond.PROJECT_TYPE[i]);
                    info.setDeadLine(timeToString1(p.getApplicationEndTime()));
                    info.setIntroduce(p.getProjectCategoryDescription());
                    info.setProjectId(p.getProjectCategoryId());
                    info.setProjectName(p.getProjectCategoryName());
                    info.setIsMeeting(p.getIsExistMeetingReview() == 1 ? "true":"false");
                    info.setDownLoadAddress(ConstCorrespond.downloadAddress +
                            p.getProjectApplicationDownloadAddress());
                    info.setProjectMaxMoney(p.getMaxMoney());
                    resList.add(info);
                } else {
                    break;
                }
            }
        }
        return ResultTool.success(resList);
    }

    /**
     * @Description: 查询个人信息, 适用于所有用户
     * @Param: userId
     * @Return: Result
     * @Author: xw
     * @Date: 18-12-19
     */
    public Result queryUserId(String userId) {
        try {
            User user = userMapper.selectByPrimaryKey(userId);
            Result result = ResultTool.success(user);
            result.setMessage("成功");
            return result;
        } catch (Exception e) {
            Result result = ResultTool.error();
            result.setMessage("失败");
            return result;
        }
    }

    /**
     * @Description: 修改个人信息
     * @Param: User
     * @Return: Result
     * @Author: xw
     * @Date: 18-12-19
     */
    public Result updateUserInfo(User user) {
        try {
            UserExample example = new UserExample();
            example.createCriteria()
                    .andUserIdEqualTo(user.getUserId());
            userMapper.updateByExample(user, example);
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
     * @Description: 申请一个项目
     * @Param: [projectApplicationInfo]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 2018/12/24
     */
    @Override
    public Result applyProject(ProjectApplicationInfo projectApplicationInfo) {
        List<ProjectMembers> membersList = projectApplicationInfo.getMembers();
        if(membersList.isEmpty()) {
            return ResultTool.error("没有申报人");
        }
        ProjectApplication res = new ProjectApplication();
        res.setProjectCategoryId(projectApplicationInfo.getProjectCategoryId());
        res.setProjectName(projectApplicationInfo.getProjectName());
        res.setProjectDescription(projectApplicationInfo.getDescription());
        ProjectMembers mainMember = membersList.get(0);
        res.setUserId(mainMember.getUserId());
        res.setUserName(mainMember.getUserName());
        res.setDepartment(mainMember.getDepartment());
        res.setPhone(mainMember.getPhone());
        res.setMail(mainMember.getMail());
        res.setProjectApplicationUploadAddress(projectApplicationInfo.getUploadAddress());
        res.setReviewPhase(1);
        res.setProjectMoney(projectApplicationInfo.getProjectMoney());
//        res.setApplicationDeadline(stringToTime(projectApplicationInfo.getApplicationDeadline()));
        //1上会2不上
        res.setIsMeeting(projectApplicationInfo.getIsMeeting() ? 1 : 2);
        try {
            projectApplicationMapper.insert(res);
        } catch (Exception e) {
            return ResultTool.error(e.toString());
        }
        int cou = 0;
        for(ProjectMembers projectMembers: membersList) {
            if(cou == 0) {
                cou++; continue;
            }
            ProjectMember member = new ProjectMember();
            member.setUserId(projectMembers.getUserId());
            member.setUserName(projectMembers.getUserName());
            member.setDepartment(projectMembers.getDepartment());
            member.setPhone(projectMembers.getPhone());
            member.setMail(projectMembers.getMail());
            member.setProjectName(projectApplicationInfo.getProjectName());
            member.setType(1);
            member.setProjectUserId(mainMember.getUserId());
            try {
                projectMemberMapper.insert(member);
            } catch (Exception e) {
                return ResultTool.error(e.toString());
            }
        }
        return ResultTool.success();
    }

    @Override
    public Result findMyApplication(String userId) {
        ProjectApplicationExample example = new ProjectApplicationExample();
        example.createCriteria()
                .andUserIdEqualTo(userId);
        List<ProjectApplication> findList = projectApplicationMapper
                                                .selectByExample(example);
        if(findList.isEmpty()) {
            return ResultTool.error("你目前没有正在申请中的项目");
        }
        List<ProjectTotalInfo> resList = new LinkedList<>();
        for(ProjectApplication application : findList) {
            //查询到相应的项目大类
            ProjectCategory projectCategory = projectCategoryMapper
                    .selectByPrimaryKey(application.getProjectCategoryId());
            //查询立项之前的项目申请
            if(application.getReviewPhase() == 7 || application.getReviewPhase() < REVIEW_LAST_PHASE || application.getReviewPhase() == 8) {
                ProjectTotalInfo res = new ProjectTotalInfo();
                res.setTime(TimeTool.timeToString1(application.getApplicationTime()));
                res.setProjectApplicationId(application.getProjectApplicationId());
                res.setProjectName(application.getProjectName());
                res.setReviewPhase(ConstCorrespond
                        .reviewPhrase[application.getReviewPhase()]);
                res.setDescription(application.getProjectDescription());
                res.setProjectCategoryId(projectCategory.getProjectCategoryId());
                resList.add(res);
            }
        }
        return ResultTool.success(resList);
    }

    @Override
    public Result deleteApplication(DeleteApplication info,String userId) {
        ProjectMemberExample example = new ProjectMemberExample();
        example.createCriteria()
                .andProjectUserIdEqualTo(userId)
                .andProjectNameEqualTo(info.getApplicationName());
        try {
            projectApplicationMapper.deleteByPrimaryKey(info.getApplicationId());
            projectMemberMapper.deleteByExample(example);
        } catch (Exception e) {
            return ResultTool.error(e.toString());
        }
        return ResultTool.success();
    }

    @Override
    public Result findProgressProject(String userId) {
        //找到已经立项的项目申请
        ProjectApplicationExample applicationExample = new ProjectApplicationExample();
        applicationExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andReviewPhaseEqualTo(REVIEW_LAST_PHASE);
        List<ProjectApplication> resBigList = projectApplicationMapper
                .selectByExample(applicationExample);
        if(resBigList.isEmpty()) {
            return ResultTool.error("你目前没有正在进行或已经完成的项目");
        }
        List<ProjectTotalInfo> buildProject = new LinkedList<>();
        List<ProjectTotalInfo> middleProject = new LinkedList<>();
        List<ProjectTotalInfo> finalProject = new LinkedList<>();
        List<ProjectTotalInfo> finishProject = new LinkedList<>();

        FindProjectInfo res = new FindProjectInfo();
        for(ProjectApplication application : resBigList) {
            ProjectProgress progress = projectProgressMapper
                    .selectByPrimaryKey(application.getProjectApplicationId());
            ProjectTotalInfo info = new ProjectTotalInfo();
            info.setDescription(application.getProjectDescription());
            info.setProjectApplicationId(application.getProjectApplicationId());
            info.setProjectName(application.getProjectName());
            info.setProjectCategoryId(application.getProjectCategoryId());
            info.setReviewPhase(ConstCorrespond
                    .PROJECT_PROGRESS[progress.getProjectProcess()]);
            //从项目大类表中查询到相应的时间
            ProjectCategory projectCategory = projectCategoryMapper
                    .selectByPrimaryKey(application.getProjectCategoryId());
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
                    if(progress.getIsFinishedInterimReport() == 1) {
                        info.setIsFinished(true);
                        info.setMyAddress(progress.getInterimReportUploadAddress());
                    } else {
                        info.setIsFinished(false);
                    }
                    middleProject.add(info);
                    break;
                }
                case 5 : {

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
                    if(progress.getIsFinishedConcludingReport() == 1) {
                        info.setIsFinished(true);
                        info.setMyAddress(progress.getConcludingReportUploadAddress());
                    } else {
                        info.setIsFinished(false);
                    }
                    finalProject.add(info);
                    break;
                }
                case 4: {
                    info.setTime(timetoString(projectCategory.getProjectEndTime()));
                    info.setStatus(1);
                    finishProject.add(info);
                    break;
                }
            }
        }
        res.setBuildProject(buildProject);
        res.setMiddleProject(middleProject);
        res.setFinalProject(finalProject);
        res.setFinishProject(finishProject);
        return ResultTool.success(res);
    }



    @Override
    public Result findMoreInfo(int applicationId) {
        ProjectApplication resApplication = projectApplicationMapper
                .selectByPrimaryKey(applicationId);
        ProjectProgress resProgress = projectProgressMapper
                .selectByPrimaryKey(applicationId);
        ProjectMoreInfo res = new ProjectMoreInfo();
        res.setApplicationAddress(ConstCorrespond.downloadAddress +
                resApplication.getProjectApplicationUploadAddress());
        res.setApplicationId(resApplication.getProjectApplicationId());
        res.setProjectCategoryId(resApplication.getProjectCategoryId());
        if(resProgress != null) {
            if (resProgress.getIsFinishedInterimReport() == 1) {
                res.setInterimAddress(ConstCorrespond.downloadAddress +
                        resProgress.getInterimReportUploadAddress());
            }
            if (resProgress.getIsFinishedConcludingReport() == 1) {
                res.setConcludingAddress(ConstCorrespond.downloadAddress +
                        resProgress.getConcludingReportUploadAddress());
            }
        }
        res.setDescription(resApplication.getProjectDescription());
        res.setProjectName(resApplication.getProjectName());
        res.setProjectMoney(resApplication.getProjectMoney());
        if(resApplication.getProjectIndex() != null){
            res.setProjectIndex(resApplication.getProjectIndex());
        }
        ProjectMemberExample example = new ProjectMemberExample();
        example.createCriteria()
                .andProjectNameEqualTo(resApplication.getProjectName())
                .andProjectUserIdEqualTo(resApplication.getUserId());
        List<ProjectMember> members = projectMemberMapper
                .selectByExample(example);
        List<ProjectMembers> resMembers = new LinkedList<>();
        //先添加负责人的信息
        ProjectMembers firstMember = new ProjectMembers();
        firstMember.setDepartment(resApplication.getDepartment());
        firstMember.setMail(resApplication.getMail());
        firstMember.setPhone(resApplication.getPhone());
        firstMember.setUserId(resApplication.getUserId());
        firstMember.setUserName(resApplication.getUserName());
        resMembers.add(firstMember);
        for(ProjectMember member : members) {
            ProjectMembers resMember = new ProjectMembers();
            resMember.setDepartment(member.getDepartment());
            resMember.setMail(member.getMail());
            resMember.setPhone(member.getPhone());
            resMember.setUserId(member.getUserId());
            resMember.setUserName(member.getUserName());
            resMembers.add(resMember);
        }
        ReviewExpertExample expertExample = new ReviewExpertExample();
        expertExample.createCriteria()
                .andProjectApplicationIdEqualTo(applicationId);
        List<ReviewExpert> list = reviewExpertMapper.selectByExample(expertExample);
        if(!list.isEmpty()) {
            List<ExpertListInfo> resList = new LinkedList<>();
            for(ReviewExpert expert : list) {
                User user = userMapper.selectByPrimaryKey(expert.getExpertId());
                ExpertListInfo info = new ExpertListInfo();
                info.setDepartment(user.getDepartment());
                info.setMail(user.getMail());
                info.setPhone(user.getPhone());
                info.setUserId(user.getUserId());
                info.setUserName(user.getUserName());
                resList.add(info);
            }
            res.setExpertList(resList);
        }
        res.setMembers(resMembers);
        return ResultTool.success(res);

    }

    /**
     * @Description: 用户提交中期报告或者结题报告
     * @Param: [info]
     * @Return: com.management.model.ov.Result
     * @Author: 0GGmr0
     * @Date: 2019-01-14
     */
    @Override
    public Result commitReport(PostReportInfo info) {
        ProjectProgress application = projectProgressMapper.selectByPrimaryKey(info.getApplicationId());
        int status = info.getStatus();
        if(status == 2) {
            return ResultTool.error("已超过提交报告的时间");
        } else if(status == 3) {
            return ResultTool.error("时间未到");
        }
        if(info.getType() == 1) {
            application.setIsFinishedInterimReport(1);
            application.setInterimReportUploadAddress(info.getUploadAddress());
            application.setInterimReportTime(new Date());
            application.setProjectProcess(MIDDLE_PROGRESS);
        } else {
            application.setIsFinishedConcludingReport(1);
            application.setConcludingReportUploadAddress(info.getUploadAddress());
            application.setConcludingReportTime(new Date());
            application.setProjectProcess(FINAL_PROGRESS);
        }
        projectProgressMapper.updateByPrimaryKeySelective(application);
        return ResultTool.success();
    }

    @Override
    public Result findUserInfo(String userId) {
        User user = AuthTool.getInfo(userId);
        //如果返回了newUser，说明操作正常
        if (user != null) {
            OtherUserInfo info = new OtherUserInfo();
            info.setDepartment(user.getDepartment());
            info.setUserId(user.getUserId());
            info.setUsername(user.getUserName());
            return ResultTool.success(info);
            //如果没有得到newUser，说明验证异常
        } else {
            return ResultTool.error("验证过程中发生异常,一般是由于工号/学号无效!");
        }
    }

    /**
     * @Description: 用户提交任务书
     * @Param: [ProjectIndex]
     * @Return: Result
     * @Author: xw
     * @Date: 19-1-26
     */
    @Override
    public Result commitProjectIndex(ProjectIndex projectIndex){
        try{
            ProjectApplication projectApplication = projectApplicationMapper
                    .selectByPrimaryKey(projectIndex.getProjectApplicationId());
            projectApplication.setProjectIndex(projectIndex.getProjectIndex());
            if(projectApplication.getProjectMoney()!=null){
                projectApplication.setProjectMoney(projectIndex.getProjectMoney());
            }
            projectApplication.setReviewPhase(8);
            projectApplicationMapper.updateByPrimaryKey(projectApplication);
            return ResultTool.success();
        }catch (Exception e){
            return ResultTool.error("提交失败");
        }
    }

    /**
     * @Description: 用户查询所有被驳回的项目申请,包括未立项和已经立项的项目
     * @Param: [userId]
     * @Return: Result
     * @Author: xw
     * @Date: 19-1-26
     */
    @Override
    public Result queryFailProject(String userId){
        UserFailProjectList userFailProjectList = new UserFailProjectList();
        List<UserFailProject> failApplicationProjects = new ArrayList<>();
        List<UserFailProject> failProgressProjects = new ArrayList<>();
        try{
            //查找到被驳回的项目申请
            List<ProjectApplication> applicationList = projectApplicationMapper.selectFailProjectApplication(userId);
            for(ProjectApplication application: applicationList){
                UserFailProject userFailProject = new UserFailProject();
                userFailProject.setProjectName(application.getProjectName());
                userFailProject.setTime(timetoString(application.getApplicationTime()));
                userFailProject.setDescription(application.getProjectDescription());
                userFailProject.setReviewPhase(ConstCorrespond.reviewPhrase[application.getReviewPhase()]);
                userFailProject.setFailMessage(application.getFailureReason());
                failApplicationProjects.add(userFailProject);
            }

            //查找到已经立项的被驳回的项目(结题报告审核失败)
            ProjectProgressExample example1= new ProjectProgressExample();
            example1.createCriteria()
                    .andUserIdEqualTo(userId)
                    .andProjectProcessEqualTo(5);
            List<ProjectProgress> projectProgressList = projectProgressMapper.selectByExample(example1);
            for(ProjectProgress projectProgress: projectProgressList){
                UserFailProject userFailProject = new UserFailProject();
                ProjectApplication projectApplication = projectApplicationMapper.selectByPrimaryKey(projectProgress.getProjectProgressId());
                userFailProject.setProjectName(projectApplication.getProjectName());
                userFailProject.setTime(timetoString(projectProgress.getProjectcreatetime()));
                userFailProject.setDescription(projectApplication.getProjectDescription());
                userFailProject.setReviewPhase(ConstCorrespond.PROJECT_PROGRESS[projectProgress.getProjectProcess()]);
                userFailProject.setFailMessage(projectProgress.getConcludingReportFailureReason());
                failProgressProjects.add(userFailProject);
            }

            userFailProjectList.setFailApplicationProjects(failApplicationProjects);
            userFailProjectList.setFailProgressProjects(failProgressProjects);
            return ResultTool.success(userFailProjectList);
        }catch (Exception e){
            return ResultTool.error("查询失败");
        }
    }
}
