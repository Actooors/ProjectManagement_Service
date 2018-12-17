package com.management.service.impl;

import com.management.dao.ProjectApplicationMapper;
import com.management.dao.ProjectCategoryMapper;
import com.management.dao.UserMapper;
import com.management.model.entity.*;
import com.management.model.jsonrequestbody.IsProjectPassedPostInfo;
import com.management.model.ov.Result;
import com.management.model.ov.resultsetting.*;
import com.management.model.jsonrequestbody.LoginInfo;
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

    private static final int LOGIN_ENABLE = 1;
    private static final int STATE_TWO = 2;
    private static final int REVIEW_FAILED = 6;
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
        if(loginUser == null || loginUser.getUserId() == null || "".equals(loginUser.getUserId())
             || "".equals(loginUser.getPassword()) ||loginUser.getPassword() == null) {
            return ResultTool.error("账号或密码不能为空");
        }
        User existedUser = userMapper.selectByPrimaryKey(loginUser.getUserId());
        //如果该账户在数据库已经存在
        if (existedUser != null) {
            //如果该账户的账号密码验证正确并且可以登录
            if (AuthTool.getAuth(loginUser.getUserId(), loginUser.getPassword()) &&
                    existedUser.getIsAbleLogin() == LOGIN_ENABLE ) {
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
        if(projectCategory == null) {
            return ResultTool.error("不存在这个id的项目大类");
        } else {
            int isTimeOut = 1;
            Date cur = new Date(),
                      compareTime;
            switch (type) {
                case 1: compareTime = projectCategory.getApplicationEndTime(); break;
                case 2: compareTime = projectCategory.getInterimReportEndTime(); break;
                case 3: compareTime = projectCategory.getConcludingReportEndTime(); break;
                case 4: compareTime = projectCategory.getProjectEndTime(); break;
                default: return ResultTool.error("给予的type类型有误");
            }
            if(cur.before(compareTime)) {
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
        if(projectCategoryList.isEmpty()) {
            return ResultTool.error("该类别没有可申报项目");
        }
        List<ProjectCategoryListInfo> list = new LinkedList<>();

        for(ProjectCategory projectCategory : projectCategoryList) {
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
        if(projectCategory == null) {
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
        if(list.isEmpty()) {
            return ResultTool.error("当前并没有需要审核的项目");
        }
        List<WaitJudgeProjectInfo> resList = new LinkedList<>();
        for(ProjectApplication projectApplication : list) {
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
        if(projectApplication == null) {
            return ResultTool.error("不存在这个id的项目");
        }
        int judge = info.getIsPassed();
        if(judge == STATE_TWO) {
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
        if(projectCategoryList.isEmpty()) {
            return ResultTool.success(new AviProjectCategoryInfoList());
        }
        //根据项目类别的int值排序
        Collections.sort(projectCategoryList);
        //获取到最大的项目类别
        int maxType = projectCategoryList.get(0).getProjectType();
        List<AviProjectCategoryInfoList> resList = new LinkedList<>();
        //根据排序好的结果，先遍历的创建包含这些type的内容，
        // 然后去遍历projectCategoryList内容找到符合当前条件的加进去
        for(int i = maxType, count = 0, len = projectCategoryList.size(); i >= 1; i--) {
            AviProjectCategoryInfoList singleList = new AviProjectCategoryInfoList();
            singleList.setType(ConstCorrespond.projectType[i]);
            List<AviProjectCategoryInfo> infoList = new LinkedList<>();
            for(;count < len; count++) {
                if(projectCategoryList.get(count).getProjectType() == i) {
                    AviProjectCategoryInfo info = new AviProjectCategoryInfo();
                    ProjectCategory p =  projectCategoryList.get(count);
                    info.setDeadLine(timeToString1(p.getApplicationEndTime()));
                    info.setIntroduce(p.getProjectCategoryDescription());
                    info.setProjectId(p.getProjectCategoryId());
                    info.setProjectName(p.getProjectCategoryName());
                    infoList.add(info);
                } else {
                    break;
                }
            }
            singleList.setProjectList(infoList);
            resList.add(singleList);
        }
        return ResultTool.success(resList);
    }


}
