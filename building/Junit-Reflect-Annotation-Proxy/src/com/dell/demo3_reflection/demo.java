package com.dell.demo3_reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class demo {

    // 1. 獲取類的對象
    @Test
    public void getClassInformation(){
        Class c1 = Student.class;

        // 取類的全名
        // com.dell.demo3_reflection.Student
        System.out.println(c1.getName());

        // 取類的名字
        // Student
        System.out.println(c1.getSimpleName());
    }

    // 2. 獲取類的構造器對象且操作之。
    @Test
    public void getConstructorsInfo() throws Exception {
        // 1. 取得類對象
        Class c2 = Student.class;

        // 2. 獲取構造器對象
        // 有Declared就是只要構造器存在就能拿來用
        Constructor[] constructors = c2.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName() + "(" + constructor.getParameterCount() + ")");
        }

        // 3. 獲取單個構造器
        Constructor constructor = c2.getDeclaredConstructor();
        System.out.println(constructor.getName() + "(" + constructor.getParameterCount() + ")");

        Constructor constructor1 = c2.getDeclaredConstructor(String.class, int.class); // 後面接的是參數的意思
        System.out.println(constructor1.getName() + "(" + constructor1.getParameterCount() + ")");

        // 4. 獲取構造器的作用依然是創建對象
        // 【暴力反射】：可以訪問私有的構造器、方法、屬性
        constructor.setAccessible(true); // 繞過權限，可以直接訪問私有private
        Student s1 = (Student) constructor.newInstance();
        System.out.println(s1);

        Student s2 = (Student) constructor1.newInstance("dell", 12);
        System.out.println(s2);
    }

    // 3. 獲取類的【成員變量】對象並對其進行操作
    @Test
    public void getFieldInfo() throws Exception {
        Class c1 = Student.class;

        Field[] fields = c1.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getName() + "(" + field.getType().getName() + ")");
        }

        Field field = c1.getDeclaredField("name");
        System.out.println(field.getName() + "(" + field.getType().getName() + ")");

        Field field1 = c1.getDeclaredField("name");
        System.out.println(field1.getName() + "(" + field1.getType().getName() + ")");

        // 4. 獲取成員變量的目的依舊是 取值 & 賦值
        Student s = new Student();
        field.setAccessible(true); // 繞過訪問，直接訪問
        field.set(s, "yoyo");
        System.out.println(s);
    }

    // 4. 獲取類的【方法】對象並對其進行操作
    @Test
    public void getMethodInfo() throws Exception {
        Class c1 = Student.class;

        Method[] methods = c1.getDeclaredMethods();
        for(Method method : methods){
            System.out.println(method.getName() + "(" + method.getParameterCount() + ")");
        }

        Method m =  c1.getDeclaredMethod("eat");
        System.out.println(m.getName() + "(" + m.getParameterCount() + ")");

        Method m1 =  c1.getDeclaredMethod("sleep", String.class);
        System.out.println(m1.getName() + "(" + m1.getParameterCount() + ")");

        // 獲取成員方法的目的依然是 調用方法
        Student s = new Student();
        m.setAccessible(true); // 暴力反射
        Object o = m.invoke(s);// 喚醒對象s的eat執行。等同s.eat()
        System.out.println(o); // o 代表是返回值
    }
}
