package com.dell.RecursionDemo;

public class Demo {
    public static void main(String[] args) {
        // 目標：計算n的階乘

        System.out.println(f(5));
    }

    private static int f(int n) {
        if(n == 1){
            return 1;
        } else {
            return f(n - 1) * n;
        }
    }
}
