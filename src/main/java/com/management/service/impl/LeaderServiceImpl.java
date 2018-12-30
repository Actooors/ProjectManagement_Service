package com.management.service.impl;

import com.management.dao.ProjectApplicationMapper;
import com.management.dao.ProjectCategoryMapper;
import com.management.dao.UserMapper;
import com.management.model.entity.*;
import com.management.model.jsonrequestbody.IsProjectCategoryPassedPostInfo;
import com.management.model.jsonrequestbody.LeaderJudgeInfo;
import com.management.model.jsonrequestbody.ProjectApplicationInfo;
import com.management.model.ov.Result;
import com.management.model.ov.resultsetting.LeaderSubordinateInfo;
import com.management.model.ov.resultsetting.WaitJudgeProjectCategoryInfo;
import com.management.service.LeaderService;
import com.management.tools.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: management
 * @description: 领导层接口的实现
 * @author: ggmr
 * @create: 2018-07-31 09:34
 */
@Service
public class LeaderServiceImpl implements LeaderService {
    @Resource
    private ProjectCategoryMapper projectCategoryMapper;

    @Resource
    private ProjectApplicationMapper projectApplicationMapper;

    @Resource
    private UserMapper userMapper;


    private static final int STATE_TWO = 2;
    private static final int STATE_THREE = 3;
    /**
     * @Description: isProjectCategoryPassed接口的实现
     * @Param: [info]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-15
     */
    @Override
    public Result isProjectCategoryPassed(IsProjectCategoryPassedPostInfo info) {
        Integer projectCategoryId = info.getProjectCategoryId();
        ProjectCategory projectCategory = projectCategoryMapper.selectByPrimaryKey(projectCategoryId);
        if(projectCategory == null) {
            return ResultTool.error("不存在这个id的项目大类");
        }
        Integer isPassed = info.getIsPassed();
        if(isPassed == STATE_TWO) {
            projectCategory.setFailureReason(info.getMessage());
        }
        projectCategory.setIsApproved(isPassed);
        projectCategoryMapper.updateByPrimaryKeySelective(projectCategory);
        return ResultTool.success();
    }

    /**
     * @Description: findAllSubordinate的实现
     * @Param: [leaderId]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-15
     */
    @Override
    public Result findAllSubordinate(String leaderId) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andLeaderIdEqualTo(leaderId);
        List<User> list = userMapper.selectByExample(userExample);
        if(list.isEmpty()) {
            return ResultTool.error("领导并没有业务员下属");
        }
        List<LeaderSubordinateInfo> resList = new LinkedList<>();
        for(User user : list) {
            LeaderSubordinateInfo res = new LeaderSubordinateInfo();
            res.setPhone(user.getPhone());
            res.setUserId(user.getUserId());
            res.setUserName(user.getUserName());
            resList.add(res);
        }
        return ResultTool.success(resList);
    }

    /**
     * @Description: waitJudgeProjectCategoryList接口的实现
     * @Param: [userId]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-15
     */
    @Override
    public Result waitJudgeProjectCategoryList(String leaderId) {
        ProjectCategoryExample pExacmple = new ProjectCategoryExample();
        pExacmple.createCriteria()
                .andReviewLeaderIdEqualTo(leaderId)
                .andIsApprovedEqualTo(STATE_THREE);
        List<ProjectCategory> list = projectCategoryMapper.selectByExample(pExacmple);
        if(list.isEmpty()) {
            return ResultTool.error("当前并没有需要处理的项目大类申请");
        }
        List<WaitJudgeProjectCategoryInfo> resList = new LinkedList<>();
        for(ProjectCategory projectCategory : list) {
            WaitJudgeProjectCategoryInfo res = new WaitJudgeProjectCategoryInfo();
            res.setAdminId(projectCategory.getPrincipalId());
            res.setAdminName(projectCategory.getPrincipalName());
            res.setProjectCategoryId(projectCategory.getProjectCategoryId());
            res.setProjectCategoryName(projectCategory.getProjectCategoryName());
            res.setType(projectCategory.getProjectType());
            resList.add(res);
        }
        return ResultTool.success(resList);
    }

    /**
     * @Description: 查找待审核的项目申请信息
     * @Param: [userId]
     * @Return: com.management.model.ov.Result
     * @Author: xw
     * @Date: 18-12-27
     */
    public Result findUnJudgeProjectApplication(String userId){
        List<ProjectApplicationInfo> proList = new ArrayList<>();
        try {
            //根据Leaderid得到其负责的且审核通过的项目大类id
            ProjectCategoryExample example1 = new ProjectCategoryExample();
            example1.createCriteria()
                    .andReviewLeaderIdEqualTo(userId)
                    .andIsApprovedEqualTo(1);
            List<ProjectCategory> projectCategoryList = projectCategoryMapper.selectByExample(example1);
            //根据项目大类id在application表中查找相应的项目申请信息
            for (ProjectCategory projectCategory : projectCategoryList) {
                ProjectApplicationExample example = new ProjectApplicationExample();
                example.createCriteria()
                        .andProjectCategoryIdEqualTo(projectCategory.getProjectCategoryId())
                        .andReviewPhaseEqualTo(4);
                List<ProjectApplication> projectApplicationList = projectApplicationMapper.selectByExample(example);
                if(projectApplicationList!=null){
                    for (ProjectApplication projectApplication : projectApplicationList) {
                        ProjectApplicationInfo projectInfo = new ProjectApplicationInfo();
                        projectInfo.setUserId(projectApplication.getUserId());
                        projectInfo.setUserName(projectApplication.getUserName());
                        projectInfo.setProjectCategoryName(projectCategoryMapper.selectByPrimaryKey(projectApplication.getProjectCategoryId()).getProjectCategoryName());
                        projectInfo.setProjectName(projectApplication.getProjectName());
                        projectInfo.setProjectApplicationId(projectApplication.getProjectApplicationId());
                        projectInfo.setDescription(projectApplication.getProjectDescription());
                        projectInfo.setDepartment(projectApplication.getDepartment());
                        projectInfo.setUploadAddress(projectApplication.getProjectApplicationUploadAddress());
                        proList.add(projectInfo);
                    }
                }else{
                    return ResultTool.error("暂无待审核信息!");
                }
            }
            return ResultTool.success(proList);
        }catch (Exception e){
            return ResultTool.error("查询失败!");
        }

    }

    /**
     * @Description: 领导审核待审核的用户项目申请
     * @Param: [projectApplicationId]
     * @Return: Result
     * @Author: xw
     * @Date: 18-12-27
     */
    @Override
    public Result judgeProjectApplication(LeaderJudgeInfo leaderJudgeInfo){
        try{
            ProjectApplication projectApplication = projectApplicationMapper.selectByPrimaryKey(leaderJudgeInfo.getProjectApplicationId());
            if(leaderJudgeInfo.getJudge().equals(true)){
                projectApplication.setReviewPhase(5);
            }else {
                projectApplication.setReviewPhase(6);
                projectApplication.setFailureReason(leaderJudgeInfo.getMsg());
            }
            projectApplicationMapper.updateByPrimaryKey(projectApplication);

            return ResultTool.success();
        }catch (Exception e){
            return ResultTool.error("操作失败!");
        }
    }

}
