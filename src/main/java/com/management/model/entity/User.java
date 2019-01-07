package com.management.model.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User implements UserDetails {
    private String userId;

    private String userName;

    private String sex;

    private String department;

    private String phone;

    private String mail;

    private String position;

    private String major;

    private Integer identity;

    private Integer isAbleLogin;

    private String leaderId;

    private String password;


    /*
    以下是配置用户的角色用于权限控制
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        if(this.identity == 1){
            auths.add(new SimpleGrantedAuthority("ROLE_USER"));
        }else if(this.identity == 2){
            auths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }else if(this.identity == 3){
            auths.add(new SimpleGrantedAuthority("ROLE_EXPERT"));
        }else if(this.identity == 4){
            auths.add(new SimpleGrantedAuthority("ROLE_LEADER"));
        }

        //System.out.print(auths);
        return auths;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getIsAbleLogin() {
        return isAbleLogin;
    }

    public void setIsAbleLogin(Integer isAbleLogin) {
        this.isAbleLogin = isAbleLogin;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId == null ? null : leaderId.trim();
    }

    /*
    以下是implements UserDetails所必写内容,无实际意义,暂时先不删除
     */

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}