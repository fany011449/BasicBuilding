package com.dell.List;

import java.util.LinkedList;

/**
 * 目標：學習LinkedList。
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        // 需求：設計排隊系統
        // "先進先出、後進後出" 原則。 使用LinkedList只在首尾做增刪
        LinkedList<String> queue = new LinkedList<>();

        // 入隊
        queue.addLast("aa");
        queue.addLast("bb");
        queue.addLast("cc");
        queue.addLast("dd");
        queue.addLast("ff");

        System.out.println(queue);

        // 出隊
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());

        System.out.println("---------------------------------------");
        // 需求2：設計一個棧 (彈夾原理)
        // "先進後出、後進先出"原則，也符合只對首尾增刪
        LinkedList<String> stack = new LinkedList<>();

        // push 進
        stack.addFirst("第一顆子彈");
        stack.addFirst("第二顆子彈");
        stack.addFirst("第三顆子彈");
        stack.addFirst("第四顆子彈");
        System.out.println(stack);

        //pop 出
        System.out.println(stack.removeFirst());
        System.out.println(stack.removeFirst());
    }
}
