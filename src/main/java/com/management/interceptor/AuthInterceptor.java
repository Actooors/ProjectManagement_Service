package com.management.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.model.ov.Result;
import com.management.model.ov.ResultCode;
import com.management.tools.JwtUtil;
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
    private static final String TOKEN_NAME = "Authorization";
    private static final String EXPERT_URL = "/api/expert";
    private static final String ADMIN_URL = "/api/admin";
    private static final String LEADER_URL = "/api/leader";
    private static final String USER_URL = "/api/user";
    private static final int USER = 1;
    private static final int ADMIN = 2;
    private static final int EXPERT = 3;
    private static final int LEADER = 4;
    private static final int SUPER_ADMIN = 5;
    private static final int HTTP_CODE = 401;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 登陆接口和Swagger界面不做拦截
        String requestUri = request.getRequestURI();
        if (LOGIN_URL.equals(requestUri) ||
            request.getMethod().equals("OPTIONS")) {
            return true;
        }
        // 判断token是否正确
        if (request.getHeader(TOKEN_NAME) == null) {
            returnErrorMessage(response, 1);
            return false;
        } else {
            String token = request.getHeader("Authorization");
            try {
                JwtUtil.parseJwt(token);
            } catch (Exception e) {
                returnErrorMessage(response, 2);
                return false;
            }
            // 在token没有问题的情况下判断返回的用户访问的页面是否符合规则
//            return judgeType(token, requestUri, response);
            return true;
        }
    }

    private boolean judgeType(String token, String requestUri,
                              HttpServletResponse response) throws IOException {
        int type = JwtUtil.parseJwtForIdentity(token);
        if( (type == USER && !requestUri.contains(USER_URL)) ||
            (type == ADMIN && !requestUri.contains(ADMIN_URL)) ||
            (type == EXPERT && !requestUri.contains(EXPERT_URL)) ||
            (type == LEADER && !requestUri.contains(LEADER_URL)) ) {
            returnErrorMessage(response, 3);
            return false;
        }
        return true;
    }

    private void returnErrorMessage(HttpServletResponse response, int type) throws IOException {
        Result rst = new Result();
        rst.setCode(ResultCode.FAILED);
        if(type == 1) {
            rst.setMessage("请登录后再访问页面");
        } else if(type == 2){
            rst.setMessage("token已经过期");
        } else {
            rst.setMessage("您不具有访问该页面的权限");
        }
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HTTP_CODE);
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String jsonOfRST = mapper.writeValueAsString(rst);
        out.print(jsonOfRST);
        out.flush();
    }


}
