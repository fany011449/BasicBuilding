package com.dell.FileWriter;

import java.io.FileWriter;
import java.io.Writer;

public class Introduction {
    public static void main(String[] args) {
        // 目標：文件字符輸出流的使用
        try (
//                Writer wt = new FileWriter("File-IO\\src\\d.txt")
                //  追加數據
                Writer wt = new FileWriter("File-IO\\src\\d.txt",true);
        ) {

            // 寫一個字符出去
            wt.write(98);
            wt.write('a');
            wt.write('陳');

            // 寫一個字符出去
            wt.write("\r\n");
            wt.write("我妳\r\n");

            // 寫一個字符數組
            char[] ch = "java\r\n".toCharArray();
            wt.write(ch);

            // 寫字符數組的一部分
            wt.write(ch, 1, 2);

            // 寫一個字串中的一部分出去
            wt.write("java", 1, 2);


            // 刷新緩衝區，將緩衝區的數據全部寫出去
            // 刷新後，流可以繼續使用
            wt.flush();

            // 關閉資源
            // 關閉包含了flush()，關閉後無法繼續使用流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
