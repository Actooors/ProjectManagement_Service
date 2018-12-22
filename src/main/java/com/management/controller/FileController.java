package com.management.controller;

import com.management.model.ov.Result;
import com.management.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
    public Result upload(@RequestBody MultipartFile file) throws UnsupportedEncodingException {

        return fileService.uploadFile(file);
    }

    @GetMapping("download")
    @ApiOperation(value = "下载文件", notes = "输入参数为文件下载地址")
    public void upload(HttpServletRequest request, HttpServletResponse response,
                         @RequestParam(value = "fileAddress")String fileAddress) throws IOException {

        fileService.downloadFile(request, response, fileAddress);
    }
}
