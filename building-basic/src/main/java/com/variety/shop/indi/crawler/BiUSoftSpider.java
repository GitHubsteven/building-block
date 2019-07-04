package com.variety.shop.indi.crawler;

import java.io.IOException;

/**
 * Created by rongbin.xie on 2017/10/28.
 */
public class BiUSoftSpider {
    //    http://www.ubisoft.com.cn/
    public static void main(String[] args) {
        String biUrl = "http://store.ubi.com/cn/%E5%88%BA%E5%AE%A2%E4%BF%A1%E6%9D%A1%EF%BC%9A%E8%B5%B7%E6%BA%90/5924548eadc724663e8b4567.html";
        String pageContext = null;
        try {
            pageContext = ZhiHuCrawler.sendGet(biUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pageContext);
    }

}
