package com.dell.demo;

public class SilverCard extends Card {
    public SilverCard(String cardId, String name, String phone, double money) {
        super(cardId, name, phone, money);
    }

    @Override
    public void consume(double money) {
        System.out.println("您目前消費： " + money);
        System.out.println("優惠後的價格： " + money * 0.9);
        if(getMoney() < money * 0.9) {
            System.out.println("餘額不足");
            return;
        }
        //更新金卡的帳戶餘額
        setMoney(getMoney() - money * 0.9);
    }
}
