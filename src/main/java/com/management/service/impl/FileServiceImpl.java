package com.management.service.impl;

import com.management.model.ov.Result;
import com.management.tools.ResultTool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.management.service.FileService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.UUID;

/**
 * @program: management
 * @description: 文件上传Service方法的实现
 * @author: ggmr
 * @create: 2018-12-18 14:49
 */
@Service
public class FileServiceImpl implements FileService {

    //存放文件的路径
    @Value("${upload.path}")
    private String directory;


    @Override
    public Result uploadFile(MultipartFile file, HttpServletRequest request) {

        if (file.isEmpty()) {
            return ResultTool.error("上传文件为空");
        }
        //文件存放的id名
        String fileId = UUID.randomUUID().toString();
        //源文件名
        String originalFileName = file.getOriginalFilename();
        //在指定的目录位置下存放文件

        String absolutePath = directory + fileId + "|" + originalFileName;

        File destDirectory = new File(directory);
        if (!destDirectory.exists()) {
            destDirectory.mkdirs();
        }

        try(OutputStream os = new FileOutputStream(absolutePath)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            return ResultTool.error(e.toString());
        }
        return ResultTool.success(absolutePath);
    }
}
