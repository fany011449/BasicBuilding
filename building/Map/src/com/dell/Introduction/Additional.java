package com.dell.Introduction;

import java.util.Map;
import java.util.TreeMap;

public class Additional {
    public static void main(String[] args) {
        // 目標：TreeMap集合(原理和用法跟TreeSet相同)
        //
        Map<Teacher, String> map = new TreeMap<>((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));

        map.put(new Teacher("aa", 43, 211.2), "三年級");
        map.put(new Teacher("aa", 43, 211.2), "一年級");
        map.put(new Teacher("ca", 431, 2311.2), "二年級");
        map.put(new Teacher("aab", 4113, 21221.2), "畢業班");

        System.out.println(map);
    }
}
