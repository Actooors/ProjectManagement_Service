package com.management.controller;

import com.management.model.OV.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: management
 * @description:
 * @author: ggmr
 * @create: 2018-07-28 09:14
 */
@RestController
@RequestMapping(value = "/test")
@CrossOrigin
@Api(value = "测试controller")
public class test {
    @RequestMapping
    @ApiOperation(value = "新增用户", notes = "根据用户实体创建用户")
    public String f() {
        return "sd";
    }
}
