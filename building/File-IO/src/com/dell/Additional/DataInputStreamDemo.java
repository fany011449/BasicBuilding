package com.dell.Additional;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataInputStreamDemo {
    public static void main(String[] args) {
        // 目標：特殊輸入/出流的用法
        try (
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("D:\\develop\\Code\\building\\File-IO\\src\\dos.txt"))
        ) {
            dos.writeUTF("嗨");
            dos.writeByte(97);
            dos.writeInt(11);
            dos.writeBoolean(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
