package com.management.service.impl;

import com.management.dao.ProjectCategoryMapper;
import com.management.dao.UserMapper;
import com.management.model.OV.Result;
import com.management.model.entity.ProjectCategory;
import com.management.model.entity.ProjectCategoryExample;
import com.management.model.entity.User;
import com.management.model.jsonrequestbody.ProjectCategoryInfo;
import com.management.tools.ResultTool;
import com.management.tools.TimeTool;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public Result createProjectCategory(String userId, ProjectCategoryInfo projectCategoryInfo){
        /*将字符串时间格式转化为Date时间类型*/
        Date applicationStartTime = TimeTool.stringToTime(projectCategoryInfo.getApplicationStartTime());
        Date applicationEndTime = TimeTool.stringToTime(projectCategoryInfo.getApplicationEndTime());
        Date projectStartTime = TimeTool.stringToTime(projectCategoryInfo.getProjectStartTime());
        Date projectEndTime = TimeTool.stringToTime(projectCategoryInfo.getProjectEndTime());
        /*根据业务员id查询到业务员的信息及专家的id*/
        User adminuser = userMapper.selectByPrimaryKey(userId);
        User exportuser = userMapper.selectByPrimaryKey(projectCategoryInfo.getReviewLeaderId());
        ProjectCategory projectCategory = new ProjectCategory();
        try{
            projectCategory.setProjectCategoryName(projectCategoryInfo.getProjectName());
            projectCategory.setProjectCategoryDescription(projectCategoryInfo.getProjectDescription());
            projectCategory.setProjectApplicationDownloadAddress(projectCategoryInfo.getProjectApplicationDownloadAddress());
            projectCategory.setProjectType(projectCategoryInfo.getProjectType());
            projectCategory.setPrincipalId(adminuser.getUserId());
            projectCategory.setPrincipalName(adminuser.getUserName());
            projectCategory.setPrincipalPhone(projectCategoryInfo.getPrincipalPhone());
            projectCategory.setApplicantType(projectCategoryInfo.getApplicantType());
            projectCategory.setMaxMoney(projectCategoryInfo.getMaxMoney());
            projectCategory.setProjectCategoryDescriptionAddress(projectCategoryInfo.getProjectDescriptionAddress());
            projectCategory.setReviewLeaderId(projectCategoryInfo.getReviewLeaderId());
            projectCategory.setReviewLeaderName(exportuser.getUserName());
            projectCategory.setIsExistMeetingReview(projectCategoryInfo.getIsEexistMeetingReview());
            projectCategory.setApplicationStartTime(applicationStartTime);
            projectCategory.setApplicationEndTime(applicationEndTime);
            projectCategory.setProjectStartTime(projectStartTime);
            projectCategory.setProjectEndTime(projectEndTime);
            projectCategoryMapper.insert(projectCategory);

            Result result = ResultTool.success();
            result.setMessage("成功");
            return result;
        }catch (Exception e){
            Result result = ResultTool.error();
            result.setMessage("失败");
            return result;
        }
    }
    
    /**
     * @Description: 业务员根据自己的ID查询创建的项目类别信息
     * @Param: userId
     * @Return: ProjectCategory
     * @Author: xw
     * @Date: 18-7-31
     */
     public Result queryProjectCategory(String userId){
         ProjectCategoryExample projectCategoryExample = new ProjectCategoryExample();
         try{
             projectCategoryExample.createCriteria()
                     .andPrincipalIdEqualTo(userId);
             List<ProjectCategory> projectCategoryList = projectCategoryMapper.selectByExample(projectCategoryExample);
             Result result = ResultTool.success(projectCategoryList);
             result.setMessage("成功");
             return result;
         }catch (Exception e){
             Result result = ResultTool.error();
             result.setMessage("失败");
             return result;
         }
     }



}
