package com.dell.interface_demo;

import java.util.ArrayList;

public class ClassManager {
    ArrayList<Student> students = new ArrayList();
    StudentOperator studentOperator = new StudentOperatorImpl2();

    public ClassManager() {
        this.students.add(new Student("安納", '女', (double)100.0F));
        this.students.add(new Student("阿努拉", '女', (double)42.0F));
        this.students.add(new Student("別", '男', (double)55.0F));
        this.students.add(new Student("安納尼", '女', (double)88.0F));
        this.students.add(new Student("安", '女', (double)90.0F));
    }

    public void printInfo() {
        this.studentOperator.printAllInfo(this.students);
    }

    public void printScore() {
        this.studentOperator.printScore(this.students);
    }
}
