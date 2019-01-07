package com.management.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @program: management
 * @description: 用于权限控制的User类
 *               UserDetails中封装了spring security登录需要的所有信息
 * @author: ggmr
 * @create: 2019-01-03 17:21
 */
@Data
public class JwtUser implements UserDetails {

    private String userId; // 用户工号
    private String password; // 用户密码
    private Integer identity; //用户身份的数字
    private final Collection<? extends GrantedAuthority> authorities;  //用户角色权限
    private final Boolean isAccountNonExpired;       //账号是否过期
    private final Boolean isAccountNonLocked;        //账户是否锁定
    private final Boolean isCredentialsNonExpired;   //密码是否过期
    private final Boolean enabled;                   //是否激活

    JwtUser(String userId, String password, Integer identity,
            Collection<? extends GrantedAuthority> authorities) {

        this.userId = userId;
        this.password = password;
        this.authorities = authorities;
        this.identity = identity;
        this.isAccountNonExpired = true;
        this.isAccountNonLocked = true;
        this.enabled = true;
        this.isCredentialsNonExpired = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername() {
        return this.userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
