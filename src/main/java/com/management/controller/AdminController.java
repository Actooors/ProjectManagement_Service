package com.management.controller;

import com.management.model.jsonrequestbody.ChooseProjectMeeting;
import com.management.model.jsonrequestbody.ProjectCategoryInfo;
import com.management.model.jsonrequestbody.UpdateProjectCategoryInfo;
import com.management.model.ov.Result;
import com.management.service.AdminService;
import com.management.tools.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: management
 * @description: 业务员controller
 * @author: ggmr
 * @create: 2018-08-15 15:12
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/admin")
@Api(value = "AdminService对应的controller")
public class AdminController {
    @Resource
    @ApiParam("和专家相关的业务操作")
    private AdminService adminService;

    @GetMapping("/allProjectCategory")
    @ApiOperation(value = "查一个业务员负责的所有的项目大类", notes = "根据业务员工号查找他负责的所有的项目大类")
    public Result findProjectCategoryInfo(@RequestHeader(value = "Authorization")String token) {

        String userId = JwtUtil.parseJwt(token);
        return adminService.someoneAllProjectCategory(userId);
    }

    @PostMapping("/meetingResult")
    @ApiOperation(value = "业务员选择指定项目上会，另外的项目申请失败", notes = "根据项目号查找项目后更新内容")
    public Result meetingResult(@RequestBody ChooseProjectMeeting info) {

        return adminService.chooseProjectMeeting(info);
    }

    @PostMapping("projectCategory/1")
    @ApiOperation(value = "业务员创建项目类别,默认为待审核")
    public Result insertProjectCategory(@RequestHeader(value = "Authorization")String token,
                                        @RequestBody ProjectCategoryInfo projectCategoryInfo){
        String userId = JwtUtil.parseJwt(token);
        return adminService.createProjectCategory(userId,projectCategoryInfo);
    }

    @PostMapping("projectCategory/2")
    @ApiOperation(value = "业务员修改项目类别", notes = "根据项目号查找项目后更新内容")
    public Result updateProject(@RequestHeader(value = "Authorization")String token,
                                @RequestBody UpdateProjectCategoryInfo updateProjectCategoryInfo){

        return adminService.updateProjectCategoryInfo(updateProjectCategoryInfo);
    }

    @GetMapping("projectCategory/3")
    @ApiOperation(value = "查询业务员负责的项目详细信息", notes = "根据业务员Id查询业务员负责的项目详细信息")
    public Result queryProjectCategoryInfo(@RequestHeader(value = "Authorization")String token){

        String userId = JwtUtil.parseJwt(token);
        return adminService.queryProjectCategory(userId);
    }

}
