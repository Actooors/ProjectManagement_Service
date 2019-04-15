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
        JwtUtil jwtUtil = new JwtUtil();
        System.out.print(jwtUtil.getIdentity("1|2|3"));
    }

    @Test
    public void timetoString() {
    }
}