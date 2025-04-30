package com.dell.threadRunnable;

public class SimplifyCoding {
    public static void main(String[] args) {

        /**
         * level.1 simplify
         */
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子線1程輸出：" + i);
                }
            }
        };

        Thread t1  = new Thread(r);
        t1.start();

        /**
         * level.2 simplify
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("子線2程輸出：" + i);
                }
            }
        }).start();

        /**
         * level.3 simplify
         */
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("子線3程輸出：" + i);
            }
        }).start();

        //---------------------------------------------------------------
        for (int i = 0; i < 5; i++) {
            System.out.println("主線程輸出：" + i);
        }
    }
}
