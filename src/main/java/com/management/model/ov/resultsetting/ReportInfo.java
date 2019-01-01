package com.management.model.ov.resultsetting;

import lombok.Data;

/**
 * @program: management
 * @description: 中期报告和结题报告具体信息
 * @author: ggmr
 * @create: 2018-12-30 22:00
 */
@Data
public class ReportInfo {
    private Boolean isReportActivated;
    private String reportTemplateAddress;
    private String startTime;
    private String deadline;
}
