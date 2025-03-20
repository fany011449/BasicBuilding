package com.dell.Set;

import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 目標：認識 Set家族集合的特性
 */
public class Introduction {
    public static void main(String[] args) {
        // 一行經典代碼
        // 無序、無重複元素、無索引
        Set<String> set = new HashSet<>();

        set.add("java");
        set.add("無序");
        set.add("無重複");
        set.add("無重複");
        set.add("無索引");
        set.add("無索引");
        set.add("無索引");

        System.out.println(set);

        System.out.println("======================================");
        // ＊有序、無重複元素、無索引
        Set<String> set1 = new LinkedHashSet<>();

        set1.add("java");
        set1.add("有序");
        set1.add("無重複");
        set1.add("無重複");
        set1.add("無索引");
        set1.add("無索引");
        set1.add("無索引");

        System.out.println(set1);

        System.out.println("======================================");
        // ＊排序（默認一定要大小升序排序）、無重複元素、無索引
        Set<Double> set2 = new TreeSet<>();

        set2.add(1.0);
        set2.add(2.3);
        set2.add(1.2);
        set2.add(55.0);
        set2.add(1.2);
        set2.add(1.23);
        set2.add(1.1);

        System.out.println(set2);


        System.out.println("======================================");

        // 查看每個對象的哈希值
        System.out.println(set.hashCode());
        System.out.println(set1.hashCode());
        System.out.println(set2.hashCode());
    }
}
