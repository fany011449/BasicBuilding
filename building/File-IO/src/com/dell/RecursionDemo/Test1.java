package com.dell.RecursionDemo;

public class Test1 {
    public static void main(String[] args) {
        // 面試題：
    /*
        猴子第一天摘下若干桃子，當即吃了一半，不過癮，於是又多吃了一個
        第二天又吃了前天剩下桃子數量的一半，好不過癮，於是又多吃一個
        以後每天都是吃前天剩下桃子數量一半，加一個
        等到第十天的時候發現桃子剩下一顆了
        請問：猴子第一天摘了幾顆桃子
     */
        // f(n+1) = f(n) - f(n) / 2 - 1;
        // 2f(n+1) = 2f(n) - f(n) - 2;
        // f(n) = 2f(n+1) + 2;
        System.out.println(f(1));
    }

    private static int f(int n) {
        if (n == 10){
            return 1;
        }else {
            return f(n+1)*2 + 2;
        }
    }
}
