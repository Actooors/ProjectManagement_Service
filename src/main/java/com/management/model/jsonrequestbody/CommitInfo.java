package com.management.model.jsonrequestbody;

import lombok.Data;

/**
 * @program: management
 * @description: 上传中期报告和结题报告的信息
 * @author: ggmr
 * @create: 2018-12-26 09:17
 */
@Data
public class CommitInfo {
    private Integer applicationId;
    private String uploadAddress;
    private Integer type;
}
