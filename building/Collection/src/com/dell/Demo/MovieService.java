package com.dell.Demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieService {
    private static List<Movie> movies = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("=============電影信息操作系統===============");
            System.out.println("1. 上架");
            System.out.println("2. 下架某個電影");
            System.out.println("3. 查詢某個電影");
            System.out.println("4. 封殺某個明星");
            System.out.println("請您輸入命令：");
            String command = sc.next();
            switch(command) {
                // 【獨立功能，獨立成方法】
                case "1":
                    // 上架
                    addMovie();
                    break;
                case "2":
                    // 下架
                    removeMovie();
                    break;
                case "3":
                    // 查詢
                    queryMovie();
                    break;
                case "4":
                    // 封殺
                    deleteStar();
                    break;
                case "exit":
                    // 退出
                    System.out.println("退出成功");
                    return;
                default:
                    System.out.println("命令錯誤");
                    break;
            }
        }
    }

    /**
     * 封殺某個明星
     */
    private void deleteStar() {
        System.out.println("-================封殺明星================");
        System.out.println("輸入你要封殺的明星名字：");
        String name = sc.next();

        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            if(movie.getName().contains(name)){
                movies.remove(movie);
                System.out.println("封殺成功");
                i--; // 避免"併發修改異常"
            }
        }
    }

    /**
     * 查詢某部電影，並將其下架
     */
    private void removeMovie() {
        System.out.println("-================下架電影================");
        System.out.println("請輸入您要刪除的電影：");
        String name = sc.next();
        Movie theMovie = queryMovieByName(name);

        if(theMovie != null){
            movies.remove(theMovie);
        } else {
            System.out.println("並無此電影");
        }
    }

    /**
     * 根據電影名稱查詢某部電影，並展示
     */
    private void queryMovie() {
        System.out.println("-================查詢電影================");
        System.out.println("輸入電影名稱：");
        String name = sc.next();
        // 根據電影名稱查詢電影對象返回，展示這個對象數據。
        Movie theMovie = queryMovieByName(name);
        if(theMovie == null){
            System.out.println("查無此電影!");
        } else {
            System.out.println(theMovie.getName());
            System.out.println(theMovie.getActor());
            System.out.println(theMovie.getPrice());
            System.out.println(theMovie.getScore());
        }
    }

    /**
     * 根據電影名稱查詢電影對象返回
     * @param name
     * @return
     */
    private Movie queryMovieByName(String name){
        for (Movie movie : movies){
            if(movie.getName().equals(name)){
               return movie;
            }
        }
        return null;
    }

    /**
     * 上架電影
     */
    private void addMovie() {
        System.out.println("-================上架電影================");
        // 每點擊一次上架電影，就是新增一個電影。每部電影是一個電影對象封裝數據的

        // 1. 創建電影對象，封裝這部電影信息
        Movie movie = new Movie();

        // 2. 給電影對象注入數據
        System.out.println("請輸入電影名稱：");
        movie.setName(sc.next());
        System.out.println("請輸入電影主演：");
        movie.setActor(sc.next());
        System.out.println("請輸入電影價格：");
        movie.setPrice(sc.nextDouble());
        System.out.println("請輸入電影評分：");
        movie.setScore(sc.nextDouble());

        // 3. 把電影對象添加到集合中
        movies.add(movie);
        System.out.println("上架完成");
    }
}
