package com.variety.shop.indi.crawler;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        String url = "http://www.52bar.com/";
        String zh_url = "https://www.zhihu.com/explore/recommendations";
        try {
            String pageContext = ZhiHuCrawler.sendGet(zh_url);
//            System.out.println(pageContext);
            String questionPatternStr = "question_link.+?>(.+?)<";
            ArrayList<Zhihu> questionLinks = ZhiHuCrawler.regexString(pageContext, questionPatternStr);
            questionLinks.forEach(questionLink -> {
//                System.out.println(questionLink.getQuestion());
                try {
                    String questionContext = ZhiHuCrawler.sendGet(questionLink.getZhihuUrl());
                    questionLink.setQuestionPageContext(questionContext);
//                    System.out.println(questionContext);
                    ZhiHuCrawler.parseAnwser(questionLink);
                } catch (IOException e) {
                    System.out.println("get zhiHu question failed!");
                }
            });
            //spider zhihu post instead of question.
//            String postPatternStr = "post-link.+?>(.+?)<";
//            ArrayList<Zhihu> postLinks = ZhiHuCrawler.regexString(pageContext, postPatternStr);
//            System.out.println("================split line==============================");
//            postLinks.forEach(System.out::println);
            questionLinks.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
