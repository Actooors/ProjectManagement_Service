package com.management.SecurityConfig;

import com.management.SecurityConfig.CustomUserService.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @program: management
 * @description: Security配置類
 * @author: xw
 * @create: 2019-01-05 11:24
 */
@Configuration
//通过 @EnableWebSecurity注解开启Spring Security的功能。
@EnableWebSecurity
// 使用@EnableGlobalMethodSecurity(prePostEnabled = true)这个注解，
// 可以开启security的注解，我们可以在需要控制权限的方法上面使用@PreAuthorize，@PreFilter这些注解
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
// extends 继承 WebSecurityConfigurerAdapter 类，并重写它的方法来设置一些web安全的细节。
// 我们结合@EnableWebSecurity注解和继承WebSecurityConfigurerAdapter，来给我们的系统加上基于web的安全机制
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    protected UserDetailsService customUserService() {

        return new CustomUserService();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    public AccessDeniedHandler getAccessDeniedHandler() {
        return new BootAccessDeniedHandler();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                //由于使用的是JWT，我们这里不需要csrf
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // 对于获取token的rest api要允许匿名访问
                .antMatchers("/login").permitAll()
                .antMatchers("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**").permitAll()
                .antMatchers("/admin/**").access("hasAuthority('ROLE_ADMIN')")
                .antMatchers("/leader/**").access("hasAuthority('ROLE_LEADER')")
                .antMatchers("/expert/**").access("hasAuthority('ROLE_EXPERT')")
                .antMatchers("/user/**").access("hasAnyAuthority('ROLE_ADMIN','ROLE_EXPERT','ROLE_LEADER','ROLE_USER')");
        httpSecurity
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
        httpSecurity
                .exceptionHandling().accessDeniedHandler(getAccessDeniedHandler());
        // 禁用缓存
        httpSecurity.headers().cacheControl();

    }

}
