package com.management.model.ov.resultsetting;

import lombok.Data;


/**
 * @program: management
 * @description: 用户查询被驳回的项目
 * @author: xw
 * @create: 2019-01-26 21:31
 */
@Data
public class UserFailProject {
    private String projectName;
    private String time;
    private String description;
    private String reviewPhase;
    private String failMessage;
}
