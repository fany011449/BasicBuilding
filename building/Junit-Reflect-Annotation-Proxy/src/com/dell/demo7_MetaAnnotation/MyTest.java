package com.dell.demo7_MetaAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 編譯器運行時(一直都存在)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR}) // 只能註解在 方法、成員變量、構造器
public @interface MyTest {
}
