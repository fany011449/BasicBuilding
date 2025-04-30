package com.dell.threadRunnable;

public class Introduction {
    // main 方法本身就是由一條main Thread在執行的
    public static void main(String[] args) {
        // 目標；認識Thread。
        // 創造線程
        // 方法二. 實現Runnable接口
        // 差異：比起方法一。子類線程可繼承其他類了。同時接口是可以多個實現的

        Runnable r = new MyRunnable();

        // 把線承任務交給一個線程對象來處理
        Thread t1 = new Thread(r);
        t1.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主線程輸出：" + i);
        }
    }

    // 定義一個子類繼承Thread類，成為一個線程類
    static class MyRunnable implements Runnable {

        @Override
        public void run(){
            for (int i = 0; i < 5; i++) {
                System.out.println("子線程輸出：" + i);
            }
        }
    }
}
