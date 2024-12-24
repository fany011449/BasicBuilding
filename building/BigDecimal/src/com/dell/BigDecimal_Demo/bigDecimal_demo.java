package com.dell.BigDecimal_Demo;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class bigDecimal_demo {
    public bigDecimal_demo() {
    }

    public static void main(String[] args) {
        double a = 0.1;
        double b = 0.2;
        double c = a + b;
        System.out.println(c);
        new BigDecimal(Double.toString(a));
        new BigDecimal(Double.toString(b));
        BigDecimal a1 = BigDecimal.valueOf(a);
        BigDecimal b1 = BigDecimal.valueOf(b);
        a1.add(b1);
        a1.subtract(b1);
        a1.multiply(b1);
        a1.divide(b1);
        BigDecimal i = BigDecimal.valueOf(0.1);
        BigDecimal j = BigDecimal.valueOf(0.3);
        BigDecimal k = i.divide(j, 2, RoundingMode.HALF_UP);
        System.out.println(k);
    }
}
