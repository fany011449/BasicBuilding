package com.dell.StreamDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Introduction1 {
    public static void main(String[] args) {
        // 目標：認識Stream流
        // 需求：把集合中所有以"張"開頭且三個元素，儲存在一個新集合裡
        List<String> list = new ArrayList<>();
        list.add("張無忌");
        list.add("張飛");
        list.add("張天明");
        list.add("張張");
        list.add("張鬍鬚");
        list.add("陳幼幼");
        list.add("陳漢和");

        // 1. 傳統方法：找出姓張的，名字為3個字
        List<String> newList = new ArrayList<>();
        for (String name : list) {
            if(name.startsWith("張") && name.length() == 3) {
                newList.add(name);
            }
        }

        System.out.println(newList);

        // 2. 使用Stream流解決
        List<String> newList2 = list.stream()
                .filter(s -> s.startsWith("張"))
                .filter(s -> s.length() == 3)
                .collect(Collectors.toList());

        System.out.println(newList2);
    }
}
