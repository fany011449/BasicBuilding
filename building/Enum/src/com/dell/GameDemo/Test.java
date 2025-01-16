package com.dell.GameDemo;

public class Test {
    public static void main(String[] args) {
        // 目標: 掌握枚舉的應用場景，做信息的分類和標誌
        // 需求: 模擬上下左右移動的圖片
        // 第一種: 常量做信息標誌和分類; 缺點：參數值不受約束
        // 第二種: 枚舉做信息標誌和分類; 可約束參數值
        move(Constant.UP);
        move2(Direction.UP);
    }

    public static void move2(Direction direction) {
        // 根據這個方向做移動：上下左右
        switch (direction) {
            case Direction.UP:
                System.out.println("向上移動");
                break;
            case Direction.DOWN:
                System.out.println("向下移動");
                break;
            case Direction.LEFT:
                System.out.println("向左移動");
                break;
            case Direction.RIGHT:
                System.out.println("向右移動");
                break;
            default:
                System.out.println("非法操作");
        }
    }

    public static void move(int direction) {
        // 根據這個方向做移動：上下左右
        switch (direction) {
            case Constant.UP:
                System.out.println("向上移動");
                break;
            case Constant.DOWN:
                System.out.println("向下移動");
                break;
            case Constant.LEFT:
                System.out.println("向左移動");
                break;
            case Constant.RIGHT:
                System.out.println("向右移動");
                break;
            default:
                System.out.println("非法操作");
        }
    }
}
