package com.management.model.ov.resultsetting;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * @program: management
 * @description: 业务员审核项目大类某一个阶段的整体
 * @author: ggmr
 * @create: 2018-12-30 16:36
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminJudgeTotalInfo {
    private int projectId;
    private int projectCategoryId;
    private String projectCategoryName;
    private String applicationDeadLine;
    private String projectName;
    private String projectDownloadAddress;
    private String description;
    private String indexContent;
    private ExpertOpinionMain expertOpinion;
    private String projectMaxMoney;
    private Integer projectMoney;
}
