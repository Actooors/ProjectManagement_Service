package com.management.controller;

import com.management.model.ov.Result;
import com.management.service.ExpertService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: management
 * @description: 专家controller
 * @author: ggmr
 * @create: 2018-08-01 17:01
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/expert")
@Api(value = "ExpertService对应的controller")
public class ExpertController {
    @Resource
    private ExpertService expertService;

    @GetMapping("project/{projectId}")
    @ApiOperation(value = "查找某个项目的全部审核专家的审核意见", notes = "根据项目id查找所有的审核专家的审核意见")
    public Result findProjectCategoryInfo(@PathVariable(value = "projectId")int prId) {

        return expertService.expertOpinionList(prId);
    }
}
