package com.management.model.entity;

public class ProjectModificationApplication {
    private Integer projectModificationApplicationId;

    private String userId;

    private String modificationReason;

    private Integer projectApplicationId;

    private Integer reviewPhase;

    private String failureReason;

    public Integer getProjectModificationApplicationId() {
        return projectModificationApplicationId;
    }

    public void setProjectModificationApplicationId(Integer projectModificationApplicationId) {
        this.projectModificationApplicationId = projectModificationApplicationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getModificationReason() {
        return modificationReason;
    }

    public void setModificationReason(String modificationReason) {
        this.modificationReason = modificationReason == null ? null : modificationReason.trim();
    }

    public Integer getProjectApplicationId() {
        return projectApplicationId;
    }

    public void setProjectApplicationId(Integer projectApplicationId) {
        this.projectApplicationId = projectApplicationId;
    }

    public Integer getReviewPhase() {
        return reviewPhase;
    }

    public void setReviewPhase(Integer reviewPhase) {
        this.reviewPhase = reviewPhase;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason == null ? null : failureReason.trim();
    }
}