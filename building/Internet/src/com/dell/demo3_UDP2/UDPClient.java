package com.dell.demo3_UDP2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        System.out.println("客戶端啟動----------------");
        // 目標：完成UDP通信(多發多收)
        // 客戶端開發

        // 1. 創建Client端對象
        DatagramSocket socket = new DatagramSocket();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("請輸入：");
            String data = sc.nextLine();

            if ("exit".equals(data)) {
                System.out.println("退出客戶端");
                socket.close();
                break;
            }

            // 2. 創建數據包對象，封裝要發送的數據
            byte[] bytes = data.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length,
                    InetAddress.getLocalHost(), 8080);

            // 3. 發送數據
            socket.send(packet);
        }
    }
}
