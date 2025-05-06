package com.dell.demo4_TCP1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClinet {
    public static void main(String[] args) throws Exception {
        System.out.println("Client端啟動");
        // 目標：完成TCP通信(一發一收)
        // 客戶端開發

        // 1. 創建Client端對象
        // 參數1. 目的地IP
        // 參數1. 端口
        Socket socket = new Socket("127.0.0.1", 8080);

        // 2. 從Socket通信管道中，獲取一個字節輸出流
        OutputStream os = socket.getOutputStream();

        // 3. 將字節輸出流包裝成：高級字節輸出流-特殊數據流
        DataOutputStream data = new DataOutputStream(os);
        data.writeInt(1);
        data.writeUTF("我是陳典佑");

        // 4. 關閉資源
        socket.close();
    }
}
