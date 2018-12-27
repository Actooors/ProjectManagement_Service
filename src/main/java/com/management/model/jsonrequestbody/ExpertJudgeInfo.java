package com.management.model.jsonrequestbody;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @program: management
 * @description: 审核专家提交审批信息
 * @author: xw
 * @create: 2018-12-27 10:15
 */
@Data
public class ExpertJudgeInfo {
    @JsonProperty("applicationId")
    private Integer projectApplicationId;
    private String score;
    private String reviewOpinion;
    private Integer finalOpinion;
}
