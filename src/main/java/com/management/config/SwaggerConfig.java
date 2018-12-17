package com.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: management
 * @description: swagger配置类
 * @author: ggmr
 * @create: 2018-07-29 14:08
 */


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.management.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder()
                .title("上海大学项目管理系统API列表")
                .description("上海大学项目管理系统API")
                .contact(new Contact("上海大学信息办", "", ""))
                .version("1.0")
                .build();
    }
}
