package com.dell.Set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        // 目標：搞清楚TreeSet集合中對於自定義對象的排序

        // 2. public TreeSet集合自帶比較器Comparator對象，制定比較規則
//        Set<Teacher> teachers = new TreeSet<>(new Comparator<Teacher>() {
//            @Override
//            public int compare(Teacher o1, Teacher o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });

        // 使用Lambda簡化
        Set<Teacher> teachers = new TreeSet<>((o1, o2) -> o2.getAge() - o1.getAge());

        teachers.add(new Teacher("aa", 43, 211.2));
        teachers.add(new Teacher("aa", 43, 211.2));
        teachers.add(new Teacher("ca", 431, 2311.2));
        teachers.add(new Teacher("aab", 4113, 21221.2));

        System.out.println(teachers);

        /* 此處報錯!
           因為TreeSet默認不能給自定義對象排序，因為不知道大小規則
           兩條路能選：
           1. 對象類實現一個Comparable比較接口，重寫compareTo方法，制定大小比較規則
           2. public TreeSet集合自帶比較器Comparator對象，制定比較規則
         */


    }
}
