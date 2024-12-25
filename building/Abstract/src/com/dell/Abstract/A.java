package com.dell.Abstract;

/*
    抽象類：
        必須使用abstract
        不能擁有方法體
        只能有方法簽名
 */
public abstract class A {
    private String name;
    private static String SchoolName;

    public A() {
    }

    public A(String name) {
        this.name = name;
    }

    // 抽象方法：必須要用abstract修飾，只有方法簽名，不能有方法體!
    public abstract void run();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getSchoolName() {
        return SchoolName;
    }

    public static void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }
}
