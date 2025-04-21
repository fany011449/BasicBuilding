package com.dell.FileReader;

import java.io.FileReader;
import java.io.Reader;

public class Introduction {
    public static void main(String[] args) {
        // 目標：掌握文件字符輸入流讀取字符內容到程序中來
        //
        try (
                // 1. 創建文件字符輸入流FileReader與源文件Source接通
                Reader fr = new FileReader("File-IO\\src\\dell.txt");
        ) {
            // 2. 創建一個字符數組，每次讀取多個字符
            char[] chs = new char[3];
            int len; // 用於紀錄每次讀取了多少個字節
            while((len = fr.read(chs)) != -1){
                // 3. 每次讀取多個字符，並把字符數組轉換成字符串輸出
                String str = new String(chs, 0, len);
                System.out.print(str);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
