package com.variety.shop.indi.design.pattern.adapter;

/**
 * 我在nba，只能实例化NBA的球员，但我不久前还是一个cba球员，我不会英语，我该怎么办？找个翻译（适配器）
 *
 * Created by rongbin.xie on 2017/11/13.
 */
public class AmericanClient {
    public static void main(String[] args) {
        System.out.println("我是周琦，我在NBA，但是我不懂英语，我无法改变环境，" +
                "现在英语也不好！我需要一个适配器（翻译，告诉我要干什么）");
        IUSABPlayer zq = new Adapter();
        zq.train();
        zq.play();
        zq.rest();
    }
}
