package com.variety.shop.indi.crawler;

import java.io.IOException;

/**
 * Created by rongbin.xie on 2017/10/28.
 */
public class SinaWeiboSpider {
    public static void main(String[] args) {
        String biUrl = "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=a&oq=%25E6%2597%25A5%25E5%258E%2586&rsv_pq=ac77707a00049de8&rsv_t=b5d55K9TOfE9wy7y4yDGwJwgwT3FcxKPSaVVQG8E9UlGMQLdNpXLMghEyp0&rqlang=cn&rsv_enter=1&rsv_sug3=6&rsv_sug1=5&rsv_sug7=100&rsv_sug2=0&inputT=1488&rsv_sug4=1594";
        String pageContext = null;
        try {
            pageContext = ZhiHuCrawler.sendGet(biUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pageContext);
    }
}
