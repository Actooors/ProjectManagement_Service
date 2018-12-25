package com.management.service.impl;

import com.management.dao.ProjectApplicationMapper;
import com.management.dao.ProjectCategoryExpertMapper;
import com.management.dao.ReviewExpertMapper;
import com.management.model.entity.*;
import com.management.model.jsonrequestbody.ProjectApplicationInfo;
import com.management.model.jsonrequestbody.ProjectCategoryInfo;
import com.management.model.ov.Result;
import com.management.model.ov.resultsetting.ExpertOpinionInfo;
import com.management.service.ExpertService;
import com.management.tools.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
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
    protected ProjectCategoryExpertMapper projectCategoryExpertMapper;

    @Resource
    private ReviewExpertMapper reviewExpertMapper;
    /**
     * @Description: expertOpinionList接口的实现
     * @Param: [projectId]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-1
     */
    @Override
    public Result expertOpinionList(int projectId) {
        ProjectApplication projectApplication = projectApplicationMapper.selectByPrimaryKey(projectId);
        if(projectApplication == null) {
            return ResultTool.error("给予的项目id有误");
        }
        ReviewExpertExample reviewExpertExample = new ReviewExpertExample();
        reviewExpertExample.createCriteria()
                .andProjectApplicationIdEqualTo(projectId);
        List<ReviewExpert> reviewExpertList = reviewExpertMapper.selectByExample(reviewExpertExample);
        List<ExpertOpinionInfo> list = new LinkedList<>();
        for(ReviewExpert reviewExpert : reviewExpertList) {
            ExpertOpinionInfo expertOpinionInfo = new ExpertOpinionInfo();
            expertOpinionInfo.setExpertId(reviewExpert.getExpertId());
            expertOpinionInfo.setExpertName(reviewExpert.getExpertName());
            expertOpinionInfo.setFinalOpinion(reviewExpert.getFinalOpinion());
            expertOpinionInfo.setReviewOpinion(reviewExpert.getReviewOpinion());
            expertOpinionInfo.setScore(reviewExpert.getScore());
            list.add(expertOpinionInfo);
        }
        return ResultTool.success(list);
    }

    /**
     * @Description: findProjectApplication接口的实现
     * @Param: [userID]
     * @Return: com.management.model.ov.Result
     * @Author: xw
     * @Date: 18-12-25
     */
    @Override
    public Result findProjectApplication(String userId){
        List<ProjectApplication> projectApplicationList = new ArrayList<>();
        //首先找到专家负责的项目大类
        ProjectCategoryExpertExample example = new ProjectCategoryExpertExample();
        example.createCriteria()
                .andExpertIdEqualTo(userId);
        try {
            List<ProjectCategoryExpert> projectCategoryExpertList = projectCategoryExpertMapper.selectByExample(example);
            for (ProjectCategoryExpert projectCategoryExpert : projectCategoryExpertList) {
                //根据projectCateId找到属于此大类的项目申请信息
                ProjectApplication projectApplication = projectApplicationMapper.selectByProjectCategoryId(projectCategoryExpert.getProjectCategoryId());
                if (projectApplication.getReviewPhase() == 2) {
                    ProjectApplicationInfo projectInfo = new ProjectApplicationInfo();
                    projectInfo.setUserId(projectApplication.getUserId());
                    projectInfo.setUserName(projectApplication.getUserName());
                    projectInfo.setProjectCategoryId(projectApplication.getProjectApplicationId());
                    projectInfo.setProjectName(projectApplication.getProjectName());
                    projectInfo.setDepartment(projectApplication.getDepartment());
                    projectInfo.setUploadAddress(projectApplication.getProjectApplicationUploadAddress());
                    if(projectApplication.getIsMeeting()==1){
                        projectInfo.setIsMeeting(true);
                    }else {
                        projectInfo.setIsMeeting(false);
                    }
                    projectApplicationList.add(projectApplication);
                }
            }
        }catch(Exception e){
            return ResultTool.error("暂无待审核项目申请");
        }

        return ResultTool.success(projectApplicationList);

    }
}
