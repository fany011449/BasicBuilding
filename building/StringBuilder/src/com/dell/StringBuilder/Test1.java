package com.dell.StringBuilder;


import java.util.StringJoiner;

public class Test1 {
    public Test1() {
    }

    public static void main(String[] args) {
        System.out.println(getArrayData(new int[]{11, 22, 33}));
    }

    public static String getArrayData(int[] arr) {
        if (arr == null) {
            return null;
        } else {
            StringJoiner sb = new StringJoiner(",", "[", "]");

            for(int i = 0; i < arr.length; ++i) {
                sb.add(String.valueOf(arr[i]));
            }

            return sb.toString();
        }
    }
}
