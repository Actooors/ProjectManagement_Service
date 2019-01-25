package com.management.model.ov.resultsetting;

import lombok.Data;

import java.util.List;

/**
 * @program: management
 * @description: 查找我的项目的信息
 * @author: ggmr
 * @create: 2018-12-25 21:56
 */
@Data
public class FindProgressProjectInfo {
    private List<ProjectTotalInfo> buildProject;
    private List<ProjectTotalInfo> middleProject;
    private List<ProjectTotalInfo> finalProject;
    private List<ProjectTotalInfo> finishProject;
}
