package com.dell.threadPool_ExecutorService;

import java.util.concurrent.*;

public class IntroductionDemo1 {
    public static void main(String[] args) {
        // 目標：創建線程池對象來使用
        // 使用線程池的實現類ThreadPoolExecutor聲明7個參數來創建線程池對象
        ExecutorService pool = new ThreadPoolExecutor(3,5,
                10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        // 2. 使用線程池處理Runnable任務
        Runnable target = new MyRunnable();
        pool.execute(target); // 提交第一個任務 創建線程 自動啟動線程處理這個任務
        pool.execute(target); // 提交第二個任務 創建線程 自動啟動線程處理這個任務
        pool.execute(target); // 提交第三個任務 創建線程 自動啟動線程處理這個任務
        pool.execute(target); // 正在任務隊列中
        pool.execute(target); // 正在任務隊列中
        pool.execute(target); // 正在任務隊列中
        pool.execute(target); // 創建臨時線程！
        pool.execute(target); // 創建臨時線程！
        pool.execute(target); // 達到任務拒絕策略條件
        // 3. 關閉線程池 (一般都不會關閉的！)
        // 會等所有線程跑完後，再關閉
        // pool.shutdown();
    }
}
