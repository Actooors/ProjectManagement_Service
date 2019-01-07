package com.management.security;

import com.management.dao.UserMapper;
import com.management.model.entity.User;
import com.management.model.ov.resultsetting.ConstCorrespond;
import com.management.tools.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: management
 * @description: 请求接口时候的验证类
 * @author: ggmr
 * @create: 2019-01-05 14:21
 */

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    private UserMapper userMapper;

    private UserDetailsService myUserDetailService;
    private JwtUtil jwtUtil;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public JwtAuthenticationTokenFilter(@Qualifier("myUserDetailService") UserDetailsService userDetailsService,
                                        JwtUtil jwtTokenUtil) {
        this.myUserDetailService   = userDetailsService;
        this.jwtUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {

        logger.info("processing authentication for '{}'", request.getRequestURL());
        final String requestHeader = request.getHeader("Authorization");

        String token = null;
        String userId = null;

        if(requestHeader != null && requestHeader.startsWith(ConstCorrespond.TOKEN_HEAD)) {
            token = requestHeader.substring(7);
            logger.info("请求" + request.getRequestURI() + "携带的token值" + token);
            try {
                userId = JwtUtil.parseJwt(token);
            } catch (IllegalArgumentException e) {
                logger.error("获取用户的权限失败，发生错误", e);
            }
        }

        logger.info("checking authentication for user '{}'", userId);

        boolean saved = false;

        if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            logger.info("security context was null, so authorization user");

            UserDetails userDetails = myUserDetailService.loadUserByUsername(userId);

            if (jwtUtil.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                logger.info("authorized user '{}', setting security context", userId);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                String userIdFromToken = jwtUtil.getUserIdFromToken(token);
                User user = userMapper.selectByPrimaryKey(userIdFromToken);
                try (UserContext ignored = new UserContext(user)) {
                    //之所以这样写是为了有一个线程级别的一个tokne的信息，然后方便我去操作
                    logger.info("authorized user '{}', saving security context", userId);
                    saved = true;
                    chain.doFilter(request, response);
                }
            }
        }
        if(!saved) {
        chain.doFilter(request, response);
        }
    }
}
