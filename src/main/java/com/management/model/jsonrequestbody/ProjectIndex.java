package com.management.model.jsonrequestbody;

import lombok.Data;

/**
 * @program: management
 * @description: 用户提交的任务书信息
 * @author: xw
 * @create: 2019-01-25 23:15
 */
@Data
public class ProjectIndex {
    private Integer projectApplicationId;
    private String projectIndex;
    private Integer projectMoney;
}
