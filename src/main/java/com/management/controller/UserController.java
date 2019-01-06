package com.management.controller;

import com.management.model.entity.User;
import com.management.model.jsonrequestbody.CommitInfo;
import com.management.model.jsonrequestbody.DeleteApplication;
import com.management.model.jsonrequestbody.IsProjectPassedPostInfo;
import com.management.model.jsonrequestbody.ProjectApplicationInfo;
import com.management.model.ov.Result;
import com.management.service.UserService;
import com.management.tools.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public Result isTimeOut(@PathVariable(value = "projectIdCategoryId") int prId,
                            @PathVariable(value = "type") int type) {

        return userService.isTimeOut(prId, type);
    }

    @GetMapping("/projectCategoryList/{projectIdCategoryType}")
    @ApiOperation(value = "查找指定类别的项目大类", notes = "根据类别type查找项目大类")
    public Result isTimeOut(@PathVariable(value = "projectIdCategoryType") int prType) {

        return userService.findAllProjectCategory(prType);
    }


    @GetMapping("projectCategory/{projectCategoryId}")
    @ApiOperation(value = "返回某个项目大类的具体信息", notes = "根据项目大类id查找项目大类")
    public Result findProjectCategoryInfo(@PathVariable(value = "projectCategoryId") int prId) {

        return userService.findProjectCategoryInfo(prId);
    }

    @GetMapping("/projectCategory/{projectCategoryId}/{type}")
    @ApiOperation(value = "查找某个项目大类列表的所有待审项目", notes = "根据项目大类id查找所有审核阶段为type的项目")
    public Result findUnJudgeProjectCategory(@PathVariable(value = "projectCategoryId") int prCId,
                                             @PathVariable(value = "type") int type) {

        return userService.waitJudgeProjectList(prCId, type);
    }

    @PostMapping("/projectJudgement")
    @ApiOperation(value = "审核一个项目某个阶段", notes = "如果通过那么项目的阶段++，如果已经到了第四阶段并且已经通过，那么结束")
    public Result findUnJudgeProjectCategory(@RequestBody IsProjectPassedPostInfo info) {

        return userService.projectJudgeResult(info);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/AllAviProjectCategory")
    @ApiOperation(value = "查找当前可以申报的所有的项目大类", notes = "根据类别去分类所有的项目大类并返回给用户")
    public Result findAllAViProjectCategory() {

        return userService.getAllAviProject();
    }

    @GetMapping("/userInfo/1")
    @ApiOperation(value = "用户查看个人信息", notes = "此接口适用于所有用户")
    public Result findUserInfo(@RequestHeader(value = "Authorization") String token) {

        String userId = JwtUtil.parseJwt(token);
        return userService.queryUserId(userId);
    }

    @PostMapping("/userInfo/2")
    @ApiOperation(value = "用户修改更新个人信息", notes = "此接口适用于所有用户")
    public Result updateUserInfo(@RequestBody User user){
        return userService.updateUserInfo(user);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("/applyProject")
    @ApiOperation(value = "用户申请一个项目")
    public Result applyProject(@RequestBody ProjectApplicationInfo info){
        return userService.applyProject(info);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/inTheApplicationList")
    @ApiOperation(value = "查找用户正在申报中的项目")
    public Result inTheApplicationList(@RequestHeader(value = "Authorization") String token){
        String userId = JwtUtil.parseJwt(token);
        return userService.findMyApplication(userId);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("/deleteApplication")
    @ApiOperation(value = "用户撤销申报中的项目")
    public Result deleteApplication(@RequestHeader(value = "Authorization") String token,
                                    @RequestBody DeleteApplication info){
        String userId = JwtUtil.parseJwt(token);
        return userService.deleteApplication(info,userId);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/progressProject")
    @ApiOperation(value = "查找用户正在进行的项目")
    public Result findProgressProject(@RequestHeader(value = "Authorization") String token){
        String userId = JwtUtil.parseJwt(token);
        return userService.findProgressProject(userId);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("/commitReport")
    @ApiOperation(value = "用户提交中期报告和结题报告")
    public Result deleteApplication(@RequestBody CommitInfo info){

        return userService.commitReport(info);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/projectMoreInfo")
    @ApiOperation(value = "查看用户一个项目的详细信息")
    public Result findProjectMoreInfo(@RequestParam(value = "applicationId") int applicationId){

        return userService.findMoreInfo(applicationId);
    }

}
