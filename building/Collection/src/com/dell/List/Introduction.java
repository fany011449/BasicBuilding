package com.dell.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  目標：掌握List系列集合獨有的功能。
 */
public class Introduction {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(); // 經典代碼

        // 添加數據
        names.add("aa");
        names.add("bb");
        names.add("cc");
        System.out.println(names);

        // 給第三個位置插入數據
        names.add(2, "dd");

        // 刪除bb
        names.remove("dd");
        names.remove(1);

        System.out.println(names);

        // 把cc改成sf
        names.set(1, "sf");
        System.out.println(names);

        // 獲取sf
        System.out.println(names.get(1));

        //----------------------------------四種遍歷演示---------------------------------------------------------

        //1. for循環
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        // 迭代器
        Iterator<String> it = names.iterator();
        while(it.hasNext()){
            String name = it.next();
            System.out.println(name);
        }

        // Enhance For
        for(String name:names){
            System.out.println(name);
        }

        // lambda 表達式
        names.forEach(name -> System.out.println(name));
    }
}
