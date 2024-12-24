package com.dell.demo;


public class A {
    private static A a = new A();

    private A() {
    }

    public static A getObject() {
        return a;
    }
}
