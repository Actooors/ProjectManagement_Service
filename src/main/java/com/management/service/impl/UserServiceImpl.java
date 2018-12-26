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
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static com.management.model.ov.resultsetting.ConstCorrespond.FINAL_PROGRESS;
import static com.management.model.ov.resultsetting.ConstCorrespond.MIDDLE_PROGRESS;
import static com.management.tools.TimeTool.timeToString1;

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

    private static final int LOGIN_ENABLE = 1;
    private static final int STATE_TWO = 2;
    private static final int REVIEW_FAILED = 6;
    private static final int REVIEW_LAST_PHASE = 5;
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
        response.setToken(JwtUtil.createJwt(userId));
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
                    info.setType(ConstCorrespond.projectType[i]);
                    info.setDeadLine(timeToString1(p.getApplicationEndTime()));
                    info.setIntroduce(p.getProjectCategoryDescription());
                    info.setProjectId(p.getProjectCategoryId());
                    info.setProjectName(p.getProjectCategoryName());
                    info.setIsMeeting(p.getIsExistMeetingReview() == 1 ? "true":"false");
                    info.setDownLoadAddress(ConstCorrespond.downloadAddress +
                            p.getProjectCategoryDescriptionAddress());
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
            if(application.getReviewPhase() != REVIEW_LAST_PHASE) {
                ProjectTotalInfo res = new ProjectTotalInfo();
                res.setTime(TimeTool.timeToString1(application.getApplicationTime()));
                res.setProjectApplicationId(application.getProjectApplicationId());
                res.setProjectName(application.getProjectName());
                res.setReviewPhase(ConstCorrespond
                        .reviewPhrase[application.getReviewPhase()]);
                res.setDescription(application.getProjectDescription());
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

        FindProgressProjectInfo res = new FindProgressProjectInfo();
        for(ProjectApplication application : resBigList) {
            ProjectProgress progress = projectProgressMapper
                    .selectByPrimaryKey(application.getProjectApplicationId());
            ProjectTotalInfo info = new ProjectTotalInfo();
            info.setDescription(application.getProjectDescription());
            info.setProjectApplicationId(application.getProjectApplicationId());
            info.setProjectName(application.getProjectName());
            info.setReviewPhase(ConstCorrespond
                    .PROJECT_PROGRESS[progress.getProjectProcess()]);
            if(progress.getProjectProcess() == 2) {
                info.setTime(timeToString1(application.getMiddleDeadline()));
                middleProject.add(info);
            } else if(progress.getProjectProcess() == 3) {
                info.setTime(timeToString1(application.getFinalDeadline()));
                finalProject.add(info);
            } else if(progress.getProjectProcess() == 4){
                info.setTime(timeToString1(application.getProjectDeadline()));
                finishProject.add(info);
            } else {
                info.setTime(timeToString1(application.getProjectDeadline()));
                buildProject.add(info);
            }
        }
        res.setBuildProject(buildProject);
        res.setMiddleProject(middleProject);
        res.setFinalProject(finalProject);
        res.setFinishProject(finishProject);
        return ResultTool.success(res);
    }

    @Override
    public Result commitReport(CommitInfo info) {
        ProjectProgress progress = projectProgressMapper
                .selectByPrimaryKey(info.getApplicationId());
        String uploadAddress = info.getUploadAddress();
        int type = info.getType();
        if(type == 1) {
            //中期报告
            progress.setInterimReportUploadAddress(uploadAddress);
            progress.setIsFinishedInterimReport(1);
            progress.setInterimReportTime(new Date());
            progress.setProjectProcess(FINAL_PROGRESS);
        } else if(type == 2) {
            //结题报告
            progress.setConcludingReportUploadAddress(uploadAddress);
            progress.setConcludingReportTime(new Date());
            progress.setIsFinishedConcludingReport(1);
        }
        projectProgressMapper.updateByPrimaryKeySelective(progress);
        return ResultTool.success();
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
        if(resProgress.getIsFinishedInterimReport() == 1) {
            res.setInterimAddress(ConstCorrespond.downloadAddress +
                    resProgress.getInterimReportUploadAddress());
        }
        if(resProgress.getIsFinishedConcludingReport() == 1) {
            res.setConcludingAddress(ConstCorrespond.downloadAddress +
                    resProgress.getConcludingReportUploadAddress());
        }
        res.setDescription(resApplication.getProjectDescription());
        res.setProjectName(resApplication.getProjectName());
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
        res.setMembers(resMembers);
        return ResultTool.success(res);

    }

}
