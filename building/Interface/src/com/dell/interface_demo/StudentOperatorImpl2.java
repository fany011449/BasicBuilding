package com.dell.interface_demo;

import java.io.PrintStream;
import java.util.ArrayList;

public class StudentOperatorImpl2 implements StudentOperator {
    public StudentOperatorImpl2() {
    }

    public void printAllInfo(ArrayList<Student> students) {
        int maleCounter = 0;
        int femaleCounter = 0;
        System.out.println("------------------全班學生信息如下：--------------------");

        for(int i = 0; i < students.size(); ++i) {
            Student s1 = (Student)students.get(i);
            System.out.println("學生姓名：" + s1.getName());
            System.out.println("學生性別：" + s1.getSex());
            System.out.println("學生成績：" + s1.getScore());
            System.out.println("--------------------------------------");
            if (s1.getSex() == 30007) {
                ++maleCounter;
            } else if (s1.getSex() == 22899) {
                ++femaleCounter;
            }
        }

        System.out.println("男生總數：" + maleCounter + " , 女生總數：" + femaleCounter);
    }

    public void printScore(ArrayList<Student> students) {
        double averageScore = (double)0.0F;
        double max = ((Student)students.get(0)).getScore();
        double min = ((Student)students.get(0)).getScore();

        for(int i = 0; i < students.size(); ++i) {
            Student s = (Student)students.get(i);
            if (s.getScore() > max) {
                max = s.getScore();
            }

            if (s.getScore() < min) {
                min = s.getScore();
            }

            averageScore += s.getScore();
        }

        PrintStream var10000 = System.out;
        double var10001 = (averageScore - max - min) / (double)students.size();
        var10000.println("全班平均分數：" + (var10001 - (double)2.0F));
    }
}
