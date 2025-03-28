package com.dell.Introduction;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Introduction {
    public static void main(String[] args) {
        // 目標：認識Map集合
        // HashMap特點：無序、不重複、無索引。鍵值都是可以是null，值value不要求(可重複)。但key不能重複!
        // LinkedHashMap特點："有序"、不重複、無索引。鍵值都是可以是null，值value不要求(可重複)。但key不能重複!
        // TreeMap特點："按照鍵可排序"、不重複、無索引。
        Map<String,Integer> map = new HashMap<>();

        map.put("佑", 28);
        map.put("菡", 28);
        map.put("平", 31);
        map.put("旻", 23);
        map.put("孫", 63);
        map.put("孫", 11);
        map.put(null, null);
        System.out.println(map);

        System.out.println("-----------------------------------------------------");

        map.get("孫"); // 根據key取value

        System.out.println(map.containsKey("佑"));// 判斷是否存在該key

        System.out.println(map.containsValue(28));// 判斷是否存在該value

        System.out.println(map.remove("佑")); // 根據key刪除該key-value

        System.out.println(map.isEmpty()); // 判斷是否為空

        System.out.println(map.size()); // 整個map有多少key-value

        //keySet()：將所有獲取的鍵Key放到一個Set
        Set<String> keys = map.keySet();
        for ( String key : keys) {
            System.out.println(key);
        }

        //values()：將所有獲取的鍵Value放到一個Collection
        Collection<Integer> values = map.values();
        for ( Integer value : values) {
            System.out.println(value);
        }

        /**
         * 思考點：為甚麼 Key是Set裝，Values是用Collection裝
         * Answer： 因為Key是 不可重複，反之。value可
          */
        map.clear(); // 清除
    }
}
