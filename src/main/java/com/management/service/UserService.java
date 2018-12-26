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
     * @Description: 判断是否超过截止时间的接口，超过返回１未超过返回２
     * 项目申报时间的结束时间，项目中期报告提交的结束时间和项目结题报告提交的结束时间
     * 以及项目结束的时间，这四个情况分别对应数字1 2 3 4
     * @Param: [projectCategoryId, type]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-7-31
     */
    Result isTimeOut(Integer projectCategoryId, Integer type);

    /**
     * @Description: 根据项目大类的种类查找对应类别的所有的项目大类，项目类别按照１２３４分类
     * 只能看到没有超过申请时间deadline的项目
     * @Param: [projectCategoryType]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-7-31
     */
    Result findAllProjectCategory(Integer projectCategoryType);

    /**
     * @Description: 根据项目大类Id查找一个具体的项目大类的信息
     * @Param: [projectCategoryId]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-7-31
     */
    Result findProjectCategoryInfo(Integer projectCategoryId);

    /**
     * @Description: 查找某个项目大类的所有待审项目申请,
     * type为1业务员审核阶段 2评审专家审核阶段 3会评阶段 4领导审核阶段
     * @Param: [leaderId]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-15
     */
    Result waitJudgeProjectList(Integer projectCategoryId, Integer type);

    /**
     * @Description: 审核一个项目的进行情况，如果通过那么项目的阶段++，如果已经到了第四阶段并且已经通过，那么结束
     * @Param: [projectId, info]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-15
     */
    Result projectJudgeResult(IsProjectPassedPostInfo info);

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
    Result commitReport(CommitInfo info);
    
    /**
     * @Description: 查看用户项目详情
     * @Param: 
     * @Return: 
     * @Author: ggmr
     * @Date: 2018/12/26
     */
    Result findMoreInfo(int applicationId);
}
