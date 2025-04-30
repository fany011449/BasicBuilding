package com.dell.threadCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Introduction {
    // main 方法本身就是由一條main Thread在執行的
    public static void main(String[] args) {
        // 目標；認識Thread。
        // 創造線程
        // 由於前兩者run方法都無返回值，所以延生出第三種方式
        // 方法三. 實現Callable接口，FutureTask類來實現
        // 優點：拓展性強，且可接收返回值
        Callable<String> c1 = new MyCallable(50);
        FutureTask<String> f1 = new FutureTask<>(c1);
        Thread t1 = new Thread(f1);
        t1.start();

        Callable<String> c2 = new MyCallable(100);
        FutureTask<String> f2 = new FutureTask<>(c2);
        Thread t2 = new Thread(f2);
        t2.start();

        // 如果主線程發現第一個線程尚未執行完畢，OS會讓出CPU，等它完成後，才繼續往下執行
        try {
            System.out.println(f1.get());
        } catch (Exception e) {
           e.printStackTrace();
        }

        // 如果主線程發現第二個線程尚未執行完畢，OS會讓出CPU，等它完成後，才繼續往下執行
        try {
            System.out.println(f2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    static class MyCallable implements Callable<String>{
        private static int n;
        public MyCallable(int n){
            // 指定要什麼數字
            this.n = n;
        }

        @Override
        public String call() throws Exception {
            int sum = 0;
            for (int i = 1; i < n; i++) {
                sum += i;
            }
            return "子線程 1 ~ " + n + "的和是:" + sum ;
        }
    }
}
