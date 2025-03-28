package com.dell.StreamDemo;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class Introduction2 {
    public static void main(String[] args) {
        // 目標：獲取Stream流

        // 1. 所有單鏈(Collection家族)調Stream流，都是調Stream()此方法
        // List、Set
        Collection<String> list = new ArrayList<>();
        Stream<String> s1 = list.stream();

        // 2. Map集合
        Map<String, Integer> map = new HashMap<>();
        // 只取Key的Stream流
        Stream<String> s2 = map.keySet().stream();
        // 只取Value的Stream流
        Stream<Integer> s3 = map.values().stream();
        // 取entry(key, value)的Stream流
        Stream<Map.Entry<String, Integer>> s4 = map.entrySet().stream();

        // 3. 數組
        String[] name = {"張三豐", "張力搭", "張張張", "陳幼幼", "陳漢和"};
        Stream<String> s5 = Arrays.stream(name);
        System.out.println(s5.count()); // 5個

        // 可變參數(T... values)
        // public static<T> Stream<T> of(T... values)
        // 參數可隨意放
        Stream<String> s6 = Stream.of(name);
        Stream<String> s7 = Stream.of();
        Stream<String> s8 = Stream.of("張三豐", "張力搭", "張張張", "陳幼幼", "陳漢和", "");

    }
}
