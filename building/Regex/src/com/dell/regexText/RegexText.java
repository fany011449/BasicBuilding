package com.dell.regexText;


public class RegexText {
    public RegexText() {
    }

    public static void main(String[] args) {
        System.out.println(checkAccount("312354155"));
        System.out.println(regexCheckAccount("0315414"));
        System.out.println(regexCheckAccount("aa216542"));
        System.out.println(regexCheckAccount("312354155"));
    }

    public static boolean checkAccount(String account) {
        if (account != null && !account.startsWith("0") && account.length() >= 6 && account.length() <= 20) {
            for(int i = 0; i < account.length(); ++i) {
                char current = account.charAt(i);
                if (current < '0' || current > '9') {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public static boolean regexCheckAccount(String account) {
        return account != null && account.matches("[1-9]\\d{5,19}");
    }
}
