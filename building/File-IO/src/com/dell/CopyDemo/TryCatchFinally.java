package com.dell.CopyDemo;

import java.io.*;

public class TryCatchFinally {
    public static void main(String[] args) {
        // 目標：使用字節流完成文件的複製
        // 源文件：D:\WallPaper\thumb-1920-1392023.png
        // 目標文件： D:\WallPaper\thumb-1920-1392023_copy.png(複製過去必須帶文件名，無法自動生成文件名)

        copyFile("D:\\WallPaper\\thumb-1920-1392023.png", "D:\\WallPaper\\thumb-1920-1392023_copy.png");
    }

    // 複製文件
    // try-catch-finally
    private static void copyFile(String srcPath, String destPath) {
        InputStream fis = null;
        OutputStream fos = null;
        try {
            // 1. 創建一個文件字節輸入流與 源文件 連接
            fis = new FileInputStream(srcPath);
            fos = new FileOutputStream(destPath);

            // 2. 讀取一個字節數組，寫入一個字節數組
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            System.out.println("複製成功!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 既便程式出現異常，最後也會執行一次
            // 3.關閉流
            try {
                if(fis != null)fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos != null)fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
