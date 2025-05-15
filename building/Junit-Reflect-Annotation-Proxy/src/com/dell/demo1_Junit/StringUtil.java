package com.dell.demo1_Junit;

public class StringUtil {
    public static void printNumber(String name) {
        if(name == null){
            System.out.println("error");
            return;
        }
        System.out.println("名字長度： " + name.length());
    }

    public static int getIndex(String data) {
        if(data == null || "".equals(data)){
            return -1;
        }

        return data.length();
    }
}
