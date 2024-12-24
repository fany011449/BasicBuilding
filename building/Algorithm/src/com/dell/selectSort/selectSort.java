package com.dell.selectSort;

import java.util.Arrays;

public class selectSort {
    public selectSort() {
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 15, 0, 66, 84, 99, 3};

        for(int i = 0; i < arr.length - 1; ++i) {
            for(int j = i + 1; j < arr.length; ++j) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}