package com.management.service.impl;

import com.management.dao.ProjectApplicationMapper;
import com.management.dao.ProjectCategoryMapper;
import com.management.dao.ReviewExpertMapper;
import com.management.model.entity.*;
import com.management.model.jsonrequestbody.ExpertJudgeInfo;
import com.management.model.jsonrequestbody.ProjectApplicationInfo;
import com.management.model.ov.Result;
import com.management.service.ExpertService;
import com.management.tools.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: management
 * @description: ExpertService接口的实现
 * @author: ggmr
 * @create: 2018-08-01 16:50
 */
@Service
public class ExpertServiceImpl implements ExpertService {

    @Resource
    private ProjectApplicationMapper projectApplicationMapper;

    @Resource
    private ProjectCategoryMapper projectCategoryMapper;

    @Resource
    private ReviewExpertMapper reviewExpertMapper;

    private static final int IS_FINISHED=1;
    private static final int NOT_FINISHED=2;

    /**
     * @Description: findProjectApplication接口的实现
     * @Param: [userID]
     * @Return: com.management.model.ov.Result
     * @Author: xw
     * @Date: 18-12-25
     */
    @Override
    public Result findProjectApplication(String userId) {
        List<ProjectApplicationInfo> projectApplicationList = new ArrayList<>();
        try {
            //在ReviewExpert表中找到expertId=userId且状态为2的待审核的信息
            ReviewExpertExample example = new ReviewExpertExample();
            example.createCriteria()
                    .andExpertIdEqualTo(userId)
                    .andIsFinishedEqualTo(2);
            List<ReviewExpert> ReviewExpertList = reviewExpertMapper.selectByExample(example);
            for (ReviewExpert reviewExpert : ReviewExpertList) {
                //根据projectApplicationId找到属于此大类的项目申请信息
                ProjectApplication projectApplication = projectApplicationMapper.selectByPrimaryKey(reviewExpert.getProjectApplicationId());
                if (projectApplication.getReviewPhase() == 2) {
                    ProjectApplicationInfo projectInfo = new ProjectApplicationInfo();
                    projectInfo.setUserId(projectApplication.getUserId());
                    projectInfo.setUserName(projectApplication.getUserName());
                    ProjectCategory projectCategory = projectCategoryMapper.selectByPrimaryKey(projectApplication.getProjectCategoryId());
                    projectInfo.setProjectCategoryName(projectCategory.getProjectCategoryName());
                    projectInfo.setProjectName(projectApplication.getProjectName());
                    projectInfo.setProjectApplicationId(projectApplication.getProjectApplicationId());
                    projectInfo.setDescription(projectApplication.getProjectDescription());
                    projectInfo.setDepartment(projectApplication.getDepartment());
                    projectInfo.setProjectMoney(projectApplication.getProjectMoney());
                    projectInfo.setUploadAddress(projectApplication.getProjectApplicationUploadAddress());
                    if (projectApplication.getIsMeeting() == 1) {
                        projectInfo.setIsMeeting(true);
                    } else {
                        projectInfo.setIsMeeting(false);
                    }
                    projectApplicationList.add(projectInfo);
                }
            }
            return ResultTool.success(projectApplicationList);
        } catch (Exception e) {
            return ResultTool.error("暂无待审核项目申请");
        }
    }

    /**
     * @Description: 专家审核项目申请并提交审核意见
     * @Param: [projectApplicationId]
     * @Return: Result
     * @Author: xw
     * @Date: 18-12-26
     */
    @Override
    public Result judgeProjectApplication(String userId, ExpertJudgeInfo expertJudgeInfo) {
        try {
            //根据专家id和申请id查找到相应对象进行插入信息(查找对象并未完成评审)
            ReviewExpertExample example = new ReviewExpertExample();
            example.createCriteria()
                    .andExpertIdEqualTo(userId)
                    .andProjectApplicationIdEqualTo(expertJudgeInfo.getProjectApplicationId())
                    .andIsFinishedEqualTo(NOT_FINISHED);
            List<ReviewExpert> reviewExpertList = reviewExpertMapper.selectByExample(example);
            for(ReviewExpert reviewExpert: reviewExpertList){
                //将专家评审信息插入
                reviewExpert.setScore(expertJudgeInfo.getScore());
                reviewExpert.setReviewOpinion(expertJudgeInfo.getReviewOpinion());
                reviewExpert.setFinalOpinion(Integer.parseInt(expertJudgeInfo.getFinalOPinion()));
                reviewExpert.setIsFinished(IS_FINISHED);
                reviewExpertMapper.updateByPrimaryKey(reviewExpert);
            }
            return ResultTool.success();

        }catch (Exception e){
            return ResultTool.error("评审失败!");
        }
    }
}
