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

    public final static String[] APPLICAN_TYPE = {
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
            "项目申请审核通过",
            "项目申请审核失败",
            "待提交任务书阶段",
            "任务书审核阶段",
    };

    public final static String downloadAddress = "http://129.204.71.113:8888/api/file/download?fileAddress=";

    public final static String[] PROJECT_PROGRESS = {
            "",
            "立项",
            "中期报告阶段",
            "结题报告审核阶段",
            "项目结项",
            "结题报告审核失败"
    };

    public final static String[] USER_AUTHORIZATION = {
            "",
            "ROLE_USER",
            "ROLE_ADMIN",
            "ROLE_EXPERT",
            "ROLE_LEADER",
            "ROLE_SUPERADMIN"
    };

    public final static int MIDDLE_PROGRESS = 2;
    public final static int FINAL_PROGRESS = 3;
    public final static int FINISH_PROGRESS_FAILED = 5;
    public final static int FINISH_PROJECT = 4;

    public static final String TOKEN_HEAD = "Bearer ";
}
