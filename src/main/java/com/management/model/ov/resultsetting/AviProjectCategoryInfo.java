package com.management.model.ov.resultsetting;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: management
 * @description: 可申报的项目的简单信息
 * @author: ggmr
 * @create: 2018-12-17 22:58
 */
@Data
public class AviProjectCategoryInfo {

    private Integer projectId;
    private String projectName;
    private String deadLine;
    private String introduce;

}
