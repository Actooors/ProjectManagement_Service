package com.management.model.ov.resultsetting;

import com.management.model.jsonrequestbody.ProjectMembers;
import lombok.Data;

import java.util.List;

/**
 * @program: management
 * @description: 返回待领导审核的结题报告的列表
 * @author: 0GGmr0
 * @create: 2019-01-14 23:02
 */
@Data
public class FinalReportInfo {
    private int projectCategoryId;
    private String projectCategoryName;

    private int projectId;
    private String projectName;
    private String description;
    private String userId;
    private String userName;
    private String department;
    private String projectApplicationDownloadAddress;
    private String concludingReportEndTime;
    private ExpertOpinionMain expertOpinion;
}
