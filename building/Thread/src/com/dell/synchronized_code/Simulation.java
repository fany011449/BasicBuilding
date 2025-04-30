package com.dell.synchronized_code;

public class Simulation {
    public static void main(String[] args) {
        // 目標：處理線程安全
        // 方法一：同步代碼塊
        Account acc = new Account(10000);

        new WithDrawThread("Yo-yo", acc).start();
        new WithDrawThread("Fish", acc).start();
    }
}
