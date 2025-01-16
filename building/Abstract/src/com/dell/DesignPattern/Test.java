package com.dell.DesignPattern;

public class Test {
    public static void main(String[] args) {
        // 情況：上下文相同，但內文不同，此時可用抽象類中的抽象方法作為設計模板Design Pattern
        People p = new Student();
        p.write();
    }
}
