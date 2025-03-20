package com.dell.Set;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        // 目標：掌握HashSet集合去操作。
        // 需求：創建一個集合存儲學生對象的集合，存儲多個學生對象
        // 多個對象的成員變量相同時，要求只保留一個。
        Student s1 = new Student("aa", 17, "台北", "12345678");
        Student s2 = new Student("bb", 157, "台中", "123456789");
        Student s3 = new Student("aa", 17, "台北", "12345678");
        Student s4 = new Student("bb", 157, "台中", "123456789");

        Set<Student> set = new HashSet<>();

        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);

        System.out.println(set);
    }
}
