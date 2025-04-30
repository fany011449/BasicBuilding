package com.dell.ThreadSecurity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private double money;

    public void withDraw(double money) {
        // 拿到當前誰來取錢
        String name = Thread.currentThread().getName();

        // 判斷餘額
        if (this.money >= money){
            System.out.println(name + "取錢成功，餘額剩下：" + (this.money-money));
            // 更新餘額
            this.money -= money;
            System.out.println(name + "取錢成功，餘額剩下：" + (this.money));

        } else {
            System.out.println("餘額不足");
        }
    }
}
