package com.dell.Game;

import java.util.*;

public class Room {
    // 每當房間啟動時
    // 1. 準備好54張牌
    // 定義一個集合容器來裝54張牌
    private List<Card> allCards = new ArrayList<>();
    // 2. 初始化54張牌進入集合, 利用實例代碼塊，每創建一次對象，便執行一次
    {
        // 3. 初始化定義點數
        String[] sizes = {"3", "4" , "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        // 4. 初始化定義花色
        String[] colors = {"♦\uFE0F", "♥\uFE0F", "♠\uFE0F", "♣\uFE0F"};
        int weight = 0;
        // 5. 組合花色與點數給對象Card
        for (String size : sizes){
            weight++;
            for(String color : colors){
                Card card = new Card(size, color, weight);
                allCards.add(card);
            }
        }

        // 6. 加入鬼牌，有分大小王
        Collections.addAll(allCards, new Card("", "\uD83C\uDCCF", ++weight),new Card("", "\uD83C\uDCDF", ++weight));
        System.out.println("新牌：" + allCards);
    }

    public void start() {
        // 7. 洗牌，利用Collections工具類shuffle()
        Collections.shuffle(allCards);
        System.out.println("洗牌後：" + allCards);

        // 8. 發牌：定義三個玩家
        // A=【】 B=【】 C=【】
        // 人名=集合，兩者為一套，可以用map來當集合
        Map<String, List<Card>> players = new HashMap<>();

        List<Card> ACards = new ArrayList<>();
        players.put("A", ACards);

        List<Card> BCards = new ArrayList<>();
        players.put("B", BCards);

        List<Card> CCards = new ArrayList<>();
        players.put("C", CCards);

        // 9. 共54張牌做遍歷，且3張當底牌
        for (int i = 0; i < allCards.size() - 3; i++) {
            Card card = allCards.get(i);

            // 輪流發牌，所以要決定目前是誰，用餘數
            if(i % 3 == 0){
                ACards.add(card);
            } else if(i % 3 == 1){
                BCards.add(card);
            } else {
                CCards.add(card);
            }
        }

        // 10. 最後三張底牌，要給地主的
        // subList(a,b) 擷取 a -> b 之間的數組。取前不取後
        // 51 -> 54。所以擷取了【51, 52, 53】
        List<Card> lastCards = allCards.subList(allCards.size() - 3, allCards.size());

        // 搶地主，把這三張底牌給地主
        // ex A是地主
        ACards.addAll(lastCards);

        // 11. 對排排序
        sortCards(ACards);
        sortCards(BCards);
        sortCards(CCards);

        // 12. 看牌，遍歷map集合
        for (Map.Entry<String, List<Card>> entry : players.entrySet()){
            String name = entry.getKey();
            List<Card> cards = entry.getValue();
            System.out.println(name + "的牌是：" + cards);
        }
    }

    // 對排排序
    private void sortCards(List<Card> Cards) {
        Collections.sort(Cards, (o1, o2) -> o2.getWeight() - o1.getWeight());
    }
}
