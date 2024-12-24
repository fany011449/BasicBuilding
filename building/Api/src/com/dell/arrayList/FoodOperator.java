package com.dell.arrayList;


import java.util.ArrayList;
import java.util.Scanner;

public class FoodOperator {
    private ArrayList<Food> foodList = new ArrayList();

    public FoodOperator() {
    }

    public void addFood() {
        Food f = new Food();
        Scanner sc = new Scanner(System.in);
        System.out.println("請輸入該菜品名稱：");
        String name = sc.next();
        f.setName(name);
        System.out.println("請輸入該菜品價格：");
        double price = sc.nextDouble();
        f.setPrice(price);
        System.out.println("請輸入該菜品描述：");
        String desc = sc.next();
        f.setDesc(desc);
        this.foodList.add(f);
        System.out.println("商品上架成功");
    }

    public void showAllFoods() {
        if (this.foodList.size() == 0) {
            System.out.println("商品為零");
        } else {
            for(int i = 0; i < this.foodList.size(); ++i) {
                Food f = (Food)this.foodList.get(i);
                System.out.println(f.getName());
                System.out.println(f.getPrice());
                System.out.println(f.getDesc());
                System.out.println("===============");
            }

        }
    }

    public void start() {
        while(true) {
            System.out.println("請選擇功能：");
            System.out.println("1. 上架菜品");
            System.out.println("2. 展示菜品");
            System.out.println("3. 退出");
            Scanner sc = new Scanner(System.in);
            System.out.println("請選擇您的操作：");
            switch (sc.next()) {
                case "1":
                    this.addFood();
                    break;
                case "2":
                    this.showAllFoods();
                    break;
                case "3":
                    System.out.println("退出系統");
                    return;
                default:
                    System.out.println("非法操作");
            }
        }
    }
}
