package com.dell.Collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 目標：認識併發修改異常，且搞清楚每個遍歷(三種)的區別
 *      遍歷集合的同時又存在增刪改查的行為時可能會出現的Exception
 */
public class Test {
    public static void main(String[] args) {
        // 需求：Java入門、寧夏枸杞、人字拖、特級枸杞、枸杞子。現在用戶不想要枸杞子，選擇了批量刪除。
        ArrayList<String> list = new ArrayList<>();
        list.add("Java入門");
        list.add("寧夏枸杞");
        list.add("人字拖");
        list.add("特級枸杞");
        list.add("枸杞子");

        // 需求1：刪除全部枸杞
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            if(name.contains("枸杞")){
                list.remove(name);
            }
        }

        // 此時會發現含有"枸杞"的商品並沒有全部刪除，因為發生了併發修改異常
        System.out.println(list);
        /* 因為在遍歷的過程，其中刪除了一個元素後，索引 i 並沒有隨之改變。
        EX:
            [java入門， 寧夏枸杞， 人字拖， 特級枸杞， 枸杞子]
                          i
            [java入門， 人字拖， 特級枸杞， 枸杞子]
                                  i
            [java入門， 人字拖， 枸杞子]
                                         i

            每當刪除的時候， i還是隨著原先的遍歷繼續往前，所以可能造成{併發修改問題} ！
         */

        // =======================修改方法1============================
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Java入門");
        list1.add("寧夏枸杞");
        list1.add("人字拖");
        list1.add("特級枸杞");
        list1.add("枸杞子");

        for (int i = 0; i < list1.size(); i++) {
            String name = list1.get(i);
            if(name.contains("枸杞")){
                list1.remove(name);
                i--;
            }
        }

        System.out.println(list1);
        // =======================修改方法1============================

        // =======================修改方法2============================
        // 使用迭代器遍歷且刪除
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Java入門");
        list2.add("寧夏枸杞");
        list2.add("人字拖");
        list2.add("特級枸杞");
        list2.add("枸杞子");

        Iterator<String> it = list2.iterator();

        while(it.hasNext()){
            String name = it.next();
            if(name.contains("枸杞")){
                // 無法使用list2 來remove，否則會發生下面的Exception
//                list2.remove(name);
                // Iterator 有提供自己的方法來刪除
                it.remove();
            }
        }

        // 此處就會發生Exception：ConcurrentModificationException
        System.out.println(list2);
    }
    // =======================修改方法2============================

    /*
        遍歷方式2 Enhance for
        遍歷方式3 lambda
        兩者都是無法自動避免"併發修改異常"
     */

    // =======================修改方法3============================

    // =======================修改方法3============================

}
