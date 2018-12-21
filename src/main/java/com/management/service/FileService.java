package com.management.service;


import com.management.model.ov.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: management
 * @description: 文件上传service
 * @author: ggmr
 * @create: 2018-12-18 14:49
 */
public interface FileService {
    Result uploadFile(@RequestBody MultipartFile file, HttpServletRequest request);



}
