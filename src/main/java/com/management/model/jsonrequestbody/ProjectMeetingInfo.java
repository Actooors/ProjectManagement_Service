package com.management.model.jsonrequestbody;

import lombok.Data;

/**
 * @program: management
 * @description: 决定项目是否上会的接口
 * @author: ggmr
 * @create: 2018-12-27 09:25
 */
@Data
public class ProjectMeetingInfo {
    private Boolean isMeeting;
    private int applicationId;
    private String msg;
}
