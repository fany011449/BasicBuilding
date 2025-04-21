package com.dell.FileDemo;

import java.io.File;
import java.io.IOException;

public class Introduction {
    public static void main(String[] args) throws IOException {
        // 目標：創建File創建對象代表文件，搞清楚其對文件提供的操作方法
        // 1. 創建File對象，去獲取某個文件的信息
        File f1 = new File("D:\\WallPaper\\thumb-1920-1392023.png");

        System.out.println(f1.length());
        System.out.println(f1.getName());
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory()); // 是否是資料夾

        // 2. 相對路徑 / 絕對路徑：
        // 只要帶槽的都是【絕對路徑】，eg:D:\WallPaper\thumb-1920-1392023.png
        // 反之。稱為【相對路徑】。默認是到你的idea工程下直接尋找文件，一般來找工程下的項目文件

        // 絕對路徑
        File f2 = new File("D:\\develop\\Code\\building\\File-IO\\src\\dell.txt");
        // 相對路徑
        File f3 = new File("File-IO\\src\\dell.txt");

        System.out.println(f3.length());

        // 3. 創建文件
        File f4 = new File("D:\\WallPaper\\dell.txt");
        System.out.println(f4.exists()); // 判斷是否存在
        System.out.println(f4.createNewFile()); // 這裡需要拋異常

        // 4. 創建文件夾
        File f5 = new File("D:\\WallPaper\\aaa");
        System.out.println(f5.mkdir()); // 只能創建一個新的，無法直接創建二級文件夾

        File f6 = new File("D:\\WallPaper\\bbb\\cccc");
        System.out.println(f6.mkdir()); // 無法這樣創建需要用到mkdirs()
        System.out.println(f6.mkdirs());

        // 5. 刪除
        // 文件
        System.out.println(f4.delete());
        // 文件夾
        System.out.println(f5.delete());
        // 無法刪除內有文件的文件夾
        File f7 = new File("D:\\WallPaper");
        System.out.println(f7.delete());

        // 6. 可獲取某個目錄下的一級文件【名稱】
        String[] names = f7.list();
        for (String name : names) {
            System.out.println(name);
        }

        // 7. 可獲取某個目錄下的一級文件【對象】
        File[] f8 = f7.listFiles();
        for (File file : f8) {
            System.out.println(file.getAbsoluteFile());
        }
    }
}
