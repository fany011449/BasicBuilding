package com.dell.regexText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTextSpider {
    public RegexTextSpider() {
    }

    public static void main(String[] args) {
        spider();
    }

    public static void spider() {
        String data = "加油努力繼續下去Java, \n       電話：0908910944, 0908910911\n       信箱：bonib@itcast.com.tw, \n       家電：0424223278, 04-154478941\n       信箱：donif@gmail.com, \n       信箱：doSSSf11@gmail.com, \n       熱線電話：400-156-1580, 100-550-9150, 0800-168-1688";
        String regex = "(09[0-9]\\d{8})|(04-?[0-9]\\d{8,})|(\\w{2,}@\\w{2,10}(\\.\\w{2,10}){1,2})|(\\d{3,7}-?\\d{3,7}-?\\d{3,7})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);

        while(matcher.find()) {
            String rs = matcher.group();
            System.out.println(rs);
        }

    }
}
