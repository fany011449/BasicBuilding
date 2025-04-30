package com.dell.ThreadSecurity;

public class Simulation {
    public static void main(String[] args) {
        // 目標：模擬如何產生線程安全的問題
        Account acc = new Account(10000);

        new WithDrawThread("Yo-yo", acc).start();
        new WithDrawThread("Fish", acc).start();
    }
}
