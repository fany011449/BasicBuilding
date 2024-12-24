package com.dell.Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        Student[] students = new Student[4];
        students[0] = new Student("孫悟空", (double)199.0F, 18);
        students[1] = new Student("豬八戒", (double)166.0F, 55);
        students[2] = new Student("沙悟淨", (double)187.0F, 30);
        students[3] = new Student("唐僧", (double)180.0F, 20);
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
        Arrays.sort(students, new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                return Double.compare(o2.getHeight(), o1.getHeight());
            }
        });
    }
}
