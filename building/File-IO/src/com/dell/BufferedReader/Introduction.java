package com.dell.BufferedReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class Introduction {
    public static void main(String[] args) {
        // 目標：緩衝字符輸出流，性能提升，多了這行讀取文本能力
        try (
                // 1. 創建文件字符輸入流FileReader與源文件Source接通
                Reader fr = new FileReader("File-IO\\src\\dell.txt");
                // 包裝成高級
                BufferedReader br = new BufferedReader(fr);
        ) {
            // 2. 創建一個字符數組，每次讀取多個字符
//            char[] chs = new char[3];
//            int len; // 用於紀錄每次讀取了多少個字節
//            while((len = br.read(chs)) != -1){
//                // 3. 每次讀取多個字符，並把字符數組轉換成字符串輸出
//                String str = new String(chs, 0, len);
//                System.out.print(str);
//            }

//            System.out.println(br.readLine());
//            System.out.println(br.readLine());
//            System.out.println(br.readLine());
//            System.out.println(br.readLine());
//            System.out.println(br.readLine()); // null
//            System.out.println(br.readLine()); // null

            // 使用循環改進，來按照行讀取數據
            // 目前讀取文本最優解
            // 性能好，不亂碼，可按照行讀取
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
