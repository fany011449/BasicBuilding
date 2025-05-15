package com.dell.demo6_annotation;

@A(name = "Dell", age = 18, address = {"111", "2222"})
@B("delete")
public class Introduction {

    @A(name = "Angela", address = {"a"})
    public static void main( @B("delete") String[] args) {

    }
}
