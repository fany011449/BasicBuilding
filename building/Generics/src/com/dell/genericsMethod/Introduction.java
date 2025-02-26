package com.dell.genericsMethod;

import com.dell.genericsInterFace.Student;

public class Introduction {
    public static void main(String[] args) {
        // 目標：學習泛型方法
        // 打印任意數組的內容

        String[] arr = {"ab", "cba", "nba"};
        printArrayList(arr);

        Student[] student = new Student[3];
        printArrayListWithGenerics(student);
    }
    // 使用此方法會導致Student的數組無法傳入, 14行會報錯
    public static void printArrayList(String[] arr){

    }

    // 此為泛型方法
    public static <T> void printArrayListWithGenerics(T arr){

    }

    // 更嚴謹的將返回值型態也設定為泛型，避免之後強轉類型
    public static <T> T printArrayListWithGenericsAndReturnValueType(T arr){
        return null;
    }
}
