package com.management.model.jsonrequestbody;


import lombok.Data;

@Data
public class ProjectCategoryInfo {

    private String projectName;
    private String projectDescription;
    private String projectDescriptionAddress;
    private Integer projectType;
    private String principalPhone;
    private String applicantType;
    private String maxMoney;
    private String reviewLeaderId;
    private String projectApplicationDownloadAddress;
    private int isEexistMeetingReview;
    private String applicationStartTime;
    private String applicationEndTime;
    private String projectStartTime;
    private String projectEndTime;
}
