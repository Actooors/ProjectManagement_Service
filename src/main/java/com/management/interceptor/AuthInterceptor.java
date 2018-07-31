package com.management.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.model.OV.Result;
import com.management.model.OV.ResultCode;
import com.management.tools.ChangeCharset;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: management
 * @description: 拦截器，用于在调用每一个controller之前验证token
 * @author: ggmr
 * @create: 2018-07-31 12:42
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {
    private static final String LOGIN_URL = "/api/login";
    private static final int HTTP_CODE = 401;
    private static final String TOKEN_NAME = "Authorization";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 登陆接口不做拦截
        if (LOGIN_URL.equals(request.getRequestURI())) {
            return true;
        }
        if(request.getHeader(TOKEN_NAME) == null) {
            returnErrorMessage(response);
//                response.sendError(HTTP_CODE, "error message");
            return false;
        } else {
            return true;
        }
    }


    private void returnErrorMessage(HttpServletResponse response) throws IOException {
        Result rst = new Result();
        rst.setCode(ResultCode.FAILED);
        rst.setMessage("请登录后再访问页面");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String jsonOfRST = mapper.writeValueAsString(rst);
        out.print(jsonOfRST);
        out.flush();
    }
}
