package com.management.model.ov.resultsetting;

import lombok.Data;

/**
 * @program: management
 * @description: 等待领导终审的项目的信息
 * @author: ggmr
 * @create: 2018-08-15 19:28
 */
@Data
public class WaitJudgeProjectInfo {
    private Integer projectId;
    private String projectName;
    private String description;
}
