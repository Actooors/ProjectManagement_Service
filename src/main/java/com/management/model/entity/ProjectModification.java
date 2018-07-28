package com.management.model.entity;

public class ProjectModification {
    private Integer projectModificaitonId;

    private Integer projectModificationApplicationId;

    private Integer projectApplicationId;

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

    private String failureReason;

    private Integer isPassed;

    private String modificationMessage;

    public Integer getProjectModificaitonId() {
        return projectModificaitonId;
    }

    public void setProjectModificaitonId(Integer projectModificaitonId) {
        this.projectModificaitonId = projectModificaitonId;
    }

    public Integer getProjectModificationApplicationId() {
        return projectModificationApplicationId;
    }

    public void setProjectModificationApplicationId(Integer projectModificationApplicationId) {
        this.projectModificationApplicationId = projectModificationApplicationId;
    }

    public Integer getProjectApplicationId() {
        return projectApplicationId;
    }

    public void setProjectApplicationId(Integer projectApplicationId) {
        this.projectApplicationId = projectApplicationId;
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

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason == null ? null : failureReason.trim();
    }

    public Integer getIsPassed() {
        return isPassed;
    }

    public void setIsPassed(Integer isPassed) {
        this.isPassed = isPassed;
    }

    public String getModificationMessage() {
        return modificationMessage;
    }

    public void setModificationMessage(String modificationMessage) {
        this.modificationMessage = modificationMessage == null ? null : modificationMessage.trim();
    }
}