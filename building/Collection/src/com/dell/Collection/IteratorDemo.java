package com.dell.Collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 目標： 掌握 Collection 遍歷的方式一：迭代器
 */
public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("abc");
        names.add("bca");
        names.add("aaa");
        names.add("dd");
        System.out.println(names);

        // 1. 得到這個集合的Iterator對象
        Iterator<String> it = names.iterator();
        //next() 取出當前數據，且移動至下一位
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next()); // NoSuchElementException

        // 2. 使用while遍歷
        while(it.hasNext()){
            String name = it.next();
            System.out.println(name);
        }
    }
}
