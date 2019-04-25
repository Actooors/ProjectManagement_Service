package com.management.tools;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

public class TimeToolTest {

    @Test
    public void stringToTime() {
        MD5Tool md5Tool = new MD5Tool();
        System.out.print(md5Tool.getMD5("123456"));
    }

    @Test
    public void timetoString() {
    }
}