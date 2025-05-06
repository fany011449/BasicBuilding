package com.dell.demo2_Performance;

public class Description {
    public static void main(String[] args) {
        // 目標：高效拼接字串
        // 使用 "+" 來拼接字串會導致大量內存分配，因為 String 是不可變的，每次拼接都會創建新對象
        // String 的「共享數據效能好」，主要指的是它的字符串池機制（String Interning），可以有效減少重複字符串的內存開銷。，但 "修改數據性能"差
        String s = "";
        for (int i = 0; i < 100000; i++) {
            s += "abc";
        }

        System.out.println(s);

        //------------------------------------------------------------------------------------------------------
        System.out.println("------------------------------------------------------------------------------------------------------");
        //------------------------------------------------------------------------------------------------------

        // StringBuilder 它是可變的，可以有效降低內存分配次數，提升效率。
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
//            sb.append("abc");
            // 支持鏈式編程
            sb.append("a").append("b").append("c");
        }

        // 結論：
        // String類型：定義字符串
        // StringBuilder：操作字符串。

        // 但通常都會StringBuilder操作完，需要轉成String
        // 因為多個API要求都會是String，而不是StringBuilder
        String string = sb.toString();
    }
}
