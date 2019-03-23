package com.management.model.entity;

import java.util.Date;

public class ProjectApplication {
    private String projectApplicationId;

    private String projectCategoryId;

    private String projectName;

    private String projectDescription;

    private String projectIndex;

    private Integer projectIndexState;

    private Integer projectMoney;

    private String userId;

    private String reviewPrincipalId;

    private String reviewLeaderId;

    private String projectApplicationUploadAddress;

    private Integer isMeeting;

    private String meetingReviewMessage;

    private Integer reviewPhase;

    private String failureReason;

    private Date applicationTime;

    public String getProjectApplicationId() {
        return projectApplicationId;
    }

    public void setProjectApplicationId(String projectApplicationId) {
        this.projectApplicationId = projectApplicationId == null ? null : projectApplicationId.trim();
    }

    public String getProjectCategoryId() {
        return projectCategoryId;
    }

    public void setProjectCategoryId(String projectCategoryId) {
        this.projectCategoryId = projectCategoryId == null ? null : projectCategoryId.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription == null ? null : projectDescription.trim();
    }

    public String getProjectIndex() {
        return projectIndex;
    }

    public void setProjectIndex(String projectIndex) {
        this.projectIndex = projectIndex == null ? null : projectIndex.trim();
    }

    public Integer getProjectIndexState() {
        return projectIndexState;
    }

    public void setProjectIndexState(Integer projectIndexState) {
        this.projectIndexState = projectIndexState;
    }

    public Integer getProjectMoney() {
        return projectMoney;
    }

    public void setProjectMoney(Integer projectMoney) {
        this.projectMoney = projectMoney;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getReviewPrincipalId() {
        return reviewPrincipalId;
    }

    public void setReviewPrincipalId(String reviewPrincipalId) {
        this.reviewPrincipalId = reviewPrincipalId == null ? null : reviewPrincipalId.trim();
    }

    public String getReviewLeaderId() {
        return reviewLeaderId;
    }

    public void setReviewLeaderId(String reviewLeaderId) {
        this.reviewLeaderId = reviewLeaderId == null ? null : reviewLeaderId.trim();
    }

    public String getProjectApplicationUploadAddress() {
        return projectApplicationUploadAddress;
    }

    public void setProjectApplicationUploadAddress(String projectApplicationUploadAddress) {
        this.projectApplicationUploadAddress = projectApplicationUploadAddress == null ? null : projectApplicationUploadAddress.trim();
    }

    public Integer getIsMeeting() {
        return isMeeting;
    }

    public void setIsMeeting(Integer isMeeting) {
        this.isMeeting = isMeeting;
    }

    public String getMeetingReviewMessage() {
        return meetingReviewMessage;
    }

    public void setMeetingReviewMessage(String meetingReviewMessage) {
        this.meetingReviewMessage = meetingReviewMessage == null ? null : meetingReviewMessage.trim();
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

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }
}