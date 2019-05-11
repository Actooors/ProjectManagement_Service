package com.management.controller;

import com.management.model.entity.User;
import com.management.model.jsonrequestbody.*;
import com.management.model.ov.Result;
import com.management.security.UserContext;
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


//    @GetMapping("/projectCategory/{projectCategoryId}/{type}")
//    @ApiOperation(value = "查找某个项目大类列表的所有待审项目", notes = "根据项目大类id查找所有审核阶段为type的项目")
//    public Result findUnJudgeProjectCategory(@PathVariable(value = "projectCategoryId") String prCId,
//                                             @PathVariable(value = "type") int type) {
//
//        return userService.waitJudgeProjectList(prCId, type);
//    }

//    @PostMapping("/projectJudgement")
//    @ApiOperation(value = "审核一个项目某个阶段", notes = "如果通过那么项目的阶段++，如果已经到了第四阶段并且已经通过，那么结束")
//    public Result findUnJudgeProjectCategory(@RequestBody IsProjectPassedPostInfo info) {
//
//        return userService.projectJudgeResult(info);
//    }

    @GetMapping("/AllAviProjectCategory")
    @ApiOperation(value = "查找当前可以申报的所有的项目大类", notes = "根据类别去分类所有的项目大类并返回给用户")
    public Result findAllAViProjectCategory() {

        return userService.getAllAviProject();
    }

    @GetMapping("/userInfo/1")
    @ApiOperation(value = "用户查看个人信息", notes = "此接口适用于所有用户")
    public Result findUserInfo() {

        String userId = UserContext.getCurrentUser().getUserId();
        return userService.queryUserId(userId);
    }

    @PostMapping("/userInfo/2")
    @ApiOperation(value = "用户修改更新个人信息", notes = "此接口适用于所有用户")
    public Result updateUserInfo(@RequestBody User user) {
        return userService.updateUserInfo(user);
    }

    @PostMapping("/applyProject")
    @ApiOperation(value = "用户申请一个项目")
    public Result applyProject(@RequestBody ProjectApplicationInfo info) {
        return userService.applyProject(info);
    }


    @GetMapping("/inTheApplicationList")
    @ApiOperation(value = "查找用户正在申报中的项目")
    public Result inTheApplicationList() {
        String userId = UserContext.getCurrentUser().getUserId();
        return userService.findMyApplication(userId);
    }

    @PostMapping("/deleteApplication")
    @ApiOperation(value = "用户撤销申报中的项目")
    public Result deleteApplication(@RequestBody DeleteApplication info) {
        String userId = UserContext.getCurrentUser().getUserId();
        return userService.deleteApplication(info, userId);
    }

    @GetMapping("/progressProject")
    @ApiOperation(value = "查找用户正在进行的项目")
    public Result findProgressProject() {
        String userId = UserContext.getCurrentUser().getUserId();
        return userService.findProgressProject(userId);
    }

    @PostMapping("/commitReport")
    @ApiOperation(value = "用户提交中期报告和结题报告")
    public Result deleteApplication(@RequestBody PostReportInfo info) {

        return userService.commitReport(info);
    }

    @GetMapping("/projectMoreInfo")
    @ApiOperation(value = "查看用户一个项目的详细信息")
    public Result findProjectMoreInfo(@RequestParam(value = "applicationId") String applicationId) {

        return userService.findMoreInfo(applicationId);
    }


    @GetMapping("/userInfoFromId/{userId}")
    @ApiOperation(value = "查看用户的详细信息")
    public Result findUserInfoFromId(@PathVariable(value = "userId") String userId) {

        return userService.findUserInfo(userId);
    }


    @PostMapping("/commitTaskManual")
    @ApiOperation(value = "用户提交任务书")
    public Result commitTaskManual(@RequestBody ProjectIndex projectIndex) {
        return userService.commitProjectIndex(projectIndex);
    }

    @GetMapping("/failProject")
    @ApiOperation(value = "用户查询被驳回的项目", notes = "包括未立项的项目和已经立项的项目")
    public Result queryFailProject() {

        String userId = UserContext.getCurrentUser().getUserId();
        return userService.queryFailProject(userId);
    }

    @PostMapping("/updatePassword")
    @ApiOperation(value = "用户修改密码")
    public Result updatePassword(@RequestBody UpdateOrInsertUser updateOrInsertUser){
        return userService.updatePassword(updateOrInsertUser);
    }



}
