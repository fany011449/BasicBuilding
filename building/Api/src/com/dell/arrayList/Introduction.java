package com.dell.arrayList;

import java.util.ArrayList;

public class Introduction {
    public static void main(String[] args) {
        // 創建一個ArrayList， 代表一個集合容器
        ArrayList<String> list = new ArrayList<String>();
        // 添加數據
        list.add("apple");
        list.add("banana");
        list.add("orange");
        System.out.println(list);

        // 查看數據
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        // 遍歷數據，用傳統for語法
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        // 刪除數據
        list.remove(1);
        System.out.println(list);
        list.remove("orange");
        System.out.println(list);
        // 修改數據
        list.set(0, "grape");
        System.out.println(list);
    }
}
