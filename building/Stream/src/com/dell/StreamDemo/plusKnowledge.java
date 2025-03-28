package com.dell.StreamDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class plusKnowledge {
    public static void main(String[] args) {
        // 目標1：認識可變參數
        // 優勢：參數接受變得靈活，可代替數組傳參
        sum(1);
        sum(11);
        sum(11,22,33,44);
//        sum(new int[]{11, 33,34,55});
        System.out.println("---------------------------------------");

        // 目標2 ：認識Collections工具類
        List<String> list = new ArrayList<>();
//        list.add("張無忌");
//        list.add("張飛");
//        list.add("張天明");
//        list.add("張張");
//        list.add("張張");
//        list.add("張鬍鬚");
//        list.add("陳幼幼");
//        list.add("陳漢和");

        // 一次添加全部
        Collections.addAll(list, "張無忌","張飛","張天明","張張");

        // 2. 打亂順序
        Collections.shuffle(list);
        System.out.println(list);
    }

    // 注意事項：可變參數只能存在一個，且只能放在參數最後
    private static void sum(int arr, int...num) {
        // 內部拿取參數data
        // 可變參數就是個數組
        System.out.println(num.length);
        System.out.println(Arrays.toString(num));

    }
}
