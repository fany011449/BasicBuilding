package com.dell.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public Test() {
    }

    public static void main(String[] args) throws ParseException {
        String start = "2023年11月11日 0:0:0";
        String end = "2023年11月11日 0:0:0";
        String person1 = "2023年11月11日 0:0:0";
        String person2 = "2023年11月11日 0:0:0";
        SimpleDateFormat date = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date startDate = date.parse(start);
        Date endDate = date.parse(end);
        Date person1Date = date.parse(person1);
        Date person2Date = date.parse(person2);
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        long person1Time = person1Date.getTime();
        long person2Time = person2Date.getTime();
        if (startTime >= person1Time) {
            System.out.println("true");
        }

    }
}
