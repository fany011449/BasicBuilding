package com.dell.ATM;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM {
    private ArrayList<Account> accounts = new ArrayList();
    private Scanner sc;
    private Account loginAcc;

    public ATM() {
        this.sc = new Scanner(System.in);
    }

    public void start() {
        while(true) {
            System.out.println("=======歡迎進入ATM======");
            System.out.println("1. 用戶登入：");
            System.out.println("2. 用戶開戶：");
            System.out.println("請選擇操作：");
            switch (this.sc.next()) {
                case "1":
                    this.login();
                    break;
                case "2":
                    this.createAccount();
                    break;
                default:
                    System.out.println("非法操作!");
            }
        }
    }

    private void login() {
        System.out.println("==系統登入==");
        if (this.accounts.isEmpty()) {
            System.out.println("目前系統內沒任何帳戶：");
        } else {
            System.out.println("請輸入您的卡號：");
            String cardId = this.sc.next();
            Account acc = this.getAccountByCardId(cardId);
            if (acc == null) {
                System.out.println("查無此帳戶，請重新確認!");
            } else {
                while(true) {
                    System.out.println("請您輸入密碼：");
                    String passWord = this.sc.next();
                    if (passWord.equals(acc.getPassWord())) {
                        this.loginAcc = acc;
                        PrintStream var10000 = System.out;
                        String var10001 = acc.getUserName();
                        var10000.println("恭喜您登入成功!" + var10001 + "您的卡號是：" + acc.getCardId());
                        this.userInterface();
                        return;
                    }

                    System.out.println("密碼錯誤!");
                }
            }
        }
    }

    private void userInterface() {
        while(true) {
            System.out.println("===========" + this.loginAcc.getUserName() + "您可以選擇如下功能的帳戶處理：===========");
            System.out.println("1. 查詢帳戶:");
            System.out.println("2. 存款:");
            System.out.println("3. 取款:");
            System.out.println("4. 轉帳:");
            System.out.println("5. 密碼修改:");
            System.out.println("6. 退出:");
            System.out.println("7. 註銷當前帳戶:");
            switch (this.sc.next()) {
                case "1":
                    this.showLoginAccount();
                    break;
                case "2":
                    this.depositMoney();
                    break;
                case "3":
                    this.drawMoney();
                    break;
                case "4":
                    this.transfermoney();
                case "5":
                    break;
                case "6":
                    System.out.println(this.loginAcc.getUserName() + "您退出系統成功!");
                    return;
                case "7":
                    if (!this.deleteAccount()) {
                        break;
                    }

                    return;
                default:
                    System.out.println("非法操作!");
            }
        }
    }

    private boolean deleteAccount() {
        while(true) {
            System.out.println("===========銷戶介面===========");
            System.out.println("請問是否確認要銷毀帳戶? (Y/N)");
            char operator = this.sc.next().charAt(0);
            char decide = Character.toUpperCase(operator);
            switch (decide) {
                case 'N':
                    System.out.println("好的，帳戶為您保留。");
                    return false;
                case 'Y':
                    if (this.loginAcc.getMoney() == (double)0.0F) {
                        this.accounts.remove(this.loginAcc);
                        System.out.println("成功刪除帳戶。");
                        return true;
                    }

                    System.out.println("帳戶內還剩餘:" + this.loginAcc.getMoney() + "請確認餘額為零後，重新操作");
                    return false;
                default:
                    System.out.println("非法操作，請重新輸入");
            }
        }
    }

    private void transfermoney() {
        if (this.accounts.size() < 2) {
            System.out.println("目前系統內帳戶不足，請先註冊帳戶");
        } else if (this.loginAcc.getMoney() < (double)0.0F) {
            System.out.println("此帳戶內餘額不足，請先儲值!");
        } else {
            while(true) {
                System.out.println("請您輸入對方卡號:");
                String cardId = this.sc.next();
                Account acc = this.getAccountByCardId(cardId);
                if (acc == null) {
                    System.out.println("系統內並無此卡號，請重新輸入");
                } else {
                    String var10000 = this.loginAcc.getUserName();
                    String name = "*" + var10000.substring(1);
                    System.out.println("請您輸入[" + name + "]的姓氏：");
                    String firstName = this.sc.next();
                    if (acc.getUserName().startsWith(firstName)) {
                        System.out.println("請輸入轉帳給對方的金額：");
                        double money = this.sc.nextDouble();
                        if (money <= this.loginAcc.getMoney()) {
                            this.loginAcc.setMoney(this.loginAcc.getMoney() - money);
                            acc.setMoney(acc.getMoney() + money);
                            System.out.println("轉帳成功，目前餘額剩至：" + this.loginAcc.getMoney());
                            return;
                        }

                        System.out.println("卡里餘額不足，請重新確認");
                    } else {
                        System.out.println("您輸入的姓氏錯誤，請重新操作");
                    }
                }
            }
        }
    }

    private void drawMoney() {
        System.out.println("==========取錢介面=============");
        if (this.loginAcc.getMoney() < (double)100.0F) {
            System.out.println("金額不足，無法操作");
        } else {
            while(true) {
                System.out.println("請輸入本次需要提取的金額：");
                double money = this.sc.nextDouble();
                if (this.loginAcc.getMoney() > money) {
                    if (this.loginAcc.getLimit() >= money) {
                        this.loginAcc.setMoney(this.loginAcc.getMoney() - money);
                        System.out.println("提取金額：" + money + "\n 目前餘額:" + this.loginAcc.getMoney());
                        return;
                    }

                    System.out.println("本次提取金額超過設置上限，請重新輸入!");
                } else {
                    System.out.println("餘額不足，請重新輸入!");
                }
            }
        }
    }

    private void depositMoney() {
        System.out.println("==========存款介面==========");
        System.out.println("請輸入存款金額：");
        double money = this.sc.nextDouble();
        this.loginAcc.setMoney(this.loginAcc.getMoney() + money);
        System.out.println("恭喜您存錢" + money + "成功，目前存款:" + this.loginAcc.getMoney());
    }

    private void showLoginAccount() {
        System.out.println("===============目前帳戶信息如下：================");
        PrintStream var10000 = System.out;
        String var10001 = this.loginAcc.getCardId();
        var10000.println("卡號：" + var10001);
        var10000 = System.out;
        var10001 = this.loginAcc.getUserName();
        var10000.println("戶主：" + var10001);
        var10000 = System.out;
        char var4 = this.loginAcc.getSex();
        var10000.println("性別：" + (var4 == 'F' ? "Female" : "male"));
        System.out.println("每次取現額度：" + this.loginAcc.getLimit());
        System.out.println("餘額：" + this.loginAcc.getMoney());
    }

    private void createAccount() {
        Account acc = new Account();
        System.out.println("請輸入您的帳戶名稱：");
        String name = this.sc.next();
        acc.setUserName(name);

        while(true) {
            System.out.println("請輸入您的性別： (F/M)");
            char sex = this.sc.next().charAt(0);
            char decide = Character.toUpperCase(sex);
            if (decide == 'F' || decide == 'M') {
                acc.setSex(decide);

                while(true) {
                    System.out.println("請輸入您的帳戶密碼：");
                    String password = this.sc.next();
                    System.out.println("請再次輸入您的帳戶密碼：");
                    String check = this.sc.next();
                    if (check.equals(password)) {
                        acc.setPassWord(check);
                        System.out.println("請輸入您每次取現金的額度：");
                        double var6 = this.sc.nextDouble();
                        acc.setLimit(var6);
                        acc.setCardId(this.createCardId());
                        this.accounts.add(acc);
                        PrintStream var10000 = System.out;
                        String var10001 = acc.getUserName();
                        var10000.println("恭喜您開戶成功，" + var10001 + "\n 這是您的開戶卡號：" + acc.getCardId());
                        return;
                    }

                    System.out.println("兩次密碼不相同，請再次確認!");
                }
            }

            System.out.println("輸入有誤!");
        }
    }

    private String createCardId() {
        Random r = new Random();

        String cardId;
        do {
            cardId = "";

            for(int i = 0; i < 8; ++i) {
                int data = r.nextInt(0, 9);
                cardId = cardId + data;
            }
        } while(this.getAccountByCardId(cardId) != null);

        return cardId;
    }

    private Account getAccountByCardId(String CardId) {
        for(int i = 0; i < this.accounts.size(); ++i) {
            Account acc = (Account)this.accounts.get(i);
            if (acc.getCardId().equals(CardId)) {
                return acc;
            }
        }

        return null;
    }
}
