package com.dell.Additional;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataOutputStreamDemo {
    public static void main(String[] args) {
        // 目標：特殊輸入/出流的用法
        try (
                DataInputStream dis = new DataInputStream(new FileInputStream("D:\\develop\\Code\\building\\File-IO\\src\\dos.txt"))
        ) {
            System.out.println(dis.readUTF());
            System.out.println(dis.readByte());
            System.out.println(dis.readInt());
            System.out.println(dis.readBoolean());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
