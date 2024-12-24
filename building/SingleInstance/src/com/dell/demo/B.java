package com.dell.demo;

public class B {
    private static B b;

    private B() {
    }

    public static B getObject() {
        return b == null ? (b = new B()) : b;
    }
}
