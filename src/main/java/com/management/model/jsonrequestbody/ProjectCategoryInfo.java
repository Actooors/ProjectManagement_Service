package com.management.model.jsonrequestbody;


import lombok.Data;

import java.util.List;

/**
 * @Description: 业务员创建项目大类请求的数据格式
 * @Author: xw
 * @Date: 18-12-18
 */
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
    private Integer isExistMeetingReview;
    private String applicationStartTime;
    private String applicationEndTime;
    private String projectStartTime;
    private String projectEndTime;
    private List<String> expertList;

}
