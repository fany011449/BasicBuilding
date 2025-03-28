package com.dell.Introduction;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class MapTravel {
    public static void main(String[] args) {
        /**
         * Map 集合的遍歷方式之一：鍵找值
         */
        Map<String, Integer> map = new HashMap<>();
        map.put("佑", 28);
        map.put("菡", 28);
        map.put("平", 31);
        map.put("旻", 23);
        map.put("孫", 63);
        map.put("孫", 11);

        System.out.println(map);

        // 提起Map集合的全部key到一個Set集合中
        Set<String> keys = map.keySet();

        for (String key:keys){
            Integer value = map.get(key);
            System.out.println(key + "=" + value);
        }

        System.out.println("------------------------------------");
        /**
         *         Map 集合的遍歷方式之二：鍵值對
         *         需要將Map集合轉換成Set集合，且裡面的元素要都存key-value
         *         Map.Entry<String, Integer>
         *         快捷鍵：map.entrySet().var
         */
        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "=" + value);
        }

        System.out.println("------------------------------------");

        /**
         *      Map 集合的遍歷方式之三：Lambda
         */

        map.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String key, Integer value) {
                System.out.println(key + "=" + value);
            }
        });

        System.out.println("------------------------------------");

        // lambda簡化
        map.forEach((key, value) -> System.out.println(key + "=" + value));

        System.out.println("------------------------------------");

        // 參數可再簡化
        map.forEach((k, v) -> System.out.println(k + "=" + v));

    }
}
