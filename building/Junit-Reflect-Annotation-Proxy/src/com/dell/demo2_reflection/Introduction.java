package com.dell.demo2_reflection;

public class Introduction {
    public static void main(String[] args) throws Exception {
        // 目標：掌握reflection
        // 1. 類.class
        Class c1 = Student.class;

        // 2. forName("類的全名")
        Class c2 = Class.forName("com.dell.demo2_reflection.Student");

        // 3. getClass()
        Student s = new Student();
        Class c3 = s.getClass();

    }
}
