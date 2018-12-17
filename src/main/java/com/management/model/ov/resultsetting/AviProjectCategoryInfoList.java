package com.management.model.ov.resultsetting;

import lombok.Data;

import java.util.List;

/**
 * @program: management
 * @description: 可申报项目的简单信息加type的列表
 * @author: ggmr
 * @create: 2018-12-17 23:21
 */
@Data
public class AviProjectCategoryInfoList {
    private String type;
    private List<AviProjectCategoryInfo> projectList;
}
