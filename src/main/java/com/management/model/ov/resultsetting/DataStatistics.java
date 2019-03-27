package com.management.model.ov.resultsetting;

import lombok.Data;

import java.util.List;

/**
 * @program: management
 * @description: 领导数据统计
 * @author: xw
 * @create: 2019-03-27 00:49
 */
@Data
public class DataStatistics {
    private List<projectStatistic> projectStatistic;
    private List<projectTypeStatistic> projectTypeList;
}

