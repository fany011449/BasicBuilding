package com.dell.LambdaDemo;

public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        Swimming swim = new Swimming() {
            public void swim() {
                System.out.println("游泳");
            }
        };
        swim.swim();
    }
}
