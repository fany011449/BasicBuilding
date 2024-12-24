package com.dell.generics;


public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList();
        myArrayList.add("java1");
        myArrayList.add("java2");
        String ele = (String)myArrayList.get(1);
        System.out.println(ele);
    }
}