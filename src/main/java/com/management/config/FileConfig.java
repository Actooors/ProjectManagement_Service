package com.management.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * @program: management
 * @description: 限制文件的类
 * @author: ggmr
 * @create: 2018-12-21 20:51
 */
@Configuration
public class FileConfig {
    //限制文件上传的大小
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("10MB");
        factory.setMaxRequestSize("20MB");
//        factory.setLocation("/home/ubuntu/tmp");
        return factory.createMultipartConfig();
    }
}
