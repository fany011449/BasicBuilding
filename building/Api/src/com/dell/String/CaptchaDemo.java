package com.dell.String;

public class CaptchaDemo {
    public static void main(String[] args) {
        System.out.println(generateCaptcha(4));
    }

    // 幫我生成指定位數的隨機驗證碼，每位可能是大小寫字母或者數字，且用String儲存所有要用到的字元
    public static String generateCaptcha(int n) {
        // 建立一個空字串，用來儲存驗證碼
        String captcha = "";
        // 建立一個字串，用來儲存所有要用到的字元
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < n; i++) {
            // 隨機選取一個字元
            int index = (int) (Math.random() * letters.length());
            // 將選取的字元加入到驗證碼字串中
            captcha += letters.charAt(index);
        }
        return captcha;
    }
}
