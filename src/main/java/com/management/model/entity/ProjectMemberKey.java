package com.management.model.entity;

public class ProjectMemberKey {
    private String userId;

    private String projectApplicationId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getProjectApplicationId() {
        return projectApplicationId;
    }

    public void setProjectApplicationId(String projectApplicationId) {
        this.projectApplicationId = projectApplicationId == null ? null : projectApplicationId.trim();
    }
}