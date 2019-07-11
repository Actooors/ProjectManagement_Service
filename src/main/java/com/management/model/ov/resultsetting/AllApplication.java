package com.management.model.ov.resultsetting;

import lombok.Data;

import java.util.List;

/**
 * @program: management
 * @description: 领导查看所有项目申请
 * @author: xw
 * @create: 2019-07-10 13:34
 */
@Data
public class AllApplication {
    String projectCategoryId;
    String projectCategoryName;
    String projectCategoryDescription;
    String principalName;
    String maxMoney;
    List<ApplicationInfo> applicationList;
}
