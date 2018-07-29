package com.management.controller;

import com.management.model.OV.Result;
import com.management.model.jsonrequestbody.LoginInfo;
import com.management.service.UserService;
import io.swagger.annotations.Api;
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
    private UserService userService;

    @PostMapping("")
    public Result login(@RequestBody LoginInfo loginInfo) {
        return userService.login(loginInfo);
    }

}
