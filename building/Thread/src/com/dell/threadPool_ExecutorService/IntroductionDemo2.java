package com.dell.threadPool_ExecutorService;

import java.util.concurrent.*;

public class IntroductionDemo2 {
    public static void main(String[] args) {
        // 目標：創建線程池對象來使用
        // 使用線程池的實現類ThreadPoolExecutor聲明7個參數來創建線程池對象
        ExecutorService pool = new ThreadPoolExecutor(3,5,
                10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        // 2. 使用線程池處理Callable任務
        Future<String> f1 = pool.submit(new MyCallable(100));
        Future<String> f2 = pool.submit(new MyCallable(200));
        Future<String> f3 = pool.submit(new MyCallable(300));
        Future<String> f4 = pool.submit(new MyCallable(400));
        
        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
            System.out.println(f4.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
