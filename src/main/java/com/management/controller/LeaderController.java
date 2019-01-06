package com.management.controller;

import com.management.model.jsonrequestbody.IsProjectCategoryPassedPostInfo;
import com.management.model.jsonrequestbody.LeaderJudgeInfo;
import com.management.model.ov.Result;
import com.management.service.LeaderService;
import com.management.tools.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: management
 * @description: 领导层的controller
 * @author: ggmr
 * @create: 2018-08-15 16:38
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/leader")
@Api(value = "LeaderService对应的controller")
public class LeaderController {
    @Resource
    @ApiParam("和领导相关的业务操作")
    private LeaderService leaderService;

    @PostMapping("/judgeProjectCategory")
    @ApiOperation(value = "领导层一个项目大类的创建", notes = "根据给予的判断信息和理由更新数据库中的项目大类的情况")
    public Result findProjectCategoryInfo(@RequestBody IsProjectCategoryPassedPostInfo info) {

        return leaderService.isProjectCategoryPassed(info);
    }

    @GetMapping("/AllSubordinate")
    @ApiOperation(value = "查找一个领导的所有的下属", notes = "根据领导id查找他的所有的下属")
    public Result findProjectCategoryInfo(@RequestHeader(value = "Authorization")String token) {

        String leaderId = JwtUtil.parseJwt(token);
        return leaderService.findAllSubordinate(leaderId);
    }

    @GetMapping("/unJudgeProjectCategory")
    @ApiOperation(value = "查找一个领导的所有待审核项目大类列表", notes = "根据领导id查找他的所有的待审核项目大类列表")
    public Result findUnJudgeProjectCategory(@RequestHeader(value = "Authorization")String token) {

        String leaderId = JwtUtil.parseJwt(token);
        return leaderService.waitJudgeProjectCategoryList(leaderId);
    }

    @GetMapping("/unjudgeApplicatetion")
    @ApiOperation(value = "领导查找待审核项目申请")
    public Result findUnJudgeProjectApplicatetion(@RequestHeader(value = "Authorization")String token){
        String leaderId = JwtUtil.parseJwt(token);
        return leaderService.findUnJudgeProjectApplication(leaderId);
    }

    @PostMapping("/JudgeApplication")
    @ApiOperation(value = "领导审核用户提交的项目申请")
    public Result JudgeApplication(@RequestBody LeaderJudgeInfo leaderJudgeInfo){
        return leaderService.judgeProjectApplication(leaderJudgeInfo);
    }
}
