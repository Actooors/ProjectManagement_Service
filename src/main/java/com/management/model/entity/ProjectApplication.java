package com.management.model.entity;

import java.util.Date;

public class ProjectApplication {
    private Integer projectApplicationId;

    private Integer projectCategoryId;

    private String projectName;

    private String projectMember;

    private String projectDescription;

    private String userId;

    private String userName;

    private String sex;

    private String department;

    private String phone;

    private String mail;

    private String position;

    private String major;

    private String projectApplicationUploadAddress;

    private Integer isMeeting;

    private String meetingReviewMessage;

    private Integer reviewPhase;

    private String failureReason;

    private Date applicationTime;

    private Date applicationDeadline;

    private Date middleDeadline;

    private Date finalDeadline;

    private Date projectDeadline;

    public Integer getProjectApplicationId() {
        return projectApplicationId;
    }

    public void setProjectApplicationId(Integer projectApplicationId) {
        this.projectApplicationId = projectApplicationId;
    }

    public Integer getProjectCategoryId() {
        return projectCategoryId;
    }

    public void setProjectCategoryId(Integer projectCategoryId) {
        this.projectCategoryId = projectCategoryId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectMember() {
        return projectMember;
    }

    public void setProjectMember(String projectMember) {
        this.projectMember = projectMember == null ? null : projectMember.trim();
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription == null ? null : projectDescription.trim();
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

    public Date getApplicationDeadline() {
        return applicationDeadline;
    }

    public void setApplicationDeadline(Date applicationDeadline) {
        this.applicationDeadline = applicationDeadline;
    }

    public Date getMiddleDeadline() {
        return middleDeadline;
    }

    public void setMiddleDeadline(Date middleDeadline) {
        this.middleDeadline = middleDeadline;
    }

    public Date getFinalDeadline() {
        return finalDeadline;
    }

    public void setFinalDeadline(Date finalDeadline) {
        this.finalDeadline = finalDeadline;
    }

    public Date getProjectDeadline() {
        return projectDeadline;
    }

    public void setProjectDeadline(Date projectDeadline) {
        this.projectDeadline = projectDeadline;
    }
}