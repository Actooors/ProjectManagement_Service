package com.management.service;

import com.management.model.jsonrequestbody.DeleteUserRequest;
import com.management.model.jsonrequestbody.UpdateOrInsertUser;
import com.management.model.jsonrequestbody.UserStatus;
import com.management.model.ov.Result;
import io.swagger.models.auth.In;

/**
 * @Description: 超级管理员相关业务实现
 * @Author: xw
 * @Date: 19-5-10
 */

public interface SuperAdminService {

    /**
     * @Description: 获取所有用户信息
     * @Param:
     * @Return: Result(UserBaseInfo)
     * @Author: xw
     * @Date: 19-5-10
     */
    Result getUserInfo(Integer page);

    /**
     * @Description: 添加用户信息
     * @Param: UpdateOrInsertUser
     * @Return:
     * @Author: xw
     * @Date: 19-5-10
     */
    Result insertUser(UpdateOrInsertUser updateOrInsertUser);

    /**
     * @Description: 修改用户身份
     * @Param: UpdateOrInsertUser
     * @Return:
     * @Author: xw
     * @Date: 19-5-11
     */
    Result updateUserIdentity(UpdateOrInsertUser updateOrInsertUser);

    /**
     * @Description: 改变用户状态
     * @Param: UserStatus
     * @Return: Result
     * @Author: xw
     * @Date: 19-5-11
     */
    Result updateUserStatus(UserStatus userStatus);

    /**
     * @Description: 批量删除用户
     * @Param: DeleteUserRequest
     * @Return:
     * @Author: xw
     * @Date: 19-5-11
     */
    Result deleteUser(DeleteUserRequest deleteUserRequest);

    /**
     * @Description: 查询所有领导基本信息
     * @Param:
     * @Return:
     * @Author: xw
     * @Date: 19-5-11
     */
    Result getAllLeaderInfo();


}
