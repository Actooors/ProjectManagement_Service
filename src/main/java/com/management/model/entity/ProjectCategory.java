package com.management.model.entity;

import java.util.Date;

public class ProjectCategory implements Comparable<ProjectCategory>{
    private Integer projectCategoryId;

    private String projectCategoryName;

    private String projectCategoryDescription;

    private String projectCategoryDescriptionAddress;

    private Integer projectType;

    private String principalId;

    private String principalName;

    private String principalPhone;

    private String applicantType;

    private String maxMoney;

    private String reviewLeaderId;

    private String reviewLeaderName;

    private Integer isExistMeetingReview;

    private String projectApplicationDownloadAddress;

    private Date applicationStartTime;

    private Date applicationEndTime;

    private Date projectStartTime;

    private Date projectEndTime;

    private Integer isInterimReportActivated;

    private Date interimReportStartTime;

    private Date interimReportEndTime;

    private String interimReportDownloadAddress;

    private Integer isConcludingReportActivated;

    private Date concludingReportStartTime;

    private Date concludingReportEndTime;

    private String concludingReportDownloadAddress;

    private Integer statistics;

    private Integer isApproved;

    private String failureReason;

    private String reviewExpertId;

    private String expertList;

    @Override
    public int compareTo(ProjectCategory o) {
        return o.projectType.compareTo(this.projectType);
    }

    public Integer getProjectCategoryId() {
        return projectCategoryId;
    }

    public void setProjectCategoryId(Integer projectCategoryId) {
        this.projectCategoryId = projectCategoryId;
    }

    public String getProjectCategoryName() {
        return projectCategoryName;
    }

    public void setProjectCategoryName(String projectCategoryName) {
        this.projectCategoryName = projectCategoryName == null ? null : projectCategoryName.trim();
    }

    public String getProjectCategoryDescription() {
        return projectCategoryDescription;
    }

    public void setProjectCategoryDescription(String projectCategoryDescription) {
        this.projectCategoryDescription = projectCategoryDescription == null ? null : projectCategoryDescription.trim();
    }

    public String getProjectCategoryDescriptionAddress() {
        return projectCategoryDescriptionAddress;
    }

    public void setProjectCategoryDescriptionAddress(String projectCategoryDescriptionAddress) {
        this.projectCategoryDescriptionAddress = projectCategoryDescriptionAddress == null ? null : projectCategoryDescriptionAddress.trim();
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public String getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(String principalId) {
        this.principalId = principalId == null ? null : principalId.trim();
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName == null ? null : principalName.trim();
    }

    public String getPrincipalPhone() {
        return principalPhone;
    }

    public void setPrincipalPhone(String principalPhone) {
        this.principalPhone = principalPhone == null ? null : principalPhone.trim();
    }

    public String getApplicantType() {
        return applicantType;
    }

    public void setApplicantType(String applicantType) {
        this.applicantType = applicantType == null ? null : applicantType.trim();
    }

    public String getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(String maxMoney) {
        this.maxMoney = maxMoney == null ? null : maxMoney.trim();
    }

    public String getReviewLeaderId() {
        return reviewLeaderId;
    }

    public void setReviewLeaderId(String reviewLeaderId) {
        this.reviewLeaderId = reviewLeaderId == null ? null : reviewLeaderId.trim();
    }

    public String getReviewLeaderName() {
        return reviewLeaderName;
    }

    public void setReviewLeaderName(String reviewLeaderName) {
        this.reviewLeaderName = reviewLeaderName == null ? null : reviewLeaderName.trim();
    }

    public Integer getIsExistMeetingReview() {
        return isExistMeetingReview;
    }

    public void setIsExistMeetingReview(Integer isExistMeetingReview) {
        this.isExistMeetingReview = isExistMeetingReview;
    }

    public String getProjectApplicationDownloadAddress() {
        return projectApplicationDownloadAddress;
    }

    public void setProjectApplicationDownloadAddress(String projectApplicationDownloadAddress) {
        this.projectApplicationDownloadAddress = projectApplicationDownloadAddress == null ? null : projectApplicationDownloadAddress.trim();
    }

    public Date getApplicationStartTime() {
        return applicationStartTime;
    }

    public void setApplicationStartTime(Date applicationStartTime) {
        this.applicationStartTime = applicationStartTime;
    }

    public Date getApplicationEndTime() {
        return applicationEndTime;
    }

    public void setApplicationEndTime(Date applicationEndTime) {
        this.applicationEndTime = applicationEndTime;
    }

    public Date getProjectStartTime() {
        return projectStartTime;
    }

    public void setProjectStartTime(Date projectStartTime) {
        this.projectStartTime = projectStartTime;
    }

    public Date getProjectEndTime() {
        return projectEndTime;
    }

    public void setProjectEndTime(Date projectEndTime) {
        this.projectEndTime = projectEndTime;
    }

    public Integer getIsInterimReportActivated() {
        return isInterimReportActivated;
    }

    public void setIsInterimReportActivated(Integer isInterimReportActivated) {
        this.isInterimReportActivated = isInterimReportActivated;
    }

    public Date getInterimReportStartTime() {
        return interimReportStartTime;
    }

    public void setInterimReportStartTime(Date interimReportStartTime) {
        this.interimReportStartTime = interimReportStartTime;
    }

    public Date getInterimReportEndTime() {
        return interimReportEndTime;
    }

    public void setInterimReportEndTime(Date interimReportEndTime) {
        this.interimReportEndTime = interimReportEndTime;
    }

    public String getInterimReportDownloadAddress() {
        return interimReportDownloadAddress;
    }

    public void setInterimReportDownloadAddress(String interimReportDownloadAddress) {
        this.interimReportDownloadAddress = interimReportDownloadAddress == null ? null : interimReportDownloadAddress.trim();
    }

    public Integer getIsConcludingReportActivated() {
        return isConcludingReportActivated;
    }

    public void setIsConcludingReportActivated(Integer isConcludingReportActivated) {
        this.isConcludingReportActivated = isConcludingReportActivated;
    }

    public Date getConcludingReportStartTime() {
        return concludingReportStartTime;
    }

    public void setConcludingReportStartTime(Date concludingReportStartTime) {
        this.concludingReportStartTime = concludingReportStartTime;
    }

    public Date getConcludingReportEndTime() {
        return concludingReportEndTime;
    }

    public void setConcludingReportEndTime(Date concludingReportEndTime) {
        this.concludingReportEndTime = concludingReportEndTime;
    }

    public String getConcludingReportDownloadAddress() {
        return concludingReportDownloadAddress;
    }

    public void setConcludingReportDownloadAddress(String concludingReportDownloadAddress) {
        this.concludingReportDownloadAddress = concludingReportDownloadAddress == null ? null : concludingReportDownloadAddress.trim();
    }

    public Integer getStatistics() {
        return statistics;
    }

    public void setStatistics(Integer statistics) {
        this.statistics = statistics;
    }

    public Integer getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Integer isApproved) {
        this.isApproved = isApproved;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason == null ? null : failureReason.trim();
    }

    public String getReviewExpertId() {
        return reviewExpertId;
    }

    public void setReviewExpertId(String reviewExpertId) {
        this.reviewExpertId = reviewExpertId == null ? null : reviewExpertId.trim();
    }

    public String getExpertList() {
        return expertList;
    }

    public void setExpertList(String expertList) {
        this.expertList = expertList == null ? null : expertList.trim();
    }
}