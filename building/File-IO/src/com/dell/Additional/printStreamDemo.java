package com.dell.Additional;

import java.io.PrintStream;

public class printStreamDemo {
    public static void main(String[] args) {
        // 目標：打印流的使用
        try (
                PrintStream ps = new PrintStream("File-IO\\src\\ps.txt")
        ) {
            ps.println(94);
            ps.println('a');
            ps.println("王");
            ps.println(true);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
