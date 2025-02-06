package com.dell.privateInnerClass;

public class Test {
    public static void main(String[] args) {
        // 目標：認識匿名內部類
        // 正常方式：
        Animal animal = new Cat();
        animal.eat();
        // 匿名內部類：
        // 匿名內部類new出來即是一個子類對象，並且可以實現抽象方法
        Animal animal2 = new Animal() {
            @Override
            public void eat() {
                System.out.println("Animal is eating");
            }
        };
        animal2.eat();
    }
}

class Cat extends Animal {

    @Override
    public void eat() {
        System.out.println("Cat is eating");
    };
}