package com.management.model.jsonrequestbody;

import lombok.Data;

/**
 * @program: management
 * @description: 领导审核项目大类是否通过的post请求格式
 * @author: ggmr
 * @create: 2018-08-15 16:25
 */
@Data
public class IsProjectCategoryPassedPostInfo {
    private Integer projectCategoryId;
    private Integer isPassed;
    private String message;
}
