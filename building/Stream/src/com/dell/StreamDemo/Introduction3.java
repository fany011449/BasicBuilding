package com.dell.StreamDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Introduction3 {
    public static void main(String[] args) {
        // 目標1：掌握Stream提供的中間方法，對流上的data進行處理(返回新流：支持鏈式編程)
        List<String> list = new ArrayList<>();
        list.add("張無忌");
        list.add("張飛");
        list.add("張天明");
        list.add("張張");
        list.add("張鬍鬚");
        list.add("陳幼幼");
        list.add("陳漢和");

        // 1. 過濾方法：
        list.stream().filter(s -> s.startsWith("張") && s.length() == 3).forEach(s -> System.out.println(s));


        System.out.println("---------------------------------------");

        // 2. 排序方法
        List<Double> scores = new ArrayList<>();
        scores.add(199.10);
        scores.add(19.10);
        scores.add(419.10);
        scores.add(39.10);
        scores.add(39.10);

        // 預設方法：升序
        scores.stream().sorted().forEach(s -> System.out.println(s));
        System.out.println("---------------------------------------");
        // 降序
        scores.stream().sorted((s1, s2) -> Double.compare(s2, s1)).forEach(s -> System.out.println(s));
        System.out.println("---------------------------------------");
        // 只要前兩個
        scores.stream().sorted((s1, s2) -> Double.compare(s2, s1)).limit(2).forEach(s -> System.out.println(s));
        System.out.println("---------------------------------------");
        // 排除前兩個
        scores.stream().sorted((s1, s2) -> Double.compare(s2, s1)).skip(2).forEach(s -> System.out.println(s));
        System.out.println("---------------------------------------");
        // 去重複
        // 如果希望自定義對象能夠去重複，必須重寫對象的hashCode()和equals()方法
        scores.stream().sorted((s1, s2) -> Double.compare(s2, s1)).distinct().forEach(s -> System.out.println(s));
        System.out.println("---------------------------------------");
        // 映射/加工：把流上原本的數據拿出來變成新數據在放上流上
        scores.stream().map(s -> "加十分後：" + (s + 10)).forEach(s -> System.out.println(s));
        System.out.println("---------------------------------------");

        // 合併流，會是匯合成一條同類型的Stream
        Stream<String> s1 = Stream.of("張三豐", "張力搭", "張張張", "陳幼幼", "陳漢和", "");
        Stream<Integer> s2 = Stream.of(11, 22, 33, 44);
        Stream<Object> ss = Stream.concat(s1, s2);


    }
}
