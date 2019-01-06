package com.management.tools;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @program: management
 * @description: 密码加密工具
 * @author: xw
 * @create: 2019-01-05 14:30
 */
public class SecurityTool {
    public static String encodeByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return Base64.getEncoder().encodeToString(md5.digest(str.getBytes("utf-8")));
    }
}
