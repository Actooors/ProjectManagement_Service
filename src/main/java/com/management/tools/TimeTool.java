package com.management.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: management
 * @description: 时间格式与字符串转化工具
 * @author: xw
 * @create: 2018-07-31 18:53
 */
public class TimeTool {
    public Date StringToTime(String time){
        /*将字符串时间格式转化为Date时间类型*/
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try{
            Date Time = new Date();
            Time = dateFormat.parse(time);
            return Time;
        }catch (ParseException e){
            e.printStackTrace();
            return null;
        }
    }

    public String TimetoString(Date date){
        String time = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(date);
        return time;
    }

}
