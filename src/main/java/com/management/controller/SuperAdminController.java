package com.management.controller;

import com.management.model.jsonrequestbody.DeleteUserRequest;
import com.management.model.jsonrequestbody.PageJson;
import com.management.model.jsonrequestbody.UpdateOrInsertUser;
import com.management.model.jsonrequestbody.UserStatus;
import com.management.model.ov.Result;
import com.management.service.SuperAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: management
 * @description: 系统管理员接口
 * @author: xw
 * @create: 2019-05-11 17:25
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/system")
@Api(value = "SuperAdminService对应的controller")
public class SuperAdminController {

    @Resource
    @ApiParam("和用户相关的业务操作")
    private SuperAdminService superAdminService;

    @PostMapping("/userInfo")
    @ApiOperation(value = "查找所有用户")
    public Result getUserInfo(@RequestBody PageJson pageJson){
        return superAdminService.getUserInfo(pageJson.getPage());
    }

    @PostMapping("/addUser")
    @ApiOperation(value = "添加用户信息")
    public Result insertUserInfo(@RequestBody UpdateOrInsertUser updateOrInsertUser){
        return superAdminService.insertUser(updateOrInsertUser);
    }

    @PostMapping("/updateIdentity")
    @ApiOperation(value = "修改用户身份")
    public Result updateUserIdentity(@RequestBody UpdateOrInsertUser updateOrInsertUser){
        return superAdminService.updateUserIdentity(updateOrInsertUser);
    }

    @PostMapping("/updateStatus")
    @ApiOperation(value = "更改用户状态")
    public Result updateUserStatus(@RequestBody UserStatus userStatus){
        return superAdminService.updateUserStatus(userStatus);
    }

    @PostMapping("/deleteUser")
    @ApiOperation(value = "批量删除用户")
    public Result deleteUser(@RequestBody DeleteUserRequest deleteUserRequest){
        return superAdminService.deleteUser(deleteUserRequest);
    }

    @GetMapping("/leaderList")
    @ApiOperation(value = "查询领导信息列表")
    public Result getAllLeaderInfo(){
        return superAdminService.getAllLeaderInfo();
    }


}
