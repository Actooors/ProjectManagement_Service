package com.management.service;


import com.management.model.ov.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 * @program: management
 * @description: 文件上传service
 * @author: ggmr
 * @create: 2018-12-18 14:49
 */
public interface FileService {
    /**
     * @Description: 文件上传
     * @Param: [file]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 2018/12/22
     */
    Result uploadFile(@RequestBody MultipartFile file) throws UnsupportedEncodingException;

    /**
     * @Description: 文件下载
     * @Param: [request, response, fileAddress]
     * @Return: com.management.model.ov.Result
     * @Author: ggmr
     * @Date: 2018/12/22
     */
    void downloadFile(HttpServletRequest request,
                        HttpServletResponse response, String fileAddress) throws IOException;


}
