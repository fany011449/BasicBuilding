package com.dell.Demo_SmartHomeAppliances;

public class SmartHomeControl {
    /*
        單例類
        1. 私有無參構造器
        2. 定義一個靜態常量記住一個唯一的對象
        3. 將這個對象返回出去
     */
    private static final SmartHomeControl instance = new SmartHomeControl();
    private SmartHomeControl() {}
    public static SmartHomeControl getInstance() {
        return instance;
    }

    // 支持了多態
    public void control(HomeAppliances homeAppliance) {
        System.out.println(homeAppliance.getName() + "目前狀態:" + (homeAppliance.isStatus() ? "開著" : "關閉"));
        System.out.println("開始您的操作");
        homeAppliance.press();
        System.out.println(homeAppliance.getName() + "目前狀態:" + (homeAppliance.isStatus() ? "開著" : "關閉"));
    }

    public void printAllStatus(HomeAppliances[] homeAppliances) {
        for (int i = 0; i < homeAppliances.length; i++) {
            System.out.println(homeAppliances[i].getName() + "目前狀態是:" + (homeAppliances[i].isStatus() ? "打開" : "關閉"));
        }
    }
}
