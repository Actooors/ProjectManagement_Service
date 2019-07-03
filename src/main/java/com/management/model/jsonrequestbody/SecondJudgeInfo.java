package com.management.model.jsonrequestbody;

import lombok.Data;

/**
 * @program: management
 * @description:
 * @author: 0GGmr0
 * @create: 2019-01-14 16:19
 */
@Data
public class SecondJudgeInfo {
    private String applicationId;//new
    private Boolean judge;
    private String msg;
    private Integer projectMoney;
}
