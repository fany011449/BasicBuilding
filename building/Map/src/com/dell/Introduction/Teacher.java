package com.dell.Introduction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

// 1. 對象類實現一個Comparable比較接口，重寫compareTo方法，制定大小比較規則
public class Teacher implements Comparable<Teacher> {
    private String name;
    private int age;
    private double salary;

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}' + "\n";
    }

    // 1. 對象類實現一個Comparable比較接口，重寫compareTo方法，制定大小比較規則
    /* t2.compareTo(t1)
       t2 == this 比較者
       t1 == o 被比較者
       規則一：如果左邊 > 右邊，返回正整數
       規則二：如果左邊 < 右邊，返回負整數
       規則三：如果左邊 = 右邊，返回0
     */
    @Override
    public int compareTo(Teacher o) {
        // 以年齡升序
//        if (this.getAge() > o.getAge()) return 1;
//        if (this.getAge() < o.getAge()) return -1;
//        return 0; // 去重
//        return 1;

        return this.getAge() - o.getAge();
    }
}
