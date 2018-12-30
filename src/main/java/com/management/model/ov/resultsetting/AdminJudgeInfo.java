package com.management.model.ov.resultsetting;

import lombok.Data;

/**
 * @program: management
 * @description: 业务员审核项目大类某一个阶段的项目的列表
 * @author: ggmr
 * @create: 2018-12-30 16:14
 */
@Data
public class AdminJudgeInfo {
    private String projectName;
    private String projectApplicationDownloadAddress;
    private String description;
}
