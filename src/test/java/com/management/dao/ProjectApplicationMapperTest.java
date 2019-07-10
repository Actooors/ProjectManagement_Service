package com.management.dao;

import com.management.model.entity.ProjectApplication;
import com.management.model.jsonrequestbody.UpdateOrInsertUser;
import com.management.model.jsonrequestbody.UpdateProjectCategoryInfo;
import com.management.service.AdminService;
import com.management.service.SuperAdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectApplicationMapperTest {
    @Resource
    private ProjectApplicationMapper projectApplicationMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private AdminService adminService;

    @Resource
    private ProjectCategoryMapper projectCategoryMapper;

    @Resource
    private SuperAdminService superAdminService;

    @Test
    public void queryAdminProjectApplication() {
        //System.out.print(projectCategoryMapper.getAllProjectCategoryId());
        System.out.print(projectApplicationMapper.selectAllProjectApplication("16121666","3b7f100d-9f3b-4afd-8ed6-2ea845c88b26"));
    }
}