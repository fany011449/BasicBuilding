package com.dell.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 異常有兩種
 * 1. 編譯時期的異常(Compile-time Exception)
 * 2. 執行時期的異常(Runtime Exception)
 */
public class Introduction {
    public static void main(String[] args) throws ParseException {

//        show2();

        try {
            show();
        } catch (ArithmeticException e) {
            // 打印出這個異常
            e.printStackTrace();
        }
    }

    // 第一種：編譯時期的異常(Compile-time Exception)
    public static void show() throws ParseException {
        System.out.println("this is a test---------------");
        String str = "2025/02/07 12:00:00";

        // 把字符串時間解析成Java中的一個日期對象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = sdf.parse(str);
        // 這裡報錯了，是因為日期格式可能不正確，所以系統報錯讓你做異常的處理
        System.out.println(date);
        System.out.println("this is the end-------------");
    }

    // 第二種：執行時期的異常(Runtime Exception)
    public static void show2() {
        System.out.println("this is a test-");
        String str = null;
        // 這裡報錯了，是因為你可能會把null傳入到某個方法裡面，所以系統報錯讓你做異常的處理
        // 空指針異常
        System.out.println(str);
        System.out.println(str.length());
    }
}
