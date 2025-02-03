package com.dell.stsaticInnerClass;

public class Test {
    public static void main(String[] args) {
        // 靜態內部類的宣告 ，與普通的成員內部類不同
        Outer.Inner inner = new Outer.Inner();
        inner.method();
    }
}
