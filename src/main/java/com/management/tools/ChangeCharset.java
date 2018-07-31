package com.management.tools;

import java.io.UnsupportedEncodingException;

/**
 * @program: management
 * @description: 改变字符串编码
 * @author: ggmr
 * @create: 2018-07-31 14:36
 */
public class ChangeCharset {
    private static final String UTF_8 = "UTF-8";

    private static String changeCharset(String str, String newCharset) throws UnsupportedEncodingException {
        if(str != null) {
            //用默认字符编码解码字符串。与系统相关，中文windows默认为GB2312
            byte[] bs = str.getBytes();
            //用新的字符编码生成字符串
            return new String(bs, newCharset);
        }
        return null;
    }

    public static String toUTF_8(String str) throws UnsupportedEncodingException {
        return changeCharset(str, UTF_8);
    }
}
