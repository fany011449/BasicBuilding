package com.dell.demo7_TCP4;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ServerReader extends Thread {
private Socket socket;
    public ServerReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 給當前的瀏覽器管道響應一個網頁數據回去
            OutputStream os = socket.getOutputStream();
            // 通過字節輸出流，包裝寫出去數據給瀏覽器
            /**
             * 需要變成以下格式：(每行都要\r\n)
             * HTTP/1.1 200 OK
             * Content-Type:text/html;charset=utf-8
             * 【在網頁正文之前要單獨一個 \r\n】
             *  正文
             */
            // 把字節輸出流包裝成打印流(因為每行都要換行，更適合打印流)
            PrintStream ps = new PrintStream(os);
            // 寫響應的網頁數據出去
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=utf-8");
            ps.println(); // 換行
            // 正文開始
            ps.println("<html>");
            ps.println("<head>");
            ps.println("<meta charset='utf-8'>");
            ps.println("<title>");
            ps.println("DELL初來乍到");
            ps.println("</title>");
            ps.println("</head>");
            ps.println("<body>");
            ps.println("<h1 style='color:red;font-size=20px'>DELL初來乍到</h1>");
            // 增加一張圖片
            ps.println("<img src='https://png.pngtree.com/png-vector/20221222/ourmid/pngtree-super-cute-cartoon-vector-bear-png-image_6504049.png'>");
            ps.println("</body>");
            ps.println("</html>");
            // 網頁的伺服器管道是可以做關閉節省資源的
            // 因為請求網頁是短連結，用戶一旦請求後內容出現就不需要server standby了
            ps.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("用戶 " + socket.getInetAddress().getHostAddress() +
                    " 下線了");
        }
    }
}
