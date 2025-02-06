package com.dell.lambda;

/*
    lambda表達式只能簡化函數式接口的匿名內部類
 */
public class Test {
    public static void main(String[] args) {
        swim s = new swim() {
            public void swim() {
                System.out.println("I can swim");
            }
        };
        s.swim();

        swim s2 = () -> System.out.println("I can swim too");
        s2.swim();
    }
}

@FunctionalInterface
// 函數式接口：只有一個抽象方法的接口
interface swim{
    abstract void swim();
}