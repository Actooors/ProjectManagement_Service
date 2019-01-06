package com.management.controller;

import com.management.dao.ProjectCategoryMapper;
import com.management.model.entity.ProjectCategory;
import com.management.model.jsonrequestbody.*;
import com.management.model.ov.Result;
import com.management.service.AdminService;
import com.management.tools.JwtUtil;
import com.management.tools.ResultTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
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
    @Resource
    private ProjectCategoryMapper projectCategoryMapper;

    @GetMapping("/allProjectCategory")
    @ApiOperation(value = "查一个业务员负责的所有的项目大类", notes = "根据业务员工号查找他负责的所有的项目大类")
    public Result findProjectCategoryInfo(@RequestHeader(value = "Authorization") String token) {

        String userId = JwtUtil.parseJwt(token);
        return adminService.someoneAllProjectCategory(userId);
    }



    @PostMapping("/isMeeting")
    @ApiOperation(value = "业务员选择指定项目上会，另外的项目申请失败", notes = "根据项目号查找项目后更新内容")
    public Result meetingResult(@RequestBody ChooseProjectMeeting info) {

        return adminService.chooseProjectMeeting(info);
    }

    @PostMapping("/createProjectCategory")
    @ApiOperation(value = "业务员创建项目类别,默认为待审核")
    public Result insertProjectCategory(@RequestHeader(value = "Authorization") String token,
                                        @RequestBody ProjectCategoryInfo projectCategoryInfo) {
        String userId = JwtUtil.parseJwt(token);
        return adminService.createProjectCategory(userId, projectCategoryInfo);
    }

    @PostMapping("/projectCategory/2")
    @ApiOperation(value = "业务员修改项目类别", notes = "根据项目号查找项目后更新内容")
    public Result updateProject(@RequestBody UpdateProjectCategoryInfo updateProjectCategoryInfo) {

        return adminService.updateProjectCategoryInfo(updateProjectCategoryInfo);
    }

    @GetMapping("/findMyProjectCategory")
    @ApiOperation(value = "查询业务员负责的项目详细信息", notes = "根据业务员Id查询业务员负责的项目详细信息")
    public Result queryProjectCategoryInfo(@RequestHeader(value = "Authorization") String token) {

        String userId = JwtUtil.parseJwt(token);
        return adminService.queryProjectCategory(userId);
    }

    @GetMapping("/findProjectCategory/{projectId}")
    @ApiOperation(value = "业务员根据项目大类id来查询具体信息")
    public Result queryProCategoryInfoById(@PathVariable(value = "projectId") Integer projectId){

        return adminService.queryProjectById(projectId);
    }


    @PostMapping("deleteProjectCategory")
    @ApiOperation(value = "根据项目大类id删除项目大类信息")
    public Result deleteProjectCategory(@RequestBody DeleteProjectCategoryInfo info) {
        return adminService.deleteProjectCategory(info);
    }

    @PostMapping("/firstTrial")
    @ApiOperation(value = "业务员初审项目")
    public Result adminFirstTrail(@RequestBody OneJudgeInfo info) {

        return adminService.oneJudge(info);
    }

    @PostMapping("/meetingTrial")
    @ApiOperation(value = "对项目会评")
    public Result meetingTrail(@RequestBody MeetingResult info) {

        return adminService.meetingReview(info);
    }

    @GetMapping("expertList")
    @ApiOperation(value = "业务员在创建项目大类的时候指定一些审核专家来审核项目")
    public Result getExpertList() {

        return adminService.findExpertList();
    }

    @GetMapping("/project/{projectId}")
    @ApiOperation(value = "查找某个项目的全部审核专家的审核意见", notes = "根据项目id查找所有的审核专家的审核意见")
    public Result findProjectCategoryInfo(@PathVariable(value = "projectId") int prId) {

        return adminService.expertOpinionList(prId);
    }

    @GetMapping("/reviewPhase/{reviewPhase}")
    @ApiOperation(value = "查找某个审核阶段的项目列表")
    public Result findReviewPhaseInfo(@PathVariable(value = "reviewPhase") int reviewPhase,
                                      @RequestHeader(value = "Authorization") String token) {
        String userId = JwtUtil.parseJwt(token);
        return adminService.findReviewPhaseList(userId, reviewPhase);
    }
}
