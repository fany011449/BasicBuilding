package com.dell.JDK8_Time;

import java.time.LocalDate;
import java.time.Period;

public class Period_Demo {
    public Period_Demo() {
    }

    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2029, 8, 10);
        LocalDate end = LocalDate.of(2029, 8, 15);
        Period period = Period.between(start, end);
        System.out.println(period.getDays());
        System.out.println(period.getMonths());
        System.out.println(period.getYears());
    }
}
