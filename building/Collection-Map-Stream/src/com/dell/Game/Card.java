package com.dell.Game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Card {
    private String size; // 點數
    private String color; // 花色
    private int weight; // 權重。鬥地主不看花色

    @Override
    public String toString() {
        return size + color;
    }
}
