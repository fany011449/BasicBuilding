package com.dell.String;

public class Introduction {
    public static void main(String[] args) {

        // String 有兩種方式能夠創建：
        // 1. 使用     " "   來創建
        // 2. 使用 String 類別的 constructor 來創建，也是使用new 關鍵字
        String str = "Hello World";
        String str1 = "Hello World";
        // 因為是使用 " " 來創建，"Hello World" 字串會被儲存在 String pool 中，因此 str 和 str1 指向同一個物件
        System.out.println(str == str1); // true

        // 因為是使用 String 類別的 constructor 來創建，"Hello World" 字串會被儲存在 heap (堆內存) 中，因此 str 和 str2 指向不同的物件
        String str2 = new String("Hello World");
        System.out.println(str == str2); // false
    }
}
