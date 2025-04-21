package com.dell.RecursionDemo;

public class Introduction {
    public static void main(String[] args) {
        // 目標：認識遞迴
        printA();
    }

    private static void printA() {
        System.out.println("A");
        printA();
        // 遞迴出現死循環，導致出現Stack overflow的現象。
        // 因為方法是在Steak(棧)跑的，所以死循環後Steak內存溢出導致Exception
    }
}
