package com.dell.Inner_Class;

public class Outer {
    private int age = 99;
    public static String a;

    public Outer() {
    }

    public class Inner {
        private String name;
        public static String schoolName;
        private int age = 88;

        public Inner() {
        }

        public Inner(Outer outer) {

        }

        public void test() {
            System.out.println(this.age);
            System.out.println(Outer.a);
            int age = 66;
            System.out.println(age);
            System.out.println(this.age);
            System.out.println(Outer.this.age);
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}