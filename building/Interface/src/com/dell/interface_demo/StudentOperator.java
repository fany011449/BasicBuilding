package com.dell.interface_demo;

import java.util.ArrayList;
/*
    JDK8之前，接口中只能定義常量與抽象方法
    // 1. 常量：接口中定義常量可以省略public static final不寫，默認會加上去
    // 2. 抽象方法：接口中定義抽象方法可省略public abstract不寫，默認會加上去
    // 3. 注意！接口是不予許創建對象的
    //    => 接口是用來被類實現(implement)的，稱為實現類，一個類是能同時實現多個接口的
    // 4. 實現類實現多個接口，必須重寫所有接口的抽象方法。否則這個實現類就需要當成抽象類(通常使用重寫抽象方法)
 */

/*
    JDK8開始，新增了三種形式的方法
    1. 實例方法(默認方式):使用default修飾，默認會被加上public修飾。
        注意！只能使用接口的實現類對象調用
        (因為interface無法創建對象，所以使用需要一個類implement接口來調用實例方式)
        ex: default void run();
    2. 私有方式：必須使用private修飾，(JDK9開始才支持)
            因為是私有的，所以只能在interface內調用
        ex: private void test();
    3. 靜態方法(類方法)：使用static修飾，默認會被加上public修飾。
        注意！只能用接口名來調用
        ex: static void cry();
        調用方法：接口名.cry();
 */
public interface StudentOperator {
    void printAllInfo(ArrayList<Student> var1);

    void printScore(ArrayList<Student> var1);
}
