package com.dell.method_references;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        Student[] students = new Student[4];
        students[0] = new Student("孫悟空", (double)199.0F, 18);
        students[1] = new Student("豬八戒", (double)166.0F, 55);
        students[2] = new Student("沙悟淨", (double)187.0F, 30);
        students[3] = new Student("唐僧", (double)180.0F, 20);
        Arrays.sort(students, new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        Arrays.sort(students, (o1, o2) -> o1.getAge() - o2.getAge());
        Arrays.sort(students, (o1, o2) -> CompareByData.compareByAge(o1, o2));
        Arrays.sort(students, CompareByData::compareByAge);
        Arrays.sort(students, (o1, o2) -> o2.getAge() - o1.getAge());
        CompareByData compare = new CompareByData();
        Arrays.sort(students, (o1, o2) -> compare.compareByAgeDesc(o1, o2));
        Objects.requireNonNull(compare);
        Arrays.sort(students, compare::compareByAgeDesc);
        String[] names = new String[]{"Json", "Body", "Bruh", "Dell", "Hunter", "Caoo", "Angela"};
        Arrays.sort(names);
        System.out.println(Arrays.toString(names));
    }
}
