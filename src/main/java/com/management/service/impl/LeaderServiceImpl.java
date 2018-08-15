package com.management.service.impl;

import com.management.dao.ProjectCategoryMapper;
import com.management.model.entity.ProjectCategory;
import com.management.model.jsonrequestbody.IsProjectCategoryPassedPostInfo;
import com.management.model.ov.Result;
import com.management.service.LeaderService;
import com.management.tools.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
        if(isPassed == 2) {
            projectCategory.setFailureReason(info.getMessage());
        }
        projectCategory.setIsApproved(isPassed);
        projectCategoryMapper.updateByPrimaryKeySelective(projectCategory);
        return ResultTool.success();
    }
}
