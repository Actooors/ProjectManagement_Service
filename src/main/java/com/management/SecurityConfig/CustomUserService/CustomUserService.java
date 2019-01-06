package com.management.SecurityConfig.CustomUserService;

import com.management.dao.UserMapper;
import com.management.model.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: management
 * @description: 配置用户权限相关的Service方法
 * @author: xw
 * @create: 2019-01-06 18:10
 */
@Service
public class CustomUserService implements UserDetailsService {
    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.selectByPrimaryKey(s);
        if(user == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }
}
