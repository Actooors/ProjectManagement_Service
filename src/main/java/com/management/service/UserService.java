package com.management.service;


import com.management.model.OV.Result;
import com.management.model.jsonrequestbody.LoginInfo;

/**
 * @program: management
 * @description: 登录接口的业务实现
 * @author: ggmr
 * @create: 2018-07-29 17:21
 */
public interface UserService {

    /**
     * @Description: 登录接口,根据用户提供的账户和密码进行登录
     * @Param: [loginInfo]
     * @Return: com.management.model.OV.Result
     * @Author: ggmr
     * @Date: 18-7-30
     */
    Result login(LoginInfo loginInfo);
}
