package com.dell.BufferedInputStream;

import java.io.*;

public class Introduction {
    public static void main(String[] args) {
        // 目標：使用字節流完成文件的複製
        // 源文件：D:\WallPaper\thumb-1920-1392023.png
        // 目標文件： D:\WallPaper\thumb-1920-1392023_copy.png(複製過去必須帶文件名，無法自動生成文件名)

        copyFile("D:\\WallPaper\\thumb-1920-1392023.png", "D:\\WallPaper\\thumb-1920-1392023_copy.png");
    }

    // 複製文件
    // try-catch-resource
    private static void copyFile(String srcPath, String destPath) {
        // 1. 創建一個文件字節輸入流與 源文件 連接
        try (
                // 這裡只能放置資源對象，用完後最終會自動調其close()。
                // 資源對象：必須繼承 AutoCloseable接口/ Closeable接口
                InputStream fis = new FileInputStream(srcPath);
                OutputStream fos = new FileOutputStream(destPath);

                // 將低級的字節輸出/輸入流包裝成 高級的
                InputStream bis = new BufferedInputStream(fis);
                OutputStream bos = new BufferedOutputStream(fos);
                )
        {
            // 2. 讀取一個字節數組，寫入一個字節數組
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }

            System.out.println("複製成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
