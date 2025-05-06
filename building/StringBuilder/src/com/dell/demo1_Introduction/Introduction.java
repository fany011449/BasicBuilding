package com.dell.demo1_Introduction;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Introduction {
    public static void main(String[] args) {
        // 目標：掌握Java提供的"獲取時間"方式
        // JDK 8 之前的方案： Date 獲取此刻時間
        Date d = new Date();
        System.out.println(d);

        // 格式化：SimpleDateFormat 簡單日期格式化
        // EEE ：周幾
        // a ：上午下午
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EEE a");
        System.out.println(sdf.format(d));

        //------------------------------------------------------------------------------------------------------
        System.out.println("------------------------------------------------------------------------------------------------------");
        //------------------------------------------------------------------------------------------------------

        // JDK 8之後的方案
        // LocalDate
        // LocalTime
        // LocalDateTime
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getDayOfWeek());
        System.out.println(now.getHour());

        // 格式化：DateTimeFormatter
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss EEE a");
        System.out.println(dtf.format(now));

    }
}
