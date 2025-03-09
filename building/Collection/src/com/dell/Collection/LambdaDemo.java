package com.dell.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

/**
 * 目標： 掌握 Collection 遍歷的方法三：Lambda
 */
public class LambdaDemo {
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<>();
        names.add("abc");
        names.add("bca");
        names.add("aaa");
        names.add("dd");

        // lambda 層層簡化
        // step 1.
        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // step 2.
        names.forEach(s -> System.out.println(s));

        // step 3.
        names.forEach(System.out::println);
    }
}
