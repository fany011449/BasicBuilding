package com.dell.generics;

import java.util.ArrayList;

public class Introduction {
    public static void main(String[] args) {
        /*
            目標： 了解通配符與上下限
         */

        ArrayList<BMW> bmw = new ArrayList<>();
        bmw.add(new BMW());
        goWitWildcardAndUpperBound(bmw);

        ArrayList<Jimny> jimny = new ArrayList<>();
        jimny.add(new Jimny());
        goWitWildcardAndUpperBound(jimny);
    }

    // 兩台車款需要做比較測試
    // 這就導致此方法只能接受一個對象
    // 17行會報錯
    public static void go(ArrayList<BMW> cars) {

    }

    // BMW、Jimny兩者都是Car的子類
    // 但是ArrayList<BMW>、ArrayList<Jimny>並不是ArrayList<Car>的子類
    // 13，17行會報錯
    public static void go1(ArrayList<Car> cars){

    }

    // 這邊使用通配符 ?　既可處理此問題
    // 但要注意這邊使用通配符？就代表了接受一切對象
    // 此時如果有其他不相關的對象就會混進來，容易出錯，不嚴謹
    public static void goWithWildcard(ArrayList<?> cars) {

    };

    // 防止其他對象混進來，將通配符做個限制，也就是所謂的上下限

    // 上限Upper Bound
    public static void goWitWildcardAndUpperBound(ArrayList<? extends Car> cars){

    }

    // 下限Lower Bound
    public static void goWitWildcardAndLowerBound(ArrayList<? super Car> cars){

    }
}
