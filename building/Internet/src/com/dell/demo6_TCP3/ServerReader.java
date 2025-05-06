package com.dell.demo6_TCP3;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerReader extends Thread {
private Socket socket;
    public ServerReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 讀取管道的消息
            // 3. 獲取字節輸入流，要與輸出流完全相同類型!
            InputStream is = socket.getInputStream();
            // 4. 包裝成高級輸入流：特殊數據輸入流
            DataInputStream data = new DataInputStream(is);
            while (true) {
                int id = data.readInt();
                String msg = data.readUTF();
                System.out.println("ID： " + id + " Message： " + msg);

                // 5. 客戶端的IP以及端口
                System.out.println(socket.getInetAddress().getHostAddress());
                System.out.println(socket.getPort());
                System.out.println("---------------");
            }
        } catch (Exception e) {
            System.out.println("用戶 " + socket.getInetAddress().getHostAddress() +
                    " 下線了");
        }
    }
}
