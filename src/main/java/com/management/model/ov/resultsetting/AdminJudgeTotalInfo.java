package com.management.model.ov.resultsetting;

import lombok.Data;

import java.util.List;

/**
 * @program: management
 * @description: 业务员审核项目大类某一个阶段的整体
 * @author: ggmr
 * @create: 2018-12-30 16:36
 */
@Data
public class AdminJudgeTotalInfo {
    private int projectId;
    private int projectCategoryId;
    private String projectCategoryName;
    private String applicationDeadLine;
    private String projectName;
    private String projectApplicationDownloadAddress;
    private String description;
    private ExpertOpinionMain expertOpinion;
}
