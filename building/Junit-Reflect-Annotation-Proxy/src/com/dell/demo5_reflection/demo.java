package com.dell.demo5_reflection;

public class demo {
    public static void main(String[] args) throws Exception {
        Teacher teacher = new Teacher("王", 23, 10000.0, "address");
        SaveObjectFrameWork.saveObject(teacher);

        Student student = new Student("陳", 11, "address", 3);
        SaveObjectFrameWork.saveObject(student);

    }
}
