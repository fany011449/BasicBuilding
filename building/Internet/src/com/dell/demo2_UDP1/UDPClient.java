package com.dell.demo2_UDP1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        System.out.println("客戶端啟動----------------");
        // 目標：完成UDP通信(一發一收)
        // 客戶端開發

        // 1. 創建Client端對象
        DatagramSocket socket = new DatagramSocket();

        // 2. 創建數據包對象，封裝要發送的數據
        byte[] bytes = "我是客戶端".getBytes();

        /**
         *
         *   public DatagramPacket(byte[] buf, int length, InetAddress address, int port)
         * 參數一：發送的數據
         * 餐數二：發送的字節長度
         * 參數三︰目的地的IP地址
         * 參數四：服務端程序的端口號
         */
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8080);

        // 3. 發送數據
        socket.send(packet);

        socket.close();
    }
}
