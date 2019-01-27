package com.management.model.jsonrequestbody;

import com.management.model.ov.resultsetting.UserFailProject;
import lombok.Data;

import java.util.List;

/**
 * @program: management
 * @description: 用户查询被驳回项目数组封装
 * @author: xw
 * @create: 2019-01-26 21:37
 */
@Data
public class UserFailProjectList {
    List<UserFailProject> failApplicationProjects;
    List<UserFailProject> failProgressProjects;
}
