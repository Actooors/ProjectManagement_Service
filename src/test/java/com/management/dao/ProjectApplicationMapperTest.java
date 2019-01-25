package com.management.dao;

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

    @Test
    public void queryAdminProjectApplication() {
       // System.out.print(projectApplicationMapper.queryAllProgressProject("16122131"));
    }
}