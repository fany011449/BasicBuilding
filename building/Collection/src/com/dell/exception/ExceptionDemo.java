package com.dell.exception;

/**
 * 自定義的編譯時異常(compile-time exception)
 * 1. 繼承Exception當父類
 * 2. 重寫Exception的構造器
 * 3. 哪裡需要這個異常，就在哪裡throws
 */
public class ExceptionDemo extends Exception {
    public ExceptionDemo(String message) {
        super(message); // 呼叫父類的構造器
    }
}
