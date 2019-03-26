package com.management.dao;

import com.management.tools.MD5Tool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectApplicationMapperTest {
    @Resource
    private ProjectApplicationMapper projectApplicationMapper;
    @Resource
    private UserMapper userMapper;

    @Test
    public void queryAdminProjectApplication() {
        System.out.print(userMapper.selectUserInfoByUserId("user1"));
    }
}