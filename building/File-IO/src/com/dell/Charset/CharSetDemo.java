package com.dell.Charset;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CharSetDemo {
    public static void main(String[] args) throws Exception {
        // 目標：寫程序實現字符編碼與解碼
        String name = "你我他abc";

        // 1. 編碼
        // UTF-8
        byte[] bytes = name.getBytes();
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));

        // GBK
        byte[] bytes1 = name.getBytes("GBK");
        System.out.println(bytes1.length);
        System.out.println(Arrays.toString(bytes1));

        // 2. 解碼
        String name1 = new String(bytes);
        System.out.println(name1);

        String name2 = new String(bytes1, "GBK");
        System.out.println(name2);
    }
}
