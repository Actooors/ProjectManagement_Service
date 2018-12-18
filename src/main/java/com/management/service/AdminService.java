package com.management.service;
import com.management.model.jsonrequestbody.ChooseProjectMeeting;
import com.management.model.jsonrequestbody.UpdateProjectCategoryInfo;
import com.management.model.ov.Result;
import com.management.model.jsonrequestbody.ProjectCategoryInfo;
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
     * @Description: 根据项目号查找项目后更新内容
     * @Param: UpdateProjectCategoryInfo
     * @Return: Result
     * @Author: xw
     * @Date: 18-12-18
     */
    Result updateProjectCategoryInfo(UpdateProjectCategoryInfo updateProjectCategoryInfo);


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
}
