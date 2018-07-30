package com.management.service.impl;

import com.management.dao.ProjectCategoryMapper;
import com.management.dao.UserMapper;

import javax.annotation.Resource;

public class AdminServiceImpl {
    @Resource
    private UserMapper userMapper;
    @Resource
    private ProjectCategoryMapper projectCategoryMapper;
}
