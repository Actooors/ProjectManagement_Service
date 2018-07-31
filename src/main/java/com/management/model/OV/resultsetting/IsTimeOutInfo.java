package com.management.model.OV.resultsetting;

import lombok.Data;

/**
 * @program: management
 * @description: 判断是否超过截止时间的格式化返回类
 * @author: ggmr
 * @create: 2018-07-31 10:17
 */
@Data
public class IsTimeOutInfo {

    private int isTimeOut;

    public IsTimeOutInfo(int isTimeOut) {this.isTimeOut = isTimeOut;}
}
