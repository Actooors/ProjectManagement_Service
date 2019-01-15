package com.management.model.entity;

import java.util.Date;

public class ProjectProgress {
    private Integer projectProgressId;

    private String userId;

    private String interimReportUploadAddress;

    private Date interimReportTime;

    private Integer isFinishedInterimReport;

    private String interimReportFailureReason;

    private String concludingReportUploadAddress;

    private Date concludingReportTime;

    private Integer isFinishedConcludingReport;

    private String concludingReportFailureReason;

    private Integer projectProcess;

    private Integer projectCategoryId;

    private String projectName;

    private String description;

    private String userName;

    private String department;

    private Date projectcreatetime;

    public Integer getProjectProgressId() {
        return projectProgressId;
    }

    public void setProjectProgressId(Integer projectProgressId) {
        this.projectProgressId = projectProgressId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getInterimReportUploadAddress() {
        return interimReportUploadAddress;
    }

    public void setInterimReportUploadAddress(String interimReportUploadAddress) {
        this.interimReportUploadAddress = interimReportUploadAddress == null ? null : interimReportUploadAddress.trim();
    }

    public Date getInterimReportTime() {
        return interimReportTime;
    }

    public void setInterimReportTime(Date interimReportTime) {
        this.interimReportTime = interimReportTime;
    }

    public Integer getIsFinishedInterimReport() {
        return isFinishedInterimReport;
    }

    public void setIsFinishedInterimReport(Integer isFinishedInterimReport) {
        this.isFinishedInterimReport = isFinishedInterimReport;
    }

    public String getInterimReportFailureReason() {
        return interimReportFailureReason;
    }

    public void setInterimReportFailureReason(String interimReportFailureReason) {
        this.interimReportFailureReason = interimReportFailureReason == null ? null : interimReportFailureReason.trim();
    }

    public String getConcludingReportUploadAddress() {
        return concludingReportUploadAddress;
    }

    public void setConcludingReportUploadAddress(String concludingReportUploadAddress) {
        this.concludingReportUploadAddress = concludingReportUploadAddress == null ? null : concludingReportUploadAddress.trim();
    }

    public Date getConcludingReportTime() {
        return concludingReportTime;
    }

    public void setConcludingReportTime(Date concludingReportTime) {
        this.concludingReportTime = concludingReportTime;
    }

    public Integer getIsFinishedConcludingReport() {
        return isFinishedConcludingReport;
    }

    public void setIsFinishedConcludingReport(Integer isFinishedConcludingReport) {
        this.isFinishedConcludingReport = isFinishedConcludingReport;
    }

    public String getConcludingReportFailureReason() {
        return concludingReportFailureReason;
    }

    public void setConcludingReportFailureReason(String concludingReportFailureReason) {
        this.concludingReportFailureReason = concludingReportFailureReason == null ? null : concludingReportFailureReason.trim();
    }

    public Integer getProjectProcess() {
        return projectProcess;
    }

    public void setProjectProcess(Integer projectProcess) {
        this.projectProcess = projectProcess;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Date getProjectcreatetime() {
        return projectcreatetime;
    }

    public void setProjectcreatetime(Date projectcreatetime) {
        this.projectcreatetime = projectcreatetime;
    }
}