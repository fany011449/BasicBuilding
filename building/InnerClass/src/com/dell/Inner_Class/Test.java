package com.dell.Inner_Class;

public class Test {
    public Test() {
    }

    public static void main(String[] args) {
//        Outer.Inner in = new Outer.Inner(new Outer());
//        in.test();
        Animal a = new Animal() {
            public void cry() {
                System.out.println("喵喵喵");
            }
        };
        a.cry();
    }
}
