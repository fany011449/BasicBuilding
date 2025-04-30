package com.dell.Demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        // 需求： 搶紅包
        // 某企業有100名員工，員工的工號依次是1,2,3,4,5,. . .到 100
        // 現在公司舉辦了年會活動，活動中有一個紅包雨環節，要求共計發出200個紅包雨。
        // 其中小紅包在[1 ~ 30]元之間 總站比為80%，大紅包[31 ~ 100]元，總佔比為20%。

        // 分析：100個員工實際上就是100個線程，來共同競爭200個紅包
        List<Integer> redPacket = getRedPacket();
        // 2. 定義線程類，創建100個線程競爭同一個集合
        for (int i = 1; i <= 100; i++) {
            new PeopleGetRedPacket(redPacket, "人" + i).start();
        }
    }

    // 1. 準備200個隨機的紅包返回。放到List集合中去返回
    public static List<Integer> getRedPacket() {
        Random r = new Random();
        // 其中小紅包在[1 ~ 30]元之間 總站比為80%，大紅包[31 ~ 100]元，總佔比為20%。
        List<Integer> redPacket = new ArrayList<>();

        // [1 ~ 30]
        for (int i = 1; i <= 160; i++) {
            redPacket.add(r.nextInt(30) + 1);
        }

        // [31 ~ 100]
        for (int i = 1; i <= 40; i++) {
            redPacket.add(r.nextInt(70) + 31);
        }

        return redPacket;
    }
}
