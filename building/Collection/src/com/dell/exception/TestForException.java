package com.dell.exception;

/**
 * 現在JAVA正在淘汰編譯時異常
 * 所以使用Runtime Exception就好，因為他不會干擾到其他人使用
 */
public class TestForException {
    public static void main(String[] args) throws ExceptionDemo {
        // 年齡小於1歲或者大於120歲的例外處理
        illegalAge(1011);
    }

    public static void illegalAge(int age) throws ExceptionDemo {
        if (age < 1 || age > 120) {
            throw new ExceptionDemo("年齡必須介於1歲到120歲之間");
        }else {
            System.out.println("年齡正常");
        }
    }
}
