package com.dell.demo;

public class GoldCard extends Card{
    public GoldCard(String cardId, String name, String phone, double money) {
        super(cardId, name, phone, money);
    }

    @Override
    public void consume(double money) {
        System.out.println("您目前消費： " + money);
        System.out.println("優惠後的價格： " + money * 0.8);

        if(getMoney() < money * 0.8) {
            System.out.println("餘額不足");
            return;
        }
        //更新金卡的帳戶餘額
        setMoney( getMoney() - money * 0.8);

        // 判斷消費如果大於200，調用一個獨有功能：打印洗車票
        if (money * 0.8 >= 200) {
            printTicket();
        }else {
            System.out.println("金額不足200，並無洗車卷");
        }
    }

    private void printTicket() {
        System.out.println("獲取洗車卷一張");
    }
}
