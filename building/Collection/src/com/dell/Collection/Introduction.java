package com.dell.Collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 目的：搞清楚Collection集合的整體特性
 */
public class Introduction {
    public static void main(String[] args) {
        // 1. List家族的集合：有序、可重複、有索引
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("java");
        list.add("C");
        list.add("C++");
        System.out.println(list);
        String str = list.get(0);
        System.out.println();

        // 2. Set家族的集合：無序、無重複、無索引
        Set<String> set = new HashSet<>();
        set.add("java");
        set.add("java");
        set.add("C");
        set.add("C++");
        System.out.println(set);
    }
}
