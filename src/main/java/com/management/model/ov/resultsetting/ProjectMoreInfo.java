package com.management.model.ov.resultsetting;

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
    private int applicationId;
    private int projectCategoryId;
    private String projectName;
    private List<ProjectMembers> members;
    private String description;
    private String applicationAddress;
    private String interimAddress;
    private String concludingAddress;
}
