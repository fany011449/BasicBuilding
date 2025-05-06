package com.dell.demo1_InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Introduction {
    public static void main(String[] args) {
        // 目標：認識InetAddress獲取本機IP與對方IP對象
        try {
            // 1. 獲取本機IP對象
            InetAddress ip1 = InetAddress.getLocalHost();
            System.out.println(ip1);

            // 2. 獲取對方IP對象
            InetAddress ip2 = InetAddress.getByName("www.google.com");
            System.out.println(ip2);

            // 3. 獲取對方IP對象
            InetAddress ip3 = InetAddress.getByName("192.168.1.1");
            System.out.println(ip3);

            // 4. 判斷本機與對方主機是否相通, 5秒內
            System.out.println(ip2.isReachable(5000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
