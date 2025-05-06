package com.dell.demo5_TCP2;

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
        ServerSocket socket = new ServerSocket(8080);

        // 2. 等待Client端連接
        Socket s = socket.accept();

        // 3. 獲取字節輸入流，要與輸出流完全相同類型!
        InputStream is = s.getInputStream();
        // 4. 包裝成高級輸入流：特殊數據輸入流
        DataInputStream data = new DataInputStream(is);
        while (true) {
            int id = data.readInt();
            String msg = data.readUTF();
            System.out.println("ID： " + id + " Message： " + msg);

            // 5. 客戶端的IP以及端口
            System.out.println(s.getInetAddress().getHostAddress());
            System.out.println(s.getPort());
            System.out.println("---------------");
        }
    }
}
