package com.dell.demo9_annotation;

import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws Exception {
        // 目標；搞清楚註解的應用場景，模擬Junit框架，有MyTest註解的方法才執行

        /*
            1. 獲取類對象
            2. 獲取所有方法
            3. 遍歷所有方法，判斷是否存在MyTest
         */

        Class c1 = Demo.class;

        Method[] methods = c1.getMethods();

        for (Method method : methods) {
            if(method.isAnnotationPresent(MyTest.class)){
                MyTest mytest = method.getDeclaredAnnotation(MyTest.class);
                int count = mytest.count();
                for (int i = 0; i < count; i++) {
                    method.invoke(new Demo());
                }
            }
        }
    }

    @MyTest(count = 5) // 代表這個數字要跑幾遍
    public void test1(){
        System.out.println("test1執行了");
    }

    @MyTest
    public void test2(){
        System.out.println("test2執行了");
    }

    public void test3(){
        System.out.println("test3執行了");
    }

    public void test4(){
        System.out.println("test4執行了");
    }
}
