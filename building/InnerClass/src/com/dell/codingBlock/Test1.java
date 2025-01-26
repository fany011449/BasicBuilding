package com.dell.codingBlock;

public class Test1 {
    /*
        目標:實例代碼塊
        每次創建對象時，執行實例代碼塊，並在構造器前執行
     */
    {
        System.out.println("=============實例代碼塊執行了==============");
    }
    public static void main(String[] args) {
        System.out.println("=============main執行了==============");
        new  Test1();
    }
}
