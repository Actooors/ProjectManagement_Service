package com.management.service.impl;

import com.management.dao.ProjectCategoryMapper;
import com.management.dao.UserMapper;
import com.management.model.entity.ProjectCategory;
import com.management.model.entity.ProjectCategoryExample;
import com.management.model.entity.User;
import com.management.model.entity.UserExample;
import com.management.model.jsonrequestbody.IsProjectCategoryPassedPostInfo;
import com.management.model.ov.Result;
import com.management.model.ov.resultsetting.LeaderSubordinateInfo;
import com.management.service.LeaderService;
import com.management.tools.ResultTool;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
    private UserMapper userMapper;
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
}
