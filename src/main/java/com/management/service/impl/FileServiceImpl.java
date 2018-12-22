package com.management.service.impl;
import com.management.model.ov.Result;
import com.management.tools.ChangeCharset;
import com.management.tools.ResultTool;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.management.service.FileService;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
    public Result uploadFile(MultipartFile file) throws UnsupportedEncodingException {

        if (file.isEmpty()) {
            return ResultTool.error("上传文件为空");
        }
        //文件存放的id名
        String fileId = UUID.randomUUID().toString();
        //源文件名
        String originalFileName = ChangeCharset.toUtf8(file.getOriginalFilename());
        //在指定的目录位置下存放文件
        String absolutePath = directory + File.separator + fileId + "---" + originalFileName;
        //如果存放文件的文件夹不存在，就创建文件夹
        File destDirectory = new File(directory);
        if (!destDirectory.exists()) {
            destDirectory.mkdirs();
        }

        try(OutputStream os = new FileOutputStream(absolutePath)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            return ResultTool.error("上传出错");
        }
        return ResultTool.success(absolutePath);
    }

    @Override
    public void downloadFile(HttpServletRequest request,
                               HttpServletResponse response, String fileAddress) {

        File downloadFile = new File(fileAddress);
        if(downloadFile.exists()) {
            response.setContentType("application/octet-stream");
            String headerKey = "Content-Disposition";
            String fileName = downloadFile.getName().split("---")[1];
            String headerValue = "attachment; filename=" + fileName;
            response.setHeader(headerKey, headerValue);
            response.setContentLength((int) downloadFile.length());
            try {
                InputStream myStream = new FileInputStream(fileAddress);
                OutputStream toClient = response.getOutputStream();
                IOUtils.copy(myStream, toClient);
                response.flushBuffer();
                myStream.close();
                toClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            new Exception("不存在文件").printStackTrace();
        }
    }
}
