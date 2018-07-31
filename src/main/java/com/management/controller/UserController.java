package com.management.controller;

import com.management.model.OV.Result;
import com.management.model.jsonrequestbody.LoginInfo;
import com.management.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ResponseHeader;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: management
 * @description: UserService对应的controller
 * @author: ggmr
 * @create: 2018-07-31 10:59
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/user")
@Api(value = "UserService对应的controller")
public class UserController {
    @Resource
    @ApiParam("和用户相关的业务操作")
    private UserService userService;

    @GetMapping("/time/{projectIdCategoryId}/{type}")
    @ApiOperation(value = "检查是否超过截止时间", notes = "根据项目大类id和时间种类来判断是判断哪个时间")
    public Result isTimeOut(@PathVariable(value = "projectIdCategoryId")int prId,
                            @PathVariable(value = "type")int type) {

        return userService.isTimeOut(prId, type);
    }

}
