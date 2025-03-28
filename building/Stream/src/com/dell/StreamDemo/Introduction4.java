package com.dell.StreamDemo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Introduction4 {
    public static void main(String[] args) {
        // 目標2：掌握Stream流的統計、收集操作(終結方法)
        // stream()通常收集、統整完數據後要放回數組Array中
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("張無忌", 22, 100.3));
        teachers.add(new Teacher("張", 221, 10011.3));
        teachers.add(new Teacher("張天明", 224, 1020.3));
        teachers.add(new Teacher("陳幼幼", 223, 103330.3));
        teachers.add(new Teacher("張茅", 222, 1004.3));
        teachers.add(new Teacher("陳漢和", 222, 101230.3));

        System.out.println("---------------------------------------");

        // 統計個數
        long count = teachers.stream().filter(t -> t.getSalary() > 1000).count();
        System.out.println(count);

        System.out.println("---------------------------------------");

        // 找最大、最小
        Optional<Teacher> max = teachers.stream().max((t1, t2) -> t1.getAge() - t2.getAge());
        Teacher maxAge = max.get();
        System.out.println(maxAge);

        Optional<Teacher> min = teachers.stream().min((t1, t2) -> Double.compare(t1.getSalary(), t2.getSalary()));
        Teacher minSalary = min.get();
        System.out.println(minSalary);


        System.out.println("---------------------------------------");
        List<String> list = new ArrayList<>();
        list.add("張無忌");
        list.add("張飛");
        list.add("張天明");
        list.add("張張");
        list.add("張張");
        list.add("張鬍鬚");
        list.add("陳幼幼");
        list.add("陳漢和");

        // 收集就會是終結方式(只能放stream最後面)

        // 收集到List集合
        List<String> list1 = list.stream().filter(s -> s.startsWith("張")).collect(Collectors.toList());
        System.out.println(list1);

        System.out.println("---------------------------------------");

        // 收集到Set集合
        Set<String> set = list.stream().filter(s -> s.startsWith("張")).collect(Collectors.toSet());
        System.out.println(set);

        System.out.println("---------------------------------------");

        // 收集到數組
        Object[] array = list.stream().filter(s -> s.startsWith("張")).toArray();
        System.out.println(Arrays.toString(array));

        System.out.println("---------------------------------------");

        // 收集到Map集合
        // key：老師
        // value：薪水
        Map<String, Double> collect = teachers.stream().collect(Collectors.toMap(Teacher::getName, Teacher::getSalary));
        System.out.println(collect);
    }
}
