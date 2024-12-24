package com.dell.enum_demo;

public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        A a1 = A.X;
        System.out.println(a1);
        A a2 = A.Y;
        A[] all = A.values();
        A a3 = A.valueOf("Z");
        System.out.println(a3.getName());
        System.out.println(a3.ordinal());
        B y = B.Y;
        System.out.println(y);
    }
}
