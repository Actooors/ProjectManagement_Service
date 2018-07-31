package com.management.controller;

import com.management.model.ov.Result;
import com.management.model.jsonrequestbody.LoginInfo;
import com.management.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: management
 * @description: 登录控制器
 * @author: ggmr
 * @create: 2018-07-29 17:17
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/login")
@Api(value = "登录controller")
public class LoginController {
    @Resource
    @ApiParam("和用户相关的业务操作")
    private UserService userService;

    @PostMapping("")
    @ApiOperation(value = "登录", notes = "根据用户id和密码登录系统")
    public Result login(@RequestBody LoginInfo loginInfo) {
        return userService.login(loginInfo);
    }
}
