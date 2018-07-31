package com.management.service.impl;

import com.management.dao.ProjectCategoryMapper;
import com.management.dao.UserMapper;
import com.management.model.OV.Result;
import com.management.model.jsonrequestbody.ProjectCategoryInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
     * @Param: projectCategoryInfo
     * @Return: Result
     * @Author: xw
     * @Date: 18-7-30
     */
    Result CreateProjectCategory(String userId, ProjectCategoryInfo projectCategoryInfo){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try{
            Date applicationStartTime = dateFormat.parse(projectCategoryInfo.getApplicationStartTime());
            Date applicationEndTime = dateFormat.parse(projectCategoryInfo.getApplicationEndTime());
            Date

        }catch(ParseException e){
            e.printStackTrace();
        }

    }
}
