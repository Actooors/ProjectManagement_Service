package com.management.service;

import com.management.model.entity.User;
import com.management.model.jsonrequestbody.*;
import com.management.model.ov.Result;

/**
 * @program: management
 * @description: 登录接口的业务实现接口
 * @author: ggmr
 * @create: 2018-07-29 17:22
 */
public interface UserService {

    /**
     * @Description: 登录接口, 根据用户提供的账户和密码进行登录
     * @Param: [loginInfo]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-7-30
     */
    Result login(LoginInfo loginInfo);


    /**
     * @Description: 获取普通用户的全部的可申报项目
     * @Param: [userId]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 2018/12/17
     */
    Result getAllAviProject();

    /**
     * @Description: 查询个人信息, 适用于所有用户
     * @Param: userId
     * @Return: com.management.model.ov.Result
     * @Author: xw
     * @Date: 18-12-19
     */
    Result queryUserId(String userId);

    /**
     * @Description: 修改个人信息
     * @Param: User
     * @Return: com.management.model.ov.Result
     * @Author: xw
     * @Date: 18-12-19
     */
    Result updateUserInfo(User user);

    /**
     * @Description: 申报项目
     * @Param: [projectApplicationInfo]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 2018/12/25
     */
    Result applyProject(ProjectApplicationInfo projectApplicationInfo);

    /**
     * @Description: 查看我正在申报中的项目列表
     * @Param: [userId]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 2018/12/25
     */
    Result findMyApplication(String userId);

    /**
     * @Description: 撤销一个项目的申请
     * @Param: [applicationId]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 2018/12/25
     */
    Result deleteApplication(DeleteApplication info, String userId);

    /**
     * @Description: 查找一个用户正在进行中的项目已经结题的项目
     * @Param: [userId]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 2018/12/25
     */
    Result findProgressProject(String userId);

    /**
     * @Description: 上传中期报告或者结题报告
     * @Param: [info]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 2018/12/26
     */
    Result commitReport(PostReportInfo info);
    
    /**
     * @Description: 查看用户项目详情
     * @Param: 
     * @Return: 
     * @Author: ggmr
     * @Date: 2018/12/26
     */
    Result findMoreInfo(String applicationId);

    /**
     * @Description: 根据工号查询用户的信息
     * @Param: [userId]
     * @Return: com.management.model.ov.Result
     * @Author: 0GGmr0
     * @Date: 2019-01-22
     */
    Result findUserInfo(String userId);



    /**
     * @Description: 用户提交任务书
     * @Param: [ProjectIndex]
     * @Return: Result
     * @Author: xw
     * @Date: 19-1-26
     */
    Result commitProjectIndex(ProjectIndex projectIndex);

    /**
     * @Description: 用户查询所有被驳回的项目申请,包括未立项和已经立项的项目
     * @Param: [userId]
     * @Return: Result
     * @Author: xw
     * @Date: 19-1-26
     */
    Result queryFailProject(String userId);
    
    /**
     * @Description: 修改密码
     * @Param: 
     * @Return: 
     * @Author: xw
     * @Date: 19-3-22
     */
    Result updatePassword(UpdateOrInsertUser updateOrInsertUser);
}
