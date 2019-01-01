package com.management.model.ov.resultsetting;

import lombok.Data;

import java.util.List;

/**
 * @program: management
 * @description: 业务员所有的项目大类的详情
 * @author: ggmr
 * @create: 2018-12-30 18:15
 */
@Data
public class AdminListInfo {
    private String projectName;
    private String projectDescription;
    private String projectDescriptionAddress;
    private String principalPhone;
    private String projectType;
    private List<String> applicantType;
    private String maxMoney;
    private String projectApplicationDownloadAddress;
    private Integer isExistMeetingReview;
    private String applicationStartTime;
    private String applicationEndTime;
    private String projectStartTime;
    private String projectEndTime;
    private List<ExpertListInfo> expertList;
    private ReportInfo interimReport;
    private ReportInfo concludingReport;
}
