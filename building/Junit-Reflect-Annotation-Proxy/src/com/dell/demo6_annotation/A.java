package com.dell.demo6_annotation;
// 自定義註解
public @interface A {
    // 每行都視為一個方法
    String name();
    int age() default 18; // 加上默認值
    String[] address();
}
