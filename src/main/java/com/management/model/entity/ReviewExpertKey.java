package com.management.model.entity;

public class ReviewExpertKey {
    private String expertId;

    private String projectApplicationId;

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId == null ? null : expertId.trim();
    }

    public String getProjectApplicationId() {
        return projectApplicationId;
    }

    public void setProjectApplicationId(String projectApplicationId) {
        this.projectApplicationId = projectApplicationId == null ? null : projectApplicationId.trim();
    }
}