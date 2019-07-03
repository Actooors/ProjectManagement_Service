package com.management.model.ov.resultsetting;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @program: management
 * @description: 查找用户目前在申报中的项目
 * @author: ggmr
 * @create: 2018-12-25 16:31
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectTotalInfo {
    private String projectApplicationId;//new
    private String projectName;
    private String projectCategory;
    private String projectCategoryId;
    private String type;
    private String time;
    private String reviewPhase;
    private String description;
    private Integer status;
    private String reportAddress;
    private String adminName;
    private String failMessage;
    private Boolean isFinished;
    private String myAddress;
    private String missionAddress;
}
