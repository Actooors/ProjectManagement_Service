package com.management.model.ov.resultsetting;

import lombok.Data;

/**
 * @program: management
 * @description: 根据工号查询用户的信息
 * @author: 0GGmr0
 * @create: 2019-01-22 22:30
 */
@Data
public class OtherUserInfo {
    private String userId;
    private String username;
    private String department;
}
