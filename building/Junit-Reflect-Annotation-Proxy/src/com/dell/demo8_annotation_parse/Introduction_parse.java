package com.dell.demo8_annotation_parse;

import com.dell.demo3_reflection.demo;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Introduction_parse {
    public static void main(String[] args) {
        // 目標：解析註解

    }

    // 解析類的註解
    @Test
    public void parseClass(){
        // 1. 獲取類的對象
        Class c1 = demo.class;

        // 2. 判斷類裡面是否有MyTest的註解
        if(c1.isAnnotationPresent(MyTest.class)) {
            // 3. 獲取註解的對象
            MyTest myTest = (MyTest) c1.getDeclaredAnnotation(MyTest.class);

            // 4. 既可獲取其屬性
            String value = myTest.value();
            double price = myTest.price();
            String[] address = myTest.address();

            System.out.println(value);
            System.out.println(price);
            System.out.println(Arrays.toString(address));
        }
    }

    // 解析方法的註解
    @Test
    public void parseMethod() throws Exception {
        // 1. 獲取類的對象
        Class c1 = demo.class;

        Method m1 = c1.getMethod("go");
        // 2. 判斷類裡面是否有MyTest的註解
        if(m1.isAnnotationPresent(MyTest.class)) {
            // 3. 獲取註解的對象
            MyTest myTest = m1.getDeclaredAnnotation(MyTest.class);

            // 4. 既可獲取其屬性
            String value = myTest.value();
            double price = myTest.price();
            String[] address = myTest.address();

            System.out.println(value);
            System.out.println(price);
            System.out.println(Arrays.toString(address));
        }
    }
}
