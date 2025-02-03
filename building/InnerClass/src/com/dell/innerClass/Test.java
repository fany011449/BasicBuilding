package com.dell.innerClass;

/*
    目標：成員內部類的語法
 */
public class Test {
    public static void main(String[] args) {
        // 成員內部類創建對象的語法
        // 外部類名稱.成員內部類名稱 objectName = new 外部類名稱().成員內部類名稱();
        Outer.Inner innerObject = new Outer().new Inner();
        innerObject.show();

        // 面試題目答案
        People.Heart heart = new People().new Heart();
        heart.beat();
    }
}

/*
    面試題目：
    1. 請問以下程式碼的執行結果為何？
 */

class People {
    private int heartbeats = 100;

    public class Heart {
        private int heartbeats = 50;

        public void beat() {
            int heartbeats = 10;
            System.out.println(heartbeats); // 10
            System.out.println(this.heartbeats); // 50
            System.out.println(People.this.heartbeats); // 100
        }
    }
}