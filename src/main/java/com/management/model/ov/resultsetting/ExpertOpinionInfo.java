package com.management.model.ov.resultsetting;

import lombok.Data;

/**
 * @program: management
 * @description: 审核专家的审核意见
 * @author: ggmr
 * @create: 2018-08-01 16:57
 */
@Data
public class ExpertOpinionInfo {
    private String expertId;
    private String expertName;
    private String score;
    private String reviewOpinion;
    private Integer finalOpinion;
    private int isFinished;
}
