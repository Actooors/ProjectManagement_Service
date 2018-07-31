package com.management.service.impl;

import com.management.dao.ProjectCategoryMapper;
import com.management.dao.UserMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @program: management
 * @description: 业务员层
 * @author: xw
 * @create: 2018-07-30 17:21
*/

@Service

public class AdminServiceImpl {
    @Resource
    private UserMapper userMapper;
    @Resource
    private ProjectCategoryMapper projectCategoryMapper;
    /**
     * @Description: 创建项目类别
     * @Param: 
     * @Return: 
     * @Author: xw
     * @Date: 18-7-30
     */
}
