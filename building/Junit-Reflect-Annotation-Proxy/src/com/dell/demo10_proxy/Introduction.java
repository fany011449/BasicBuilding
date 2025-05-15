package com.dell.demo10_proxy;

public class Introduction {
    public static void main(String[] args) {
        // 目標：創建代理對象
        // 1. 準備一個明星對象：設計明星類
        Star star = new Star("Dell");

        // 2. 為明星創建一個專屬的代理對象
        // 寫一個工具類來包裝代理對象
        StarService proxy = ProxyUtil.createProxy(star);
        proxy.sing("dance in the moon");
        System.out.println(proxy.dance());
    }
}
