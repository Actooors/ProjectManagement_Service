package com.management.controller;

import com.management.model.jsonrequestbody.IsProjectCategoryPassedPostInfo;
import com.management.model.ov.Result;
import com.management.service.LeaderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
}
