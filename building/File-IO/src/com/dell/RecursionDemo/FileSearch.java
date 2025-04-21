package com.dell.RecursionDemo;

import java.io.File;
import java.io.IOException;

public class FileSearch {
    public static void main(String[] args) {
        // 目標：完成文件搜索，找出在D:槽下target.txt的位置
        try {
            File dir = new File("D:/");
            searchFile(dir, "DiscordSetup.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param dir 搜索的目錄
     * @param fileName 搜索的文件名稱
     */
    private static void searchFile(File dir, String fileName) throws IOException {
        // 1. 判斷極端情況
        if(dir == null || !dir.exists() || dir.isFile()){
            return; // 不搜索
        }

        // 2. 獲取目錄下的所有一級文件或者文件夾對象
        File[] files = dir.listFiles();

        // 3. 判斷當前目錄下是否存在一級文件對象，存在才可以遍歷
        if(files != null && files.length > 0){
            // 4. 遍歷所有一級文件對象
            for(File file : files){
                // 5. 判斷當前一級文件對象是否是文件
                if(file.isFile()){
                    // 6. 判斷文件名稱是否和目標文件名稱一致，模糊查詢只要包含就顯示
                     if(file.getName().contains(fileName)){
                         System.out.println("找到目標文件" + file.getAbsolutePath());
                         // 7. 執行軟件exe檔
                         Runtime r = Runtime.getRuntime();
                         r.exec(file.getAbsolutePath());
                     }
                } else {
                    searchFile(file, fileName);
                }
            }
        }
    }

}
