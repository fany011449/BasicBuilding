package com.dell.synchronized_method;

public class Simulation {
    public static void main(String[] args) {
        // 目標：處理線程安全
        // 方法二：同步方法
        Account acc = new Account(10000);

        new WithDrawThread("Yo-yo", acc).start();
        new WithDrawThread("Fish", acc).start();

        Account acc1 = new Account(10000);

        new WithDrawThread("yo", acc1).start();
        new WithDrawThread("Fi", acc1).start();
    }
}
