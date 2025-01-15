package com.dell.demo;

// lombok可以實現類自動添加get、set、無參構造器、toString方法等
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 無參構造器
@AllArgsConstructor // 有參構造器、get/set

public class Card {
    private String cardId; // 車牌號碼
    private String Name;
    private String phone;
    private double money; // 金額

    // 預存金額
    public void deposit(double money) {
        this.money += money;
    }

    // 消費金額
    public void consume(double money) {
        this.money -= money;
    }
}
