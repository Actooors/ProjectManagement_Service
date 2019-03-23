package com.management.model.ov.resultsetting;

import lombok.Data;

/**
 * @program: management
 * @description: 需要领导审核的项目大类申请的信息
 * @author: ggmr
 * @create: 2018-08-15 19:00
 */
@Data
public class WaitJudgeProjectCategoryInfo {
    private String projectCategoryId;//new
    private String projectCategoryName;
    private Integer type;
    private String adminId;
    private String adminName;
}
