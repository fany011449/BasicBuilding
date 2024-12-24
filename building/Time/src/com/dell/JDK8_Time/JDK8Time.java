package com.dell.JDK8_Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class JDK8Time {
    public JDK8Time() {
    }

    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        int year = ld.getYear();
        int month = ld.getMonthValue();
        int day = ld.getDayOfMonth();
        int dayOfYear = ld.getDayOfYear();
        int dayOfWeek = ld.getDayOfWeek().getValue();
        System.out.println(dayOfWeek);
        LocalDate ld1 = ld.withYear(2009);
        System.out.println(ld1);
        System.out.println(ld);
        LocalDate ld2 = ld.plusYears(2L);
        LocalDate ld3 = ld.minusYears(2L);
        LocalDate ld4 = LocalDate.of(2099, 12, 12);
        System.out.println(ld4.equals(ld3));
        System.out.println(ld.isAfter(ld3));
        System.out.println(ld.isAfter(ld3));
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        LocalDate date = ldt.toLocalDate();
        System.out.println(date);
        LocalTime time = ldt.toLocalTime();
        System.out.println(time);
        LocalDateTime mix = LocalDateTime.of(date, time);
        System.out.println(mix);
    }
}
