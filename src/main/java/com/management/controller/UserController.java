package com.management.controller;

import com.management.model.ov.Result;
import com.management.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @GetMapping("/projectCategoryList/{projectIdCategoryType}")
    @ApiOperation(value = "查找指定类别的项目大类", notes = "根据类别type查找项目大类")
    public Result isTimeOut(@PathVariable(value = "projectIdCategoryType")int prType) {

        return userService.findAllProjectCategory(prType);
    }



    @GetMapping("projectCategory/{projectCategoryId}")
    @ApiOperation(value = "返回某个项目大类的具体信息", notes = "根据项目大类id查找项目大类")
    public Result findProjectCategoryInfo(@PathVariable(value = "projectCategoryId")int prId) {

        return userService.findProjectCategoryInfo(prId);
    }

}
