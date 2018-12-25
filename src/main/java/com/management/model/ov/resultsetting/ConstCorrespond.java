package com.management.model.ov.resultsetting;

/**
 * @program: management
 * @description: 项目的类别
 * @author: ggmr
 * @create: 2018-12-17 23:49
 */
public class ConstCorrespond {
    //这个第一个为空是有说法的，请勿删除
    public final static String[] projectType = {
            "",
            "经济管理类",
            "人文哲学类",
            "计算科学类",
            "生物化学类"
    };
    public final static String[] reviewPhrase = {
            "",
            "业务员审核阶段",
            "评审专家审核阶段",
            "会评阶段",
            "领导审核阶段",
            "审核通过"

    };
    public final static String downloadAddres = "http://129.204.71.113:8888/api/file/download?fileAddress=";

}
