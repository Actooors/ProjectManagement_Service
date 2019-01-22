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
    private String principalPhone;
    private int projectType;
    private List<Integer> applicantType;
    private String maxMoney;
    private String projectApplicationDownloadAddress;
    private Boolean isExistMeetingReview;
    private String applicationStartTime;
    private String applicationEndTime;
    private String projectStartTime;
    private String projectEndTime;
//    private List<String> expertList;

}
