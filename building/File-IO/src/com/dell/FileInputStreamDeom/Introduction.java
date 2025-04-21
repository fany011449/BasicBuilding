package com.dell.FileInputStreamDeom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Introduction {
    public static void main(String[] args) throws Exception {
        // 目標：掌握文件字節輸入流讀取文件中的字節數組道內存中來
        // 1. 創建文件字節輸入流
        InputStream is = new FileInputStream("File-IO\\src\\dell.txt");

        // 2. 開始讀取文件中的字節並輸出
        // 定義一個變量記住每次讀取的一個字節

        // 【read()】
        // 只要沒發現data就會返回-1
        // 每次讀取一個字節的問題：
        // 1. 性能差
        // 2. 讀取漢字必會亂碼
        int b;
        while ((b = is.read()) != -1) {
            System.out.print((char) b);
        }

        // 【read(buffer)】
        // 只要沒發現data就會返回-1
        // 拓展：每次讀取多少字節，性能得到提升，因為每次讀取多個字節，可以減少【磁碟】與【內存】的交互次數，從而提升性能。
        // 依舊無法避免漢字出現亂碼的可能
        byte[] buffer = new byte[3];
        int len;
        while((len = is.read(buffer)) != -1){
            // 把讀到的字節數組轉換成字符串輸出，讀取多少倒出多少
            // 從 0 開始讀 -> 第len的字節
            String str = new String(buffer, 0, len);
            System.out.println(str);
        }


        // 【readAllBytes()】
        // 一次性讀完所有字節
        // 可避免中文出現亂碼的可能
        // 只有JDK9以上支持
        byte[] rs = is.readAllBytes();
        String s = new String(rs);
        System.out.println(s);

        // 使用完後必須關閉
        is.close();
    }
}
