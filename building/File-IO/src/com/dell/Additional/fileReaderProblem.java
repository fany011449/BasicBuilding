package com.dell.Additional;

import java.io.*;

public class fileReaderProblem {
    public static void main(String[] args) {
        // 目標：使用字符轉換流InputStreamReader解決不同編碼讀取亂碼的問題
        // 代碼：UTF-8 文件：UTF-8 讀取不亂碼
        // 代碼：UTF-8 文件：GKB 讀取亂碼

        try (
                InputStream is = new FileInputStream("File-IO\\src\\fileReadProblem.txt");
                // solution：使用InputStreamReader。
                // 獲取原始"字節流"，在指定編碼做轉換
                Reader isr = new InputStreamReader(is, "GBK");
                BufferedReader br = new BufferedReader(isr);
        ) {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
