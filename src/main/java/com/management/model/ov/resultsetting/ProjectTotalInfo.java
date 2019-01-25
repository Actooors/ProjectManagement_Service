package com.management.model.ov.resultsetting;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.models.auth.In;
import lombok.Data;

import java.util.Date;

/**
 * @program: management
 * @description: 查找用户目前在申报中的项目
 * @author: ggmr
 * @create: 2018-12-25 16:31
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectTotalInfo {
    private Integer projectApplicationId;
    private String projectName;
    private String projectCategory;
    private String time;
    private String reviewPhase;
    private String description;
    private Integer status;
    private String reportAddress;
    private String adminName;
    private String failMessage;
}
