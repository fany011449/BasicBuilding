package com.dell.Arrays;

public class Student implements Comparable<Student> {
    private String name;
    private double height;
    private int age;

    public int compareTo(Student o) {
        return this.age - o.age;
    }

    public String toString() {
        return "Student{name='" + this.name + "', height=" + this.height + ", age=" + this.age + "}";
    }

    public Student() {
    }

    public Student(String name, double height, int age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
