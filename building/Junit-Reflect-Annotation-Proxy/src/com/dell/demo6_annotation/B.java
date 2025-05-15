package com.dell.demo6_annotation;

public @interface B {
    // 如果使用時只有一個Value屬性，Value名稱可以不寫
    String value();
    String name() default "哈"; // 有默認值是可以不寫，此時此註解B又只剩一個屬性了
}
