package com.dell.lock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private double money;
    // 一個帳戶一把鎖
    // 使用final修飾，可以防止他人竄改
    private final Lock lk = new ReentrantLock();


    public void withDraw(double money) {
        // 拿到當前誰來取錢
        String name = Thread.currentThread().getName();
        // 上鎖
        lk.lock();
        // 判斷餘額
        try {
            if (this.money >= money){
                System.out.println(name + "取錢成功，餘額剩下：" + (this.money-money));
                // 更新餘額
                this.money -= money;
                System.out.println(name + "取錢成功，餘額剩下：" + (this.money));

            } else {
                System.out.println("餘額不足");
            }
        } finally {
            // 即便出了異常也能解鎖
            // 解鎖通常都搭配finally作使用
            // 解鎖
            lk.unlock();
        }
    }
}
