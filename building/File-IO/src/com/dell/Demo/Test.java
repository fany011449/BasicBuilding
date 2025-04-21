package com.dell.Demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new FileReader("D:\\develop\\Code\\building\\File-IO\\src\\newFile.txt"));
                BufferedWriter bwr = new BufferedWriter(new FileWriter("D:\\develop\\Code\\building\\File-IO\\src\\newFile-out.txt"))
        ) {
            // 準備一個list集合存儲每段內容
            List<String> data = new ArrayList<>();
            // 按照各行讀取data，存進list中
            String line;
            while ((line = br.readLine()) != null){
                data.add(line);
            }
            // 每段首字母做升序
            data.sort(Comparator.comparingInt(s -> {
                String[] period = s.split("\\.");
                return Integer.parseInt(period[0]);
            }));

            System.out.println(data);

            // 遍歷集合，將每段內容寫入目標文件
            for (String s : data){
                bwr.write(s);
                bwr.newLine();
            }

            bwr.flush(); // 確保寫入

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
