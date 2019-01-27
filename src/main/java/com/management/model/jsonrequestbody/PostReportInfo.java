package com.management.model.jsonrequestbody;

import lombok.Data;

/**
 * @program: management
 * @description: 用户提交中期报告/结题报告的接口
 * @author: 0GGmr0
 * @create: 2019-01-14 22:03
 */
@Data
public class PostReportInfo {
    private int applicationId;
    // type 1 中期报告  2结题报告
    private int type;
    private String uploadAddress;
    private int status;
}
