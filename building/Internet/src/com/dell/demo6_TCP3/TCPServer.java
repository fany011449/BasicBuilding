package com.dell.demo6_TCP3;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        System.out.println("Server端啟動");
        // 目標：完成TCP通信(多發多收)
        // 伺服器開發

        // 1. 創建Server對象，綁定端口
        ServerSocket ss = new ServerSocket(8080);

        while (true) {
            // 2. 調用accept()方法，阻塞等待Client端連接，一旦有客戶端連接會返回一個Socket對象
            Socket socket = ss.accept();
            System.out.println("一個用戶上線了： " + socket.getInetAddress().getHostAddress());

            // 3. 把這個客戶端管道，交給一個獨立的子線程專門負責接收這個管道的
            new ServerReader(socket).start();
        }
    }
}
