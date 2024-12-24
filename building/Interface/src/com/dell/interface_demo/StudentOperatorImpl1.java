package com.dell.interface_demo;

import java.io.PrintStream;
import java.util.ArrayList;

public class StudentOperatorImpl1 implements StudentOperator {
    public StudentOperatorImpl1() {
    }

    public void printAllInfo(ArrayList<Student> students) {
        System.out.println("------------------全班學生信息如下：--------------------");

        for(int i = 0; i < students.size(); ++i) {
            Student s1 = (Student)students.get(i);
            System.out.println("學生姓名：" + s1.getName());
            System.out.println("學生性別：" + s1.getSex());
            System.out.println("學生成績：" + s1.getScore());
            System.out.println("--------------------------------------");
        }

    }

    public void printScore(ArrayList<Student> students) {
        double averageScore = (double)0.0F;
        double num = (double)0.0F;

        for(int i = 0; i < students.size(); ++i) {
            Student s = (Student)students.get(i);
            averageScore += s.getScore();
        }

        PrintStream var10000 = System.out;
        double var10001 = averageScore / (double)students.size();
        var10000.println("全班平均分數：" + var10001);
    }
}
