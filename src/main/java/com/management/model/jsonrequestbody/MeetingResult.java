package com.management.model.jsonrequestbody;

import lombok.Data;

/**
 * @program: management
 * @description: 会评意见
 * @author: ggmr
 * @create: 2018-12-27 09:53
 */
@Data
public class MeetingResult {
    private int applicationId;
    private Boolean judge;
    private String msg;
    private Integer projectMoney;
}
