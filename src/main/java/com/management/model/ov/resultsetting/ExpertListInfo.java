package com.management.model.ov.resultsetting;

import lombok.Data;

/**
 * @program: management
 * @description: 业务员决定大类审核专家的时候的专家的列表
 * @author: ggmr
 * @create: 2018-12-27 14:26
 */
@Data
public class ExpertListInfo {
    private String userId;
    private String userName;
    private String department;
    private String phone;
    private String mail;

}
