package com.management.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @program: management
 * @description: 注册拦截器
 * @author: ggmr
 * @create: 2018-07-31 12:49
 */
@Configuration
public class InterceptorConfigurerAdapter implements WebMvcConfigurer {

    @Resource
    private AuthInterceptor authInterceptor;
    
    /**
     * @Description: 该方法用于注册拦截器，可注册多个拦截器，多个拦截器组成一个拦截器链
     * @Param: [registry]
     * @Return: void
     * @Author: ggmr
     * @Date: 18-7-31
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }



}
