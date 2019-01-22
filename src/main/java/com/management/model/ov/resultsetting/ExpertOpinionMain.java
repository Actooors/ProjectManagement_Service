package com.management.model.ov.resultsetting;

import lombok.Data;

import java.util.List;

/**
 * @program: management
 * @description: 把弄好的专家的列表里面 再加上数量相关
 * @author: 0GGmr0
 * @create: 2019-01-14 15:33
 */
@Data
public class ExpertOpinionMain {
    private List<ExpertOpinionInfo> expertOpinionInfoList;
    private int totalNum;
    private int finishNum;
    private double percentage;
    private double average;
}
