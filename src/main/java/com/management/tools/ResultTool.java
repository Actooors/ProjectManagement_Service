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

    /**
     * @Description: 当请求成功并且后端返回给前端的是一个列表json时使用
     * @Param: [object]
     * @Return: com.management.model.OV.Result
     * @Author: ggmr
     * @Date: 18-7-29
     */
    @SuppressWarnings("unchecked")
    public static Result success(List<Object> object){
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setData(object);
        return result;
    }

    /**
     * @Description: 当请求成功并且返回给前端是一个对象时使用
     * @Param: [object]
     * @Return: com.management.model.OV.Result
     * @Author: ggmr
     * @Date: 18-7-29
     */
    @SuppressWarnings("unchecked")
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setData(object);
        return result;
    }

    /**
     * @Description: 当请求成功并且不需要返回任何数据时使用
     * @Param: []
     * @Return: com.management.model.OV.Result
     * @Author: ggmr
     * @Date: 18-7-29
     */
    public static Result success(){
        Result result = new Result();
        result.setCode(SUCCESS);
        return result;
    }

    /**
     * @Description: 当请求失败并不需要返回任何信息时使用
     * @Param: []
     * @Return: com.management.model.OV.Result
     * @Author: ggmr
     * @Date: 18-7-29
     */
    public static Result error(){
        Result result = new Result();
        result.setCode(FAILED);
        return result;
    }

    /**
     * @Description: 党请求失败并且返回失败信息时使用
     * @Param: [message]
     * @Return: com.management.model.OV.Result
     * @Author: ggmr
     * @Date: 18-7-29
     */
    public static Result error(String message){
        Result result = new Result();
        result.setMessage(message);
        result.setCode(FAILED);
        return result;
    }
}
