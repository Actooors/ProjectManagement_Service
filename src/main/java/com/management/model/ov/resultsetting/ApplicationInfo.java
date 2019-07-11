package com.management.model.ov.resultsetting;

import lombok.Data;

import java.util.Date;

/**
 * @program: management
 * @description: 领导查看项目申请信息
 * @author: xw
 * @create: 2019-07-10 15:12
 */
@Data
public class ApplicationInfo {
    private String projectName;
    private String projectDescription;
    private Integer projectMoney;
    private String userId;
    private String userName;
    private String projectIndex;
    private String projectApplicationUploadAddress;
    private String isMeeting;
    private String meetingReviewMessage;
    private String reviewPhase;
    private String failureReason;
    private String applicationTime;
}
