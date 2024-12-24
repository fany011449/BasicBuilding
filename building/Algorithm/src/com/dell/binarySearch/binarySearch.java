package com.dell.binarySearch;

import java.util.Arrays;

public class binarySearch {
    public binarySearch() {
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, 122, 0, 5, 4, 7, 85, 69, 11, 0, 1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr, 0));
    }

    public static int binarySearch(int[] arr, int data) {
        int left = 0;
        int right = arr.length;

        while(left <= right) {
            int mid = (left + right) / 2;
            if (data > arr[mid]) {
                left = mid + 1;
            } else {
                if (data >= arr[mid]) {
                    return mid;
                }

                right = mid - 1;
            }
        }

        return -1;
    }
}