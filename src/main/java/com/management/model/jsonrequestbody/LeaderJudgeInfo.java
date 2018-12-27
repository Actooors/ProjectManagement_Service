package com.management.model.jsonrequestbody;

import lombok.Data;

/**
 * @program: management
 * @description: 领导审核项目申请信息
 * @author: xw
 * @create: 2018-12-27 20:37
 */
@Data
public class LeaderJudgeInfo {
    private int applicationId;
    private Boolean judge;
    private String msg;
}
