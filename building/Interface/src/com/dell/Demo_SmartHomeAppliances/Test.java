package com.dell.Demo_SmartHomeAppliances;

import java.util.Scanner;

/*
    角色：設備
    具備功能：on/off
    單例對象：控制調用設備的開和關
    1. 定義設備類：創建對象代表家裡的設備
    2. 準備這些設備對象，放到陣列中，代表整個家庭的設備
    3. 為每個設備制定一個on/off的功能，定義一個接口，讓HomeAppliances實現
    4. 創建智能家電控制系統對象，控制設備開關

 */
public class Test {
    public static void main(String[] args) {
        // 家電設備
        HomeAppliances[] homeAppliances = new HomeAppliances[4];
        homeAppliances[0] = new TV("電視", true);
        homeAppliances[1] = new WashMachine("洗衣機", true);
        homeAppliances[2] = new Lamp("吊燈", true);
        homeAppliances[3] = new AirConditioner("空調", true);

        SmartHomeControl smartHomeControl = SmartHomeControl.getInstance();
//        smartHomeControl.control(homeAppliances[0]);

        // 展示全部設備當前情況
        // 讓用戶選擇哪一個操作
        // 打印全部設備的開關現狀
        while (true) {
            smartHomeControl.printAllStatus(homeAppliances);
            System.out.println("請選擇要控制的設備：");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.next();
            switch (command) {
                case "1":
                    smartHomeControl.control(homeAppliances[0]);
                    break;
                    case "2":
                    smartHomeControl.control(homeAppliances[1]);
                    break;
                    case "3":
                    smartHomeControl.control(homeAppliances[2]);
                    break;
                    case "4":
                    smartHomeControl.control(homeAppliances[3]);
                    break;
                case "exit":
                    System.out.println("退出APP");
                    return;
                default:
                    System.out.println("輸出錯誤");
                    break;
            }
        }
    }
}
