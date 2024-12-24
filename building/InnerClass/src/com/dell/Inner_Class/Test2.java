package com.dell.Inner_Class;

public class Test2 {
    public Test2() {
    }

    public static void main(String[] args) {
        Swimming s1 = new Swimming() {
            public void swim() {
                System.out.println("狗狗讚");
            }
        };
        go(s1);
        go(new Swimming() {
            public void swim() {
                System.out.println("貓貓讚");
            }
        });
    }

    public static void go(Swimming s) {
        System.out.println("比賽開始");
        s.swim();
    }
}
