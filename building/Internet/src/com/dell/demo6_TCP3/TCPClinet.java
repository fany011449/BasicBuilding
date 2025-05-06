package com.dell.demo6_TCP3;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClinet {
    public static void main(String[] args) throws Exception {
        System.out.println("Client端啟動");
        // 目標：完成TCP通信(多發多收)
        // 客戶端開發

        // 1. 創建Client端對象
        // 參數1. 目的地IP
        // 參數1. 端口
        Socket socket = new Socket("127.0.0.1", 8080);

        // 2. 從Socket通信管道中，獲取一個字節輸出流
        OutputStream os = socket.getOutputStream();

        // 3. 將字節輸出流包裝成：高級字節輸出流-特殊數據流
        DataOutputStream data = new DataOutputStream(os);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("請輸入：");
            String s = sc.nextLine();
            if("exit".equals(s)){
                System.out.println("退出成功");
                // 4. 關閉資源
                socket.close();
                break;
            }

            data.writeInt(1);
            data.writeUTF(s);

            // 更新輸出流資料，讓內存中的資料跑完
            data.flush();
        }
    }
}
