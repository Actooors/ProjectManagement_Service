package com.management.service.impl;

import com.management.dao.ProjectApplicationMapper;
import com.management.dao.ProjectCategoryMapper;
import com.management.dao.ProjectProgressMapper;
import com.management.dao.UserMapper;
import com.management.model.entity.*;
import com.management.model.jsonrequestbody.IsProjectCategoryPassedPostInfo;
import com.management.model.jsonrequestbody.LeaderJudgeInfo;
import com.management.model.ov.Result;
import com.management.model.ov.resultsetting.AdminJudgeTotalInfo;
import com.management.model.ov.resultsetting.FinalReportInfo;
import com.management.model.ov.resultsetting.LeaderSubordinateInfo;
import com.management.model.ov.resultsetting.WaitJudgeProjectCategoryInfo;
import com.management.service.LeaderService;
import com.management.tools.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static com.management.model.ov.resultsetting.ConstCorrespond.*;
import static com.management.tools.TimeTool.timetoString;

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
    private ProjectProgressMapper projectProgressMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private AdminServiceImpl adminService;

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

        ProjectCategoryExample example = new ProjectCategoryExample();
        example.createCriteria()
                .andReviewLeaderIdEqualTo(userId)
                .andApplicationEndTimeGreaterThan(new Date());
        List<ProjectCategory> list = projectCategoryMapper.selectByExample(example);
        if(list.isEmpty()) {
            return ResultTool.error("您没有下属业务员创建项目大类");
        }
        List<AdminJudgeTotalInfo> resList = new LinkedList<>();
        for(ProjectCategory category : list) {
            ProjectApplicationExample applicationExample = new ProjectApplicationExample();
            applicationExample.createCriteria()
                    .andProjectCategoryIdEqualTo(category.getProjectCategoryId())
                    .andReviewPhaseEqualTo(4);
            List<ProjectApplication> applicationList = projectApplicationMapper
                    .selectByExample(applicationExample);
            if (applicationList.isEmpty()) continue;
            for (ProjectApplication application : applicationList) {
                AdminJudgeTotalInfo res = new AdminJudgeTotalInfo();
                res.setApplicationDeadLine(timetoString(category.getApplicationEndTime()));
                res.setProjectCategoryId(category.getProjectCategoryId());
                res.setProjectCategoryName(category.getProjectCategoryName());
                res.setProjectId(application.getProjectApplicationId());
                res.setProjectApplicationDownloadAddress(application.getProjectApplicationUploadAddress());
                res.setProjectName(application.getProjectName());
                res.setDescription(application.getProjectDescription());
                res.setExpertOpinion(adminService.getExpertOpinionList(application.getProjectApplicationId()));
                resList.add(res);
            }
        }
        return ResultTool.success(resList);

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
            if(leaderJudgeInfo.getJudge()){
                projectApplication.setReviewPhase(5);

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

    @Override
    public Result judgeFinalReport(LeaderJudgeInfo info) {
        ProjectProgress projectProgress = projectProgressMapper.selectByPrimaryKey(info.getProjectApplicationId());
        if(info.getJudge()) {
            projectProgress.setProjectProcess(FINISH_PROJECT);
        } else {
            projectProgress.setProjectProcess(FINISH_PROGRESS_FAILED);
            projectProgress.setConcludingReportFailureReason(info.getMsg());
            projectProgress.setIsFinishedConcludingReport(2);
        }
        projectProgressMapper.updateByPrimaryKeySelective(projectProgress);
        return ResultTool.success();
    }

    @Override
    public Result findWaitFinalJudgeList(String leaderId) {
        ProjectCategoryExample example = new ProjectCategoryExample();
        example.createCriteria()
                .andReviewLeaderIdEqualTo(leaderId);
        List<ProjectCategory> categoryList = projectCategoryMapper.selectByExample(example);
        if(categoryList.isEmpty()) {
            return ResultTool.success("没有待终审项目");
        }
        List<FinalReportInfo> resList = new LinkedList<>();
        for(ProjectCategory projectCategory : categoryList) {
            ProjectProgressExample example1 = new ProjectProgressExample();
            example1.createCriteria()
                    .andProjectCategoryIdEqualTo(projectCategory.getProjectCategoryId())
                    .andProjectProcessEqualTo(FINAL_PROGRESS);
            List<ProjectProgress> progressList = projectProgressMapper.selectByExample(example1);
            if(progressList.isEmpty()) continue;
            for(ProjectProgress progress : progressList) {
                FinalReportInfo info = new FinalReportInfo();
                info.setDepartment(progress.getDepartment());
                info.setDescription(progress.getDescription());
                info.setProjectId(progress.getProjectProgressId());
                info.setProjectCategoryId(progress.getProjectCategoryId());
                info.setProjectCategoryName(progress.getProjectName());
                info.setProjectName(progress.getProjectName());
                info.setProjectApplicationDownloadAddress(projectApplicationMapper.selectByPrimaryKey(progress.getProjectProgressId()).getProjectApplicationUploadAddress());
                info.setConcludingReportEndTime(timetoString(projectCategory.getConcludingReportEndTime()));
                //info.setReportAddress(progress.getConcludingReportUploadAddress());
                info.setExpertOpinion(adminService.getExpertOpinionList(progress.getProjectProgressId()));
                info.setUserId(progress.getUserId());
                info.setUserName(progress.getUserName());
                resList.add(info);
            }
        }
        return ResultTool.success(resList);

    }
}
