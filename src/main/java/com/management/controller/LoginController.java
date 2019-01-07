package com.management.controller;

import com.management.model.ov.Result;
import com.management.model.jsonrequestbody.LoginInfo;
import com.management.security.MyUserDetailService;
import com.management.service.UserService;
import com.management.tools.JwtUtil;
import com.management.tools.ResultTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.ResponseCache;

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
@Slf4j
public class LoginController {
//    @Resource
//    @ApiParam("和用户相关的业务操作")
//    private UserService userService;

    @Resource
    private UserService userService;

    @PostMapping("")
    @ApiOperation(value = "登录", notes = "根据用户id和密码登录系统")
    public Result login(@RequestBody LoginInfo loginInfo) {
        return userService.login(loginInfo);
    }
}
