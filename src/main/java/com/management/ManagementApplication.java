package com.management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@MapperScan("com.management.dao")
public class ManagementApplication {
    @PostConstruct
    void setDefaultTimezone() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
//    TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
    }
    public static void main(String[] args) {
        SpringApplication.run(ManagementApplication.class, args);
    }
}
