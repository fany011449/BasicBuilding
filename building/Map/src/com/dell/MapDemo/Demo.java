package com.dell.MapDemo;

import com.sun.jdi.Value;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        calc();
    }

    private static void calc() {
        // 1. 把80名學生的投票放入集合
        List<String> vote = new ArrayList<>();
        String[] view = {"台中", "台北", "新竹", "彰化"};
        Random r = new Random();

        for (int i = 0; i < 80; i++) {
            int index = r.nextInt(view.length);
            vote.add(view[index]);
        }

        System.out.println(vote);

        // 2. 統計每個景點被選擇的次數
        Map<String, Integer> map = new HashMap<>();

        // 3. 遍歷80個學生投票的結果，並統計投票最終結果
        for (String votes : vote){
            // 4. 判斷當前遍歷的景點是否在Map中存在
            // true 之前統計過
            // false 說明是第一次出現
            /**
            if(map.containsKey(votes)){
                map.put(votes, map.get(votes) + 1);
            } else {
                map.put(votes, 1);
            }
             */

            // 上列代碼可利用 "三元運算子" 來簡化
            map.put(votes, map.containsKey(votes) ? map.get(votes) + 1 : 1);
        }

        map.forEach((k,v) ->
                System.out.println(k + "統計票數：" + v));

        // 將票選最多的地點公布
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        int max = 0;
        String result = "";
        for (Map.Entry<String, Integer> entry : entries) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            if(v > max) {
                result = k;
                max = v;
            }
        }

        System.out.println("最終結果：" + result + "，共計票數：" + max);
    }
}
