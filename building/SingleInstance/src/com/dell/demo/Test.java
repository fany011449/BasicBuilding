package com.dell.demo;

/*
    單例設計模型： 確認某個類只能創建一個對象
        1. 把類的構造器私有化
        2. 定義一個類變量記住一個類的對象
        3. 定義一個類方法，返回對象
 */
public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        A a1 = A.getObject();
        A a2 = A.getObject();
        System.out.println(a1);
        System.out.println(a2);
        Runtime.getRuntime();
        B b1 = B.getObject();
        B b2 = B.getObject();
        System.out.println(b1 == b2);
    }
}