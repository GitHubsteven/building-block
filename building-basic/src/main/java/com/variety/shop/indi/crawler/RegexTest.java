package com.variety.shop.indi.crawler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rongbin.xie on 2017/10/27.
 */
public class RegexTest {
    public static void main(String[] args) {
        // 定义一个样式模板，此中使用正则表达式，括号中是要抓的内容
        // 相当于埋好了陷阱匹配的地方就会掉下去
        Pattern pattern = Pattern.compile("href=\"(.+?)\"");
        // 定义一个matcher用来做匹配
        Matcher matcher = pattern.matcher("＜a href=\"index.html\"＞我的主页＜/a＞");
        // 如果找到了
        if (matcher.find()) {
            // 打印出结果
            System.out.println(matcher.group(1));
        }
    }
}
