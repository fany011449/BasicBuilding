package com.dell.bubbleSort;


import java.util.Arrays;

public class bubbleSort {
    public bubbleSort() {
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 55, 66, 6, 7, 89, 1, 10};

        for(int i = 0; i < arr.length - 1; ++i) {
            for(int j = 0; j < arr.length - i - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int index = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = index;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}