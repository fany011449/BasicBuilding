package com.dell.demo5_reflection;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class SaveObjectFrameWork {

    public static void saveObject(Object o) throws Exception {
        // 只有反射能夠知道class會有多少個成員變量

        // 使用打印輸出流，將讀取到的Data傳到data.txt文本中
        PrintStream ps = new PrintStream(new FileOutputStream("D:\\develop\\Code\\building\\Junit-Reflect-Annotation-Proxy\\src\\com\\dell\\demo5_reflection\\data.txt", true));
        Class c1 = o.getClass();
        ps.println("========="+ c1.getSimpleName() +"===========");
        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // 暴力反射，繞過權限
            ps.println(field.getName() + " = " + field.get(o));
        }

        ps.close();
    }
}
