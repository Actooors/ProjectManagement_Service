package com.management.model.jsonrequestbody;

import lombok.Data;

import java.util.List;

/**
 * @program: management
 * @description: 业务员选择项目上会
 * @author: ggmr
 * @create: 2018-08-15 20:32
 */
@Data
public class ChooseProjectMeeting {
    private List<ProjectMeetingInfo> meetingList;
}
