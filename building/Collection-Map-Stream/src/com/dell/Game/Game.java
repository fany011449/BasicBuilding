package com.dell.Game;

public class Game {
    public static void main(String[] args) {
        // 目標：開發鬥地主遊戲
        // 1. 每一張牌都是一個對象，定義牌class
        // 2. 遊戲房間也會是一個對象，定義房間類
        Room r = new Room();
        r.start();
    }
}
