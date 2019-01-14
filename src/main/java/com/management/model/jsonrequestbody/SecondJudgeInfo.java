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
    private int applicationId;
    private Boolean judge;
    private String msg;
}
