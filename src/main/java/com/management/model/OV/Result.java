package com.management.model.OV;

import lombok.Data;

/**
 * @program: management
 * @description: 后端返回给前端的数据统一格式
 * @author: ggmr
 * @create: 2018-07-29 12:58
 */
@Data
public class Result<T> {
    /**
     * 标识码
     */
    private ResultCode code;
    /**
     * 错误信息
     */
    private String message;
    /**
     * 数据
     */
    private T data;
}
