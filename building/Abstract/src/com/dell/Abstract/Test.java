package com.dell.Abstract;

/*
    目標：認識抽象類和其特點
    抽象類目的： 子類繼承抽象父類，來重寫抽象方法實現
    抽象方法能夠更好的支持多態
 */
public class Test {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.cry();
    }
}
