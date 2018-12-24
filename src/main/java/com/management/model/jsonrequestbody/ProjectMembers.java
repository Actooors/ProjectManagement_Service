package com.management.model.jsonrequestbody;

import lombok.Data;

/**
 * @program: management
 * @description: 项目成员
 * @author: ggmr
 * @create: 2018-12-24 23:31
 */
@Data
public class ProjectMembers {
    private String userId;
    private String userName;
    private String department;
    private String phone;
    private String mail;
}
