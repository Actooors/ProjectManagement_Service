package com.management.tools;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TimeToolTest {

    @Test
    public void stringToTime() {
        TimeTool timeTool = new TimeTool();
        String time = "2018-05-06 20:00:00";
        System.out.print(TimeTool.stringToTime(time));
    }

    @Test
    public void timetoString() {
    }
}