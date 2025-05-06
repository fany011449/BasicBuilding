package com.dell.demo1_Introduction;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Description {
    public static void main(String[] args) {
        // 目標：掌握BigDecimal解決小數運算結果失真問題
        double a = 0.1;
        double b = 0.2;
        // 失真了
        System.out.println(a+b); // 0.30000000000000004

        // ----------------------------------------------------------
        BigDecimal a1 = BigDecimal.valueOf(a);
        BigDecimal b1 = BigDecimal.valueOf(b);
        BigDecimal sum = a1.add(b1); // 相加

        // 與StringBuilder相同道理，都是屬於操作結束後，需要回原本的類型，因為其他API需求
        double result = sum.doubleValue();
        System.out.println(result);

        // ----------------------------------------------------------
        BigDecimal aa = BigDecimal.valueOf(0.1);
        BigDecimal bb = BigDecimal.valueOf(0.3);
        //此處拋異常，因為0.3333 ... 無止境下去
//        BigDecimal sum11 = aa.divide(bb);

        BigDecimal sum1 = aa.divide(bb, 2, RoundingMode.HALF_UP); // 小數點2位，四捨五入

        double result1 = sum1.doubleValue();
        System.out.println(result1);
    }
}
