package com.dell.GameDemo;

public class array2D {
    public static void main(String[] args) {
        // 目標：完成數字的初始化以及亂數排序
        start(4);
    }

    public static void start(int n) {
        // 1. 定義一個二維陣列
        int[][] arr = new int[n][n];

        // 2. 遍歷二維陣列，並且賦值
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = count++;
            }
        }

        printArray(arr);

        // 3. 打亂二維陣列中的元素順序
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                // 遍歷到的當前位置：arr[i][j]
                // 隨機的索引位置：m(隨機的行)、p(隨機的列)
                int m = (int) (Math.random() * (arr.length));
                int p = (int) (Math.random() * (arr.length));

                // 定義一個臨時變量存儲m，p的位置處的數據
                int temp = arr[m][p];
                // 把i, j位置處的數據給m, p
                arr[m][p] = arr[i][j];
                arr[i][j] = temp;
            }
        }

        System.out.println("============");
        printArray(arr);
    }

    public static void printArray(int[][] arr) {
         for (int i = 0; i < arr.length; i++) {
             for (int j = 0; j < arr[i].length; j++) {
                 System.out.print(arr[i][j] + "\t");
             }
             System.out.println();
         }
    }
}
