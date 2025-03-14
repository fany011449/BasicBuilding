package com.dell.Demo;

/*
 * 需求：
 * 　　１．創建電影對象
 *    ２．創建一個電影操作對象：專門負責電影數據進行業務處理（上架、下架、查詢、封殺）
 *    ３．準備操作介面
 *    ４．準備一個集合容器：存儲全部上架的電影
 */
public class Test {
    public static void main(String[] args) {
        MovieService movieService = new MovieService();
        movieService.start();
    }
}
