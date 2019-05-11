package com.management.model.entity;

/**
 * @program: management
 * @description: 返回给前端leader基本信息
 * @author: xw
 * @create: 2019-05-11 16:38
 */
public class LeaderInfo {
    private String userId;
    private String userName;
    private String department;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
