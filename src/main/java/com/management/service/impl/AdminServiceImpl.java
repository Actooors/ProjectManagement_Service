package com.management.service.impl;

import com.management.dao.ProjectApplicationMapper;
import com.management.dao.ProjectCategoryMapper;
import com.management.dao.UserMapper;
import com.management.model.entity.ProjectApplication;
import com.management.model.entity.ProjectCategory;
import com.management.model.entity.ProjectCategoryExample;
import com.management.model.entity.User;
import com.management.model.jsonrequestbody.ChooseProjectMeeting;
import com.management.model.jsonrequestbody.UpdateProjectCategoryInfo;
import com.management.model.ov.Result;
import com.management.model.jsonrequestbody.ProjectCategoryInfo;
import com.management.model.ov.resultsetting.SomeoneAllProjectCategoryInfo;
import com.management.service.AdminService;
import com.management.tools.ResultTool;
import com.management.tools.TimeTool;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;

import static com.management.tools.TimeTool.timetoString;

/**
 * @program: management
 * @description: 业务员层
 * @author: xw
 * @create: 2018-07-30 17:21
*/

@Service

public class AdminServiceImpl implements AdminService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ProjectCategoryMapper projectCategoryMapper;

    @Resource
    private ProjectApplicationMapper projectApplicationMapper;

    private static final int MEETING_ENABLE = 1;
    private static final int MEETING_UNABLE = 2;
    private static final int REVIEW_FAILED = 6;
    /**
     * @Description: 创建项目类别
     * @Param: projectCategoryInfo
     * @Return: Result
     * @Author: xw
     * @Date: 18-7-30
     */
    @Override
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
            projectCategory.setIsExistMeetingReview(projectCategoryInfo.getIsExistMeetingReview());
            projectCategory.setIsInterimReportActivated(2);
            projectCategory.setApplicationStartTime(applicationStartTime);
            projectCategory.setApplicationEndTime(applicationEndTime);
            projectCategory.setProjectStartTime(projectStartTime);
            projectCategory.setProjectEndTime(projectEndTime);
            projectCategory.setStatistics(0);
            projectCategory.setIsApproved(2);
            projectCategory.setIsConcludingReportActivated(2);
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
     @Override
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

     /**
      * @Description: 根据项目号查找项目后更新内容
      * @Param: UpdateProjectCategoryInfo
      * @Return: Result
      * @Author: xw
      * @Date: 18-12-18
      */
     @Override
     public Result updateProjectCategoryInfo(UpdateProjectCategoryInfo updateProjectCategoryInfo){

         ProjectCategory projectCategory = projectCategoryMapper.selectByPrimaryKey(updateProjectCategoryInfo.getProjectCategoryId());
         ProjectCategoryInfo projectCategoryInfo = updateProjectCategoryInfo.getProjectCategoryInfo();
         /*将字符串时间格式转化为Date时间类型*/
         Date applicationStartTime = TimeTool.stringToTime(projectCategoryInfo.getApplicationStartTime());
         Date applicationEndTime = TimeTool.stringToTime(projectCategoryInfo.getApplicationEndTime());
         Date projectStartTime = TimeTool.stringToTime(projectCategoryInfo.getProjectStartTime());
         Date projectEndTime = TimeTool.stringToTime(projectCategoryInfo.getProjectEndTime());
         try{
             projectCategory.setProjectCategoryName(projectCategoryInfo.getProjectName());
             projectCategory.setProjectCategoryDescription(projectCategoryInfo.getProjectDescription());
             projectCategory.setProjectApplicationDownloadAddress(projectCategoryInfo.getProjectApplicationDownloadAddress());
             projectCategory.setProjectType(projectCategoryInfo.getProjectType());
             projectCategory.setPrincipalPhone(projectCategoryInfo.getPrincipalPhone());
             projectCategory.setApplicantType(projectCategoryInfo.getApplicantType());
             projectCategory.setMaxMoney(projectCategoryInfo.getMaxMoney());
             projectCategory.setProjectCategoryDescriptionAddress(projectCategoryInfo.getProjectDescriptionAddress());
             projectCategory.setReviewLeaderId(projectCategoryInfo.getReviewLeaderId());
             projectCategory.setIsExistMeetingReview(projectCategoryInfo.getIsExistMeetingReview());
             projectCategory.setApplicationStartTime(applicationStartTime);
             projectCategory.setApplicationEndTime(applicationEndTime);
             projectCategory.setProjectStartTime(projectStartTime);
             projectCategory.setProjectEndTime(projectEndTime);
             projectCategoryMapper.updateByPrimaryKey(projectCategory);

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
      * @Description: someoneAllProjectCategory的实现
      * @Param: [userId]
      * @Return: com.management.model.ov.Result
      * @Author: ggmr
      * @Date: 18-8-15
      */
    @Override
    public Result someoneAllProjectCategory(String userId) {
         ProjectCategoryExample projectCategoryExample = new ProjectCategoryExample();
         projectCategoryExample.createCriteria()
                            .andPrincipalIdEqualTo(userId);
         List<ProjectCategory> projectCategoryList = projectCategoryMapper.selectByExample(projectCategoryExample);
         if(projectCategoryList.isEmpty()) {
             return ResultTool.error("这个业务员没有开通过项目大类");
         }
         List<SomeoneAllProjectCategoryInfo> resList = new LinkedList<>();
         for(ProjectCategory projectCategory : projectCategoryList) {
            SomeoneAllProjectCategoryInfo res = new SomeoneAllProjectCategoryInfo();
            res.setFinishPeople(projectCategory.getStatistics());
            res.setProjectCategoryName(projectCategory.getProjectCategoryName());
            res.setProjectDeadline(timetoString(projectCategory.getProjectEndTime()));
            res.setType(projectCategory.getProjectType());
            resList.add(res);
         }
         return ResultTool.success(resList);
    }


    /**
     * @Description: chooseProjectMeeting接口的实现
     * @Param: [info]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-15
     */
    @Override
    public Result chooseProjectMeeting(ChooseProjectMeeting info) {
        List<Integer> meetingList = info.getMeetingList();
        List<Integer> notMeetingList = info.getNotMeetingList();
        if(meetingList.isEmpty() && notMeetingList.isEmpty()) {
            return ResultTool.error("不能给予空的上会项目列表");
        }
        for(Integer projectId : meetingList) {
            ProjectApplication projectApplication = projectApplicationMapper.selectByPrimaryKey(projectId);
            projectApplication.setIsMeeting(MEETING_ENABLE);
            projectApplication.setReviewPhase(projectApplication.getReviewPhase() + 1);
            projectApplicationMapper.updateByPrimaryKeySelective(projectApplication);
        }
        for(Integer projectId : notMeetingList) {
            ProjectApplication projectApplication = projectApplicationMapper.selectByPrimaryKey(projectId);
            projectApplication.setIsMeeting(MEETING_UNABLE);
            projectApplication.setReviewPhase(REVIEW_FAILED);
            projectApplicationMapper.updateByPrimaryKeySelective(projectApplication);
        }
        return ResultTool.success();
    }


}
