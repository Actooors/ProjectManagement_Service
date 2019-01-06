package com.management.SecurityConfig;

import com.management.model.ov.Result;
import com.management.tools.ResultTool;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: management
 * @description: Security报错信息配置
 * @author: xw
 * @create: 2019-01-06 23:56
 */
public class RestAuthenticationAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        PrintWriter writer = response.getWriter();
        writer.println(ResultTool.error(accessDeniedException.getMessage()));
    }
}
