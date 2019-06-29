package com.management.dao;

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
    private SuperAdminService superAdminService;

    @Test
    public void queryAdminProjectApplication() {
        //System.out.print(userMapper.selectAllUserInfo((1-1)*10));
        //System.out.print(superAdminService.getUserInfo());
//        List<String> identity = new ArrayList<>(Arrays.asList("user","leader"));
//        UpdateOrInsertUser updateOrInsertUser = new UpdateOrInsertUser();
//        updateOrInsertUser.setUserId("12112");
//        updateOrInsertUser.setUserName("xxxx");
//        updateOrInsertUser.setPassword("11111");
//        updateOrInsertUser.setIdentity(identity);
//        System.out.print(superAdminService.insertUser(updateOrInsertUser));
        System.out.print(projectApplicationMapper.selectMyApplication("user1"));
    }
}