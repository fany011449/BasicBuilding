package com.dell.threadPool_ExecutorService;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{
    private int n;
    public MyCallable(int n){
        // 指定要什麼數字
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return Thread.currentThread().getName() + "線程 1 ~ " + n + "的和是:" + sum ;
    }
}

