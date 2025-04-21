package com.dell.RecursionDemo;

public class Demo1 {
    public static void main(String[] args) {
        // 目標：1 ~ｎ的和
        // f(n) = 1+2+3+4+5+...+(n-1)+n
        // f(n) = f(n-1) + n
        System.out.println(sum(4));
    }

    private static int sum(int n) {
        if(n == 1){
            return 1;
        } else {
            return sum(n-1) + n;
        }
    }
}
