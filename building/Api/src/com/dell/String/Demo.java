package com.dell.String;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        // 簡易版的登入系統
        String username = "admin";

        System.out.println("請輸入帳號:");
        Scanner scanner = new Scanner(System.in);
        String inputUsername = scanner.nextLine();

        // 使用 == 來比較兩個字串是否相同，是比較兩個物件的位址是否相同，而不是兩個字串是否相同
        // equals() 是 String 類別的方法，用來比較兩個字串是否相同
        if (inputUsername.equals(username)) {
            System.out.println("登入成功！");
        } else {
            System.out.println("登入失敗！");
        }
    }
}
