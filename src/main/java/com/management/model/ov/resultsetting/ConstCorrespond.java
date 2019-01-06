package com.management.model.ov.resultsetting;

/**
 * @program: management
 * @description: 项目的类别
 * @author: ggmr
 * @create: 2018-12-17 23:49
 */
public class ConstCorrespond {
    //这个第一个为空是有说法的，请勿删除
    public final static String[] PROJECT_TYPE = {
            "",
            "经济管理类",
            "人文哲学类",
            "计算科学类",
            "生物化学类"
    };

    //用户角色枚举值
    public final static String[] IDENTITY_TYPE = {
            "",
            "ROLE_USER",
            "ROLE_ADMIN",
            "ROLE_EXPERT",
            "ROLE_LEADER"
    };

    public final static String[] APPLICAN_TTYPE = {
            "",
            "本科生",
            "研究生",
            "博士生",
            "研究员",
            "教授"
    };

    public final static String[] reviewPhrase = {
            "",
            "业务员审核阶段",
            "评审专家审核阶段",
            "会评阶段",
            "领导审核阶段",
            "审核通过"

    };

    public final static String downloadAddress = "http://129.204.71.113:8888/api/file/download?fileAddress=";

    public final static String[] PROJECT_PROGRESS = {
            "",
            "立项",
            "中期报告审核阶段",
            "结题报告审核阶段",
            "项目完成"
    };

    public final static int MIDDLE_PROGRESS = 1;
    public final static int FINAL_PROGRESS = 1;
}
