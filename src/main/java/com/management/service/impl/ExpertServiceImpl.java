package com.management.service.impl;

import com.management.dao.ProjectApplicationMapper;
import com.management.dao.ReviewExpertMapper;
import com.management.model.entity.ProjectApplication;
import com.management.model.entity.ReviewExpert;
import com.management.model.entity.ReviewExpertExample;
import com.management.model.ov.Result;
import com.management.model.ov.resultsetting.ExpertOpinionInfo;
import com.management.service.ExpertService;
import com.management.tools.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
