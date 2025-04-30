package com.dell.threadExtends;

public class Introduction {
    // main 方法本身就是由一條main Thread在執行的
    public static void main(String[] args) {
        // 目標；認識Thread。
        // 創造線程
        // 方法一. 繼承Thread類來實現

        Thread t1 = new MyThread();
        t1.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主線程輸出：" + i);
        }
    }

    // 定義一個子類繼承Thread類，成為一個線程類
    static class MyThread extends Thread {

        @Override
        public void run(){
            for (int i = 0; i < 5; i++) {
                System.out.println("子線程輸出：" + i);
            }
        }
    }
}
