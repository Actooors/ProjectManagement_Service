package com.management.service;

import com.management.model.ov.Result;

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
    Result getUserInfo();

    /**
     * @Description: 添加用户信息
     * @Param:
     * @Return: Result(UserBaseInfo)
     * @Author: xw
     * @Date: 19-5-10
     */
    Result inferUserInfo();

}
