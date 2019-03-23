package com.management.model.jsonrequestbody;

import lombok.Data;

import java.util.List;

/**
 * @program: management
 * @description: 业务员初审
 * @author: ggmr
 * @create: 2018-12-27 08:38
 */
@Data
public class OneJudgeInfo {
    private String applicationId;//new
    private Boolean judge;
    private String msg;
    private List<String> expertList;

}
