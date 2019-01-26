package com.management.controller;

import com.management.model.entity.User;
import com.management.model.jsonrequestbody.*;
import com.management.model.ov.Result;
import com.management.security.UserContext;
import com.management.service.AdminService;
import com.management.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    @ApiParam("和专家相关的业务操作")
    private AdminService adminService;

    @Resource
    @ApiParam("用户通用的业务")
    private UserService userService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_LEADER')")
    @GetMapping("/allProjectCategory")
    @ApiOperation(value = "查一个业务员负责的所有的项目大类", notes = "根据业务员工号查找他负责的所有的项目大类")
    public Result findProjectCategoryInfo() {

        String userId = UserContext.getCurrentUser().getUserId();
        return adminService.someoneAllProjectCategory(userId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_LEADER')")
    @PostMapping("/isMeeting")
    @ApiOperation(value = "业务员选择指定项目上会，另外的项目申请失败", notes = "根据项目号查找项目后更新内容")
    public Result meetingResult(@RequestBody ChooseProjectMeeting info) {

        return adminService.chooseProjectMeeting(info);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_LEADER')")
    @PostMapping("/createProjectCategory")
    @ApiOperation(value = "业务员创建项目类别,默认为待审核")
    public Result insertProjectCategory(@RequestBody ProjectCategoryInfo projectCategoryInfo) {
        User user = UserContext.getCurrentUser();
        return adminService.createProjectCategory(user, projectCategoryInfo);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_LEADER')")
    @PostMapping("/projectCategory/2")
    @ApiOperation(value = "业务员修改项目类别", notes = "根据项目号查找项目后更新内容")
    public Result updateProject(@RequestBody UpdateProjectCategoryInfo updateProjectCategoryInfo) {

        return adminService.updateProjectCategoryInfo(updateProjectCategoryInfo);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_LEADER')")
    @GetMapping("/findMyProjectCategory")
    @ApiOperation(value = "查询业务员负责的项目详细信息", notes = "根据业务员Id查询业务员负责的项目详细信息")
    public Result queryProjectCategoryInfo() {

        String userId = UserContext.getCurrentUser().getUserId();
        logger.info(userId);
        return adminService.queryProjectCategory(userId);
    }

    @GetMapping("/category/{id}")
    @ApiOperation(value = "根据id查找某一个项目大类的具体信息")
    public Result queryOneProjectCategoryInfo(@PathVariable("id") Integer projectCategoryId) {

        return adminService.queryOneProjectCategory(projectCategoryId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_LEADER')")
    @PostMapping("deleteProjectCategory")
    @ApiOperation(value = "根据项目大类id删除项目大类信息")
    public Result deleteProjectCategory(@RequestBody DeleteProjectCategoryInfo info) {
        return adminService.deleteProjectCategory(info);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_LEADER')")
    @PostMapping("/firstTrial")
    @ApiOperation(value = "业务员初审项目")
    public Result adminFirstTrail(@RequestBody OneJudgeInfo info) {

        return adminService.oneJudge(info);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_LEADER')")
    @PostMapping("/meetingTrial")
    @ApiOperation(value = "对项目会评")
    public Result meetingTrail(@RequestBody MeetingResult info) {

        return adminService.meetingReview(info);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_LEADER')")
    @GetMapping("expertList")
    @ApiOperation(value = "业务员在创建项目大类的时候指定一些审核专家来审核项目")
    public Result getExpertList() {

        return adminService.findExpertList();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_LEADER')")
    @GetMapping("/project/{projectId}")
    @ApiOperation(value = "查找某个项目的全部审核专家的审核意见", notes = "根据项目id查找所有的审核专家的审核意见")
    public Result findProjectCategoryInfo(@PathVariable(value = "projectId") int prId) {

        return adminService.expertOpinionList(prId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_LEADER')")
    @GetMapping("/reviewPhase/{reviewPhase}")
    @ApiOperation(value = "查找某个审核阶段的项目列表")
    public Result findReviewPhaseInfo(@PathVariable(value = "reviewPhase") int reviewPhase) {
        String userId = UserContext.getCurrentUser().getUserId();
        return adminService.findReviewPhaseList(userId, reviewPhase);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_LEADER')")
    @PostMapping("/expertTrial")
    @ApiOperation(value = "业务员初审项目")
    public Result adminExpertTrail(@RequestBody SecondJudgeInfo info) {

        return adminService.secondJudge(info);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_LEADER')")
    @PostMapping("/createReport")
    @ApiOperation(value = "业务员开通中期报告和结题报告的申报内容")
    public Result createReport(@RequestBody ReportMessage info) {

        return adminService.createReport(info);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_LEADER')")
    @GetMapping("/MyProject")
    @ApiOperation(value = "业务员查看负责的所有立项的项目及其状态",notes = "业务员我的项目一栏")
    public Result queryAdminMyProject(){
        String userId = UserContext.getCurrentUser().getUserId();
        return adminService.AdminQueryProject(userId);
    }


    @PostMapping("/indexState")
    @ApiOperation(value = "业务员审核任务书")
    public Result judgeIndex(@RequestBody MeetingResult info) {

        return adminService.judgeMission(info);
    }


    @PostMapping("/finalReport")
    @ApiOperation(value = "业务员审核项目结题报告")
    public Result judgeFinalReport(@RequestBody MeetingResult info) {

        return adminService.judgeFinalReport(info);
    }
}
