package com.management.model.ov.resultsetting;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.management.model.jsonrequestbody.ProjectMembers;
import lombok.Data;

import java.util.List;

/**
 * @program: management
 * @description: 项目详细信息
 * @author: ggmr
 * @create: 2018-12-26 18:43
 */
@Data
public class ProjectMoreInfo {
    private String applicationId;//new
    private String projectCategoryId;//new
    private String projectName;
    private List<ProjectMembers> members;
    private String description;
    private String applicationAddress;
    private String interimAddress;
    private String concludingAddress;
    private Integer projectMoney;
    private String projectIndex;
    private List<ExpertListInfo> expertList;
}
