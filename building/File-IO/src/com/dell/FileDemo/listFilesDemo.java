package com.dell.FileDemo;

import java.io.File;
import java.util.Arrays;

public class listFilesDemo {
    public static void main(String[] args) {
        // 目標：注意listFiles()的操作
        File dir = new File("D:\\WallPaper\\abc");
        File dir1 = new File("D:\\WallPaper\\bbb\\ccc");

        /**
         * 1. 當主調是文件、路徑不存在時，返回null
         * 2. 當主調是空文件夾時，返回一個長度為0的數組
         * 3. 當主調是一個有內容的文件夾時，將裡面所有一級文件和文件夾的路徑放在File數組中返回
         * 4. 當主調是一個文件，且裡面也隱藏文件時，將裡面所有文件和文件夾的路徑放在File數組中返回，包含隱藏文件
         * 5. 當主調是一個文件夾，但是沒有權限訪問該文件夾時，返回null
         */

        // 1. 當主調是文件、路徑不存在時，返回null
        File[] files = dir.listFiles();
        System.out.println(files);

        // 2. 當主調是空文件夾時，返回一個長度為0的數組
        File[] files1 = dir1.listFiles();
        System.out.println(files1);
        System.out.println(Arrays.toString(files1));
    }
}
