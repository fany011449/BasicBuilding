package com.dell.demo4_reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class demo {
    public static void main(String[] args) throws Exception {
        // 目標：反射的基本作用
        // 1. 類的全部成分的獲取
        // 2. 可以破壞封裝性
        // 3. 可以繞過泛型的約束
        ArrayList<String> list = new ArrayList<>();
        list.add("qqq");
        list.add("qqq");
        list.add("qqq");
        // 此時，若加入其他類型;比如 Int 、 boolean會報錯
        // list.add(1);

        // 此時利用反射，能夠暴力突破權限
        // 取類的對象
        Class c1 = list.getClass();
        //
        Method add = c1.getDeclaredMethod("add", Object.class);
        // 觸發list集合對象的add方法
        add.invoke(list, 9.9);
        add.invoke(list, true);

        System.out.println(list);
    }
}
