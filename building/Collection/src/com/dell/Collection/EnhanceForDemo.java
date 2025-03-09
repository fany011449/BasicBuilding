package com.dell.Collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 目標：掌握遍歷 Collection的方法二： Enhance For Loop 增強for
 */
public class EnhanceForDemo {
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<>();
        names.add("abc");
        names.add("bca");
        names.add("aaa");
        names.add("dd");

        for (String name : names) {
            System.out.println(name);
        }
    }
}
