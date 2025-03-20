package com.dell.Set;

import java.util.Objects;

public class Student {
  private String name;
  private int age;
  private String address;
  private String phone;

    public Student() {
    }

    public Student(String name, int age, String address, String phone) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // 只要兩對象的內容一樣，結果一定是true
    // s3.equal(s1)
    @Override
    public boolean equals(Object o) {
        // 1. 如果o為空 或 不是Student類型，直接返回false
        if (o == null || this.getClass() != o.getClass()) return false;
        // 2.比較兩個對象的內容是否相同
        Student student = (Student) o;
        return this.age == student.age && Objects.equals(name, student.name) && Objects.equals(address, student.address) && Objects.equals(phone, student.phone);
    }

    @Override
    public int hashCode() {
        // 包裝了不同學生對象，如果內容一樣返回的哈希值一定是一樣的。
        return Objects.hash(name, age, address, phone);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}' + "\n";
    }


}
