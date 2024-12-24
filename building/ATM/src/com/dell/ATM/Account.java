package com.dell.ATM;


public class Account {
    private String cardId;
    private String userName;
    private char sex;
    private String passWord;
    private double money;
    private double limit;

    public Account() {
    }

    public Account(String cardId, String userName, char sex, String passWord, double money, double limit) {
        this.cardId = cardId;
        this.userName = userName;
        this.sex = sex;
        this.passWord = passWord;
        this.money = money;
        this.limit = limit;
    }

    public String getCardId() {
        return this.cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUserName() {
        return this.userName + (this.sex == 'F' ? "小姐" : "先生");
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public char getSex() {
        return this.sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPassWord() {
        return this.passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public double getMoney() {
        return this.money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getLimit() {
        return this.limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}
