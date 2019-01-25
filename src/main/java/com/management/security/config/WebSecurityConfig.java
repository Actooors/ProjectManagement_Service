package com.management.security.config;

import com.management.security.JwtAccessDeniedHandler;
import com.management.security.JwtAuthenticationEntryPoint;
import com.management.security.JwtAuthenticationTokenFilter;
import com.management.security.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @program: management
 * @description: spring security类
 * @author: ggmr
 * @create: 2019-01-02 00:26
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Resource
    private MyUserDetailService myUserDetailService;

    @Resource
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Resource
    private JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {



        http
                .csrf().disable()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //对请求进行认证
                .authorizeRequests()
                    .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // 对于获取token的rest api要允许匿名访问
                    .antMatchers("/login").permitAll()
                    .antMatchers("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**").permitAll()
                    .antMatchers("/admin/**").access("hasAnyAuthority('ROLE_ADMIN','ROLE_LEADER','ROLE_USER')")
                    .antMatchers("/leader/**").access("hasAuthority('ROLE_LEADER')")
                    .antMatchers("/expert/**").access("hasAuthority('ROLE_EXPERT')")
                    .antMatchers("/user/**").access("hasAnyAuthority('ROLE_ADMIN','ROLE_EXPERT','ROLE_LEADER','ROLE_USER')");

        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        //对于没有登录的用户，要返回401
        http.exceptionHandling().authenticationEntryPoint(unauthorizedHandler);
        //对于登录了但是权限有问题的用户，要返回403
        http.exceptionHandling().accessDeniedHandler(jwtAccessDeniedHandler);
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {

        return super.authenticationManagerBean();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(myUserDetailService);
    }
}
