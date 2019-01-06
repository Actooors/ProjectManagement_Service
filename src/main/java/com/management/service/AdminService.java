package com.management.service;

import com.management.model.jsonrequestbody.*;
import com.management.model.ov.Result;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

/**
 * @program: management
 * @description: 业务员层的各接口Seriver方法
 * @author: ggmr
 * @create: 2018-07-29 17:22
 */
@Service

public interface AdminService {


    /**
     * @Description: 业务员创建项目类别
     * @Param: projectCategoryInfo
     * @Return: Result
     * @Author: xw
     * @Date: 18-7-30
     */
    Result createProjectCategory(String userId, ProjectCategoryInfo projectCategoryInfo);

    /**
     * @Description: 业务员根据自己的ID查询创建的项目类别信息
     * @Param: userId
     * @Return: ProjectCategory
     * @Author: xw
     * @Date: 18-7-31
     */
    Result queryProjectCategory(String userId);

    /**
     * @Description: 业务员根据项目id查找项目具体信息
     * @Param: projectId
     * @Return: ProjectCategory
     * @Author: xw
     * @Date: 19-1-7
     */
    Result queryProjectById(Integer projectId);

    /**
     * @Description: 根据项目号查找项目后更新内容
     * @Param: UpdateProjectCategoryInfo
     * @Return: Result
     * @Author: xw
     * @Date: 18-12-18
     */
    Result updateProjectCategoryInfo(UpdateProjectCategoryInfo updateProjectCategoryInfo);

    /**
     * @Description: 根据项目大类id查找到相应项目大类并删除
     * @Param: projectCategoryId
     * @Return: Result
     * @Author: xw
     * @Date: 18-12-19
     */
    Result deleteProjectCategory(DeleteProjectCategoryInfo info);


    /**
     * @Description: 查看一个业务员负责的项目大类的列表，返回给他项目大类名字 项目结束时间 和项目结项人数
     * @Param: [userId]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-15
     */
    Result someoneAllProjectCategory(String userId);

    /**
     * @Description: 业务员选择指定的一定数量的项目上会
     * @Param: [info]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-15
     */
    Result chooseProjectMeeting(ChooseProjectMeeting info);


    /**
     * @Description: 业务员对刚提交上来的申请书给与判决
     * @Param:
     * @Return:
     * @Author: ggmr
     * @Date: 2018/12/27
     */
    Result oneJudge(OneJudgeInfo info);

    /**
     * @Description: 会评
     * @Param: [info]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 2018/12/27
     */
    Result meetingReview(MeetingResult info);
    
    /**
     * @Description: 查找所有的审核专家
     * @Param: []
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 2018/12/27
     */
    Result findExpertList();

    /**
     * @Description: 通过项目id找到这个项目所有的审核专家对项目的审核状况
     * @Param: [projectId]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-1
     */
    Result expertOpinionList(int projectId);

    /**
     * @Description: 查找某个审核阶段的所有的待审核项目
     * @Param: [userId,reviewPhase]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 2018/12/30
     */
    Result findReviewPhaseList(String userId, int reviewPhase);
}
