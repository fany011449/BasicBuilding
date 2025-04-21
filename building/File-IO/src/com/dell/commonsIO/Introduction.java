package com.dell.commonsIO;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Introduction {
    public static void main(String[] args) throws Exception {
        // 目標：IO框架
        FileUtils.copyFile(new File("D:\\develop\\Code\\building\\File-IO\\src\\dell.txt"), new File("D:\\develop\\Code\\building\\File-IO\\src\\dell11.txt"));
    }
}
