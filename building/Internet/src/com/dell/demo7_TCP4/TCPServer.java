package com.dell.demo7_TCP4;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        System.out.println("Server端啟動");
        // 目標：BS架構的原理理解
        // 伺服器開發

        // 1. 創建Server對象，綁定端口
        ServerSocket ss = new ServerSocket(8080);

        // 3. 創建線程池
        /*
            因為網頁無法一個請求，就產生一個子線程。
            會把伺服器內存給撐爆
         */
        ExecutorService pool = new ThreadPoolExecutor(3, 10, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        while (true) {
            // 2. 調用accept()方法，阻塞等待Client端連接，一旦有客戶端連接會返回一個Socket對象
            Socket socket = ss.accept();
            System.out.println("一個用戶上線了： " + socket.getInetAddress().getHostAddress());

            // 3. 把Client端管道包裝成一個任務提交給線程池做處理
            pool.execute(new ServerReader(socket));
        }
    }
}
