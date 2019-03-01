package com.management.tools;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @program: management
 * @description: MD5加密工具类
 * @author: xw
 * @create: 2019-03-01 15:24
 */
public class MD5Tool {

    /**
     * 计算一个字符串的MD5信息
     *
     * @param str 字符串
     * @return MD5值
     */
    public static String getMD5(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

}
