package com.management.tools;

import com.management.model.OV.Result;

import java.util.List;

import static com.management.model.OV.ResultCode.FAILED;
import static com.management.model.OV.ResultCode.SUCCESS;

/**
 * @program: management
 * @description: 后端返回给前端的统一设置数据工具
 * @author: ggmr
 * @create: 2018-07-29 13:06
 */
public class ResultTool {

    @SuppressWarnings("unchecked")
    public static Result success(List<Object> object){
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setData(object);
        return result;
    }

    @SuppressWarnings("unchecked")
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setData(object);
        return result;
    }

    public static Result success(){
        Result result = new Result();
        result.setCode(SUCCESS);
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setCode(FAILED);
        return result;
    }

    public static Result error(String message){
        Result result = new Result();
        result.setMessage(message);
        result.setCode(FAILED);
        return result;
    }
}
