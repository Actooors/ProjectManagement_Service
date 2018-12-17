package com.management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.management.dao")
public class ManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementApplication.class, args);
    }
}
