package com.dell.JDK8_Time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatter_Demo {
    public DateTimeFormatter_Demo() {
    }

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        String s = formatter.format(now);
        System.out.println(s);
        String s1 = now.format(formatter);
        System.out.println(s1);
        LocalDateTime ldt = LocalDateTime.parse(s, formatter);
        System.out.println(ldt);
    }
}
