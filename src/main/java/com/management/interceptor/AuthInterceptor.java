package com.management.interceptor;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.management.tools.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: management
 * @description: 拦截器，用于在调用每一个controller之前验证token
 * @author: ggmr
 * @create: 2018-07-31 12:42
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
    private static final String LOGIN_URL = "/api/login";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 登陆接口不做拦截
        if (LOGIN_URL.equals(request.getRequestURI())) {
            return true;
        }
        try {
            String userId = JwtUtil.parseJwt(request.getHeader("Authorization"));
            return userId != null;
        } catch (JWTVerificationException e) {
            return false;
        }

    }
}
