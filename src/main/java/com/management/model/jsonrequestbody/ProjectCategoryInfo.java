package com.management.model.jsonrequestbody;


import lombok.Data;

import java.util.Date;
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
    private Integer projectType;
    private List<String> applicantType;
    private String maxMoney;
    private String projectApplicationDownloadAddress;
    private Boolean isExistMeetingReview;
    private Date applicationStartTime;
    private Date applicationEndTime;
    private Date projectStartTime;
    private Date projectEndTime;
    private List<String> expertList;

}
