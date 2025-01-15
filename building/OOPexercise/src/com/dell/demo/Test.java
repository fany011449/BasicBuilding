package com.dell.demo;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // 目標：加油站支付
        // 1. 創建卡片類、以便創建金卡、銀卡，封裝車主的數據
        // 2. 定義一個父類：Card, 定義金卡、銀卡的共同屬性
        // 3. 定義一個金卡、銀卡類，繼承Card
        GoldCard goldCard = new GoldCard("3958-SE", "Dell", "0908999999", 5000.00);
        SilverCard silverCard = new SilverCard("AVY-8259", "Dell", "0908999999", 51111.00);
        // 4. 創建金卡、銀卡對象，給一個獨立業務：存款、消費

        // 支付機器：用一個方式來刷卡
        pay(goldCard);
    }

    public static void pay(Card c){
        System.out.println("請刷卡，請輸入您當簽消費的金額：");
        Scanner sc = new Scanner(System.in);
        double money = sc.nextDouble();
        c.consume(money);
    }
}
