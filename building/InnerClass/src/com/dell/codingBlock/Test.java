package com.dell.codingBlock;

import java.util.Arrays;

public class Test {
    // 目標：靜態代碼塊
    // 類自動加載，由於類只會加載一次，所以靜態代碼塊也只會執行一次
    public static String name;
    public static String[] cards= new String[54];

    static {
        System.out.println("========靜態代碼塊執行了=====");
        name = "Dell";
        cards[0] = "a";
        cards[1] = "a";
        cards[2] = "a";
    }

    public static void main(String[] args) {
        System.out.println("========main方法執行了=====");
        System.out.println(Arrays.toString(cards));
    }
}
