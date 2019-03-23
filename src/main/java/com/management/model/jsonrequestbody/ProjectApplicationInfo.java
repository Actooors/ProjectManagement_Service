package com.management.model.jsonrequestbody;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @program: management
 * @description: 申报项目申请的信息
 * @author: ggmr
 * @create: 2018-12-24 23:23
 */
@Data
public class ProjectApplicationInfo {
    private String projectCategoryId;//new
    private String projectCategoryName;
    private String projectApplicationId;//new
    private String projectName;
    private List<ProjectMembers> members;
    private String description;
    private String userId;
    private String userName;
    private String sex;
    private String department;
    private String phone;
    private String mail;
    private String uploadAddress;
    private Integer projectMoney;
    private Boolean isMeeting;
    private String applicationDeadline;
}
