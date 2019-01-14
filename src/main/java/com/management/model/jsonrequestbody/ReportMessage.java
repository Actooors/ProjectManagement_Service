package com.management.model.jsonrequestbody;

import lombok.Data;

import java.util.Date;

/**
 * @program: management
 * @description: 业务员开通中期/结题报告
 * @author: 0GGmr0
 * @create: 2019-01-14 20:50
 */
@Data
public class ReportMessage {
    private int projectCategoryId;
    // type 1 中期报告  2结题报告
    private int type;
    private String reportAddress;
    private String startTime;
    private String deadline;
}
