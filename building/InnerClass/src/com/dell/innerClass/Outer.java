package com.dell.innerClass;

public class Outer {
    // 外部類
    private static final String name = "outer";
    private static void outerShow () {};
    private int age = 11;
    private void run(){};

    public class Inner {
        // 內部類
        // 成員內部類：無static修飾，屬於外部類的對象持有的
        // 成員內部類訪問外部類成員的特點

        public void show () {
            System.out.println("inner show");
            // 1. 成員內部類可以訪問外部類的靜態成員
            System.out.println(name);
            // 2. 成員內部類可以訪問外部類的靜態方法
            outerShow();
            // 3. 成員內部類可以訪問外部類的非靜態成員(實例成員)
            System.out.println(age);
            // 4. 成員內部類可以訪問外部類的非靜態方法(實例方法)
            run();
        }

    }
}
