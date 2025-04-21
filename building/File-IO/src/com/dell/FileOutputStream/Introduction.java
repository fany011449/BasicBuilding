package com.dell.FileOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Introduction {
    public static void main(String[] args) throws Exception {
        // 目標：學會使用文件字節輸出流
        // 1. 創建文件字節輸出流語文件接通
//        OutputStream os = new FileOutputStream("File-IO\\src\\dell-out.txt");
        // 4. 在原先文件後，追加數據
        OutputStream os = new FileOutputStream("File-IO\\src\\dell-out.txt",true);

        // 2. 寫入數據
        os.write(97);
        os.write('b');
//        os.write('徐'); // 會亂碼
        os.write("\r\n".getBytes()); // 換行。\r\n在其他 OS上比較能兼容

        // 3. 寫一個字節數組出去
        byte[] bytes = "你我他abc".getBytes();
        os.write(bytes);

        // 4. 只取字節數組的一部分
        os.write(bytes, 0, 3);

        // 關閉流
        os.close();
    }
}
