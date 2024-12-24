package com.dell.regexText;

import java.util.Arrays;

public class RegexInduction {
    public RegexInduction() {
    }

    public static void main(String[] args) {
        System.out.println("a".matches("[abc]"));
        System.out.println("d".matches("[^abc]"));
        System.out.println("b".matches("[a-zA-z]"));
        System.out.println("2".matches("[a-z&&[^bc]]"));
        System.out.println("ab".matches("[a-zA-Z0-9]]"));
        System.out.println("徐".matches("."));
        System.out.println("1".matches("\\d"));
        System.out.println("1".matches("\\D"));
        System.out.println(" ".matches("\\s"));
        System.out.println("2".matches("\\S"));
        System.out.println("2".matches("\\w"));
        System.out.println("陳".matches("\\W"));
        System.out.println("2".matches("\\w?"));
        System.out.println("221321".matches("\\w*"));
        System.out.println("2".matches("\\w+"));
        System.out.println("2a1".matches("\\w{3}"));
        System.out.println("2111111".matches("\\w{3,}"));
        System.out.println("2111111".matches("\\w{3,9}"));
        System.out.println("ABC".matches("(?i)abc"));
        System.out.println("avc".matches("//d{3}|[a-z]{3}"));
        System.out.println("<-------------------");
        System.out.println("我愛程式程式666666".matches("我愛(程式)+(666)+"));
        String s1 = "路人甲Asdas11路人乙sd111d885路人丙456ss";
        System.out.println(s1.replaceAll("\\w+", "-"));
        String s2 = "我愛程程程程式式式式";
        System.out.println(s2.replaceAll("(.)\\1+", "$1"));
        String[] s3 = s1.split("\\w+");
        System.out.println(Arrays.toString(s3));
    }
}
