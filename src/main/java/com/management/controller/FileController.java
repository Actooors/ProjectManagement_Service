package com.management.controller;

import com.management.model.ov.Result;
import com.management.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: management
 * @description: 文件控制类
 * @author: ggmr
 * @create: 2018-12-21 20:54
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/file")
@Api(value = "文件上传下载")
public class FileController {

    @Resource
    private FileService fileService;

    @PostMapping("upload")
    @ApiOperation(value = "上传文件", notes = "输入参数为文件和httpRequest")
    public Result upload(@RequestBody MultipartFile file, HttpServletRequest request) {
        return fileService.uploadFile(file, request);
    }
}
