package com.dell.Demo;

import java.util.List;

public class PeopleGetRedPacket extends Thread {
    private static boolean hasPrintedEnd = false;
    private List<Integer> redPacket;

    public PeopleGetRedPacket(List<Integer> redPacket, String name) {
        super(name);
        this.redPacket = redPacket;
    }

    @Override
    public void run() {
        // 取每個線程名字
        String name = Thread.currentThread().getName();
        // 100個人來搶redPacket集合中的錢
        // 因多線程搶同一個集合，故需做線程安全處理，要加synchronized塊
        // 因為搶完一個紅包後，該線程有權繼續搶第二個，故需要使用死循環
        while (true) {
            synchronized(redPacket){
                if(redPacket.size() == 0){
                    if(!hasPrintedEnd){
                        hasPrintedEnd = true;
                        System.out.println("紅包搶完了！活動結束");
                    }

                    break;
                }
                // 隨機產生一個索引來取得紅包
                int index = (int)(Math.random() * redPacket.size());
                // 搶到後，將此金額從紅包集合中刪除
                Integer money = redPacket.remove(index);
                System.out.println(name + "搶到了" + money + "元");
            }
        }

    }
}
