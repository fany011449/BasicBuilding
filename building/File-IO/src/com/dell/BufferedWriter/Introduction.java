package com.dell.BufferedWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class Introduction {
    public static void main(String[] args) {
        // 目標：搞清楚緩衝字符輸出流，提高性能。增加了換行功能
        try (
//                Writer wt = new FileWriter("File-IO\\src\\d.txt")
                //  追加數據
                Writer wt = new FileWriter("File-IO\\src\\d.txt",true);

                BufferedWriter bwr = new BufferedWriter(wt);
        ) {

            // 寫一個字符出去
            bwr.write(98);
            bwr.write('a');
            bwr.write('陳');
            bwr.newLine();
            // 寫一個字符出去
            bwr.write("我妳");
            bwr.newLine();

            // 寫一個字符數組
            char[] ch = "java".toCharArray();
            bwr.write(ch);
            bwr.newLine();

            // 寫字符數組的一部分
            bwr.write(ch, 1, 2);
            bwr.newLine();

            // 寫一個字串中的一部分出去
            bwr.write("java", 1, 2);
            bwr.newLine();

            // 刷新緩衝區，將緩衝區的數據全部寫出去
            // 刷新後，流可以繼續使用
            bwr.flush();

            // 關閉資源
            // 關閉包含了flush()，關閉後無法繼續使用流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
