package com.management.model.jsonrequestbody;

import lombok.Data;

/**
 * @program: management
 * @description: 审核一个项目的各个阶段的前端给予的post请求格式
 * @author: ggmr
 * @create: 2018-08-15 20:08
 */
@Data
public class IsProjectPassedPostInfo {
    private Integer projectId;
    private Integer isPassed;
    private String message;
}
