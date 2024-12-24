package com.dell.arrayList;


import java.util.ArrayList;

public class ArrayListDemo {
    public ArrayListDemo() {
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("文字");
        list.add("777");
        list.add("true");
        System.out.println(list);
    }
}