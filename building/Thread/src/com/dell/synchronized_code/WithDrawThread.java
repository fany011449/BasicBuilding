package com.dell.synchronized_code;

public class WithDrawThread extends Thread{
    private Account acc;
    // 接收有參構造器
    public WithDrawThread(String name, Account acc){
        // 因為是要調用Thread類的方法
        super(name);
        this.acc = acc;
    }

    @Override
    public void run() {
        acc.withDraw(10000);
    }
}
