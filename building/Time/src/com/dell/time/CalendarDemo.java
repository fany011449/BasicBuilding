package com.dell.time;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
    public CalendarDemo() {
    }

    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        System.out.println(now);
        int year = now.get(1);
        System.out.println(year);
        Date d = now.getTime();
        System.out.println(d);
        long time = now.getTimeInMillis();
        System.out.println(time);
        now.set(2, 11);
        System.out.println(now);
        now.add(5, 5);
        System.out.println(now);
    }
}
