package com.dell.demo3_UDP2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        System.out.println("伺服器啟動----------------");
        // 目標：完成UDP通信(多發多收)
        // 伺服器端開發

        // 1. 創建Server端對象，註冊端口
        DatagramSocket socket = new DatagramSocket(8080);

        // 2. 創建一個數據包對象，負責接收數據
        byte[] bytes = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

        while (true) {
            // 3. 阻塞式接收數據
            socket.receive(packet);

            // 4. 查看數據
            // 查看數據長度，依照此長度展示數據
            int length = packet.getLength();
            // 0 -> length長度
            String data = new String(bytes, 0, length);
            System.out.println(data);

            // 獲取對方IP
            String ip = packet.getAddress().getHostAddress();
            int port = packet.getPort();
            System.out.println("對方ip： " + ip + " 對方端口： " + port);
            System.out.println("===============================");
        }

    }
}
