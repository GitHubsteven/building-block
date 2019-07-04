package com.variety.shop.indi.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * simple and primary web crawler using java
 * The basic steps to write a Web Crawler are:
 * <p>
 * 1.   Pick a URL from the frontier
 * 2.   Fetch the HTML code
 * 3.    Parse the HTML to extract links to other URLs
 * 4.  Check if you have already crawled the URLs and/or if you have seen the same content before
 * If not add it to the index
 * 5.For each extracted URL
 * Confirm that it agrees to be checked (robots.txt, crawling frequency)
 * <p>
 * Created by rongbin.xie on 2017/10/27.
 */
public class ZhiHuCrawler {

    /**
     * 通过url获取对应页面的context
     *
     * @param url 链接地址
     * @return 解析的结果
     * @throws IOException
     */
    public static String sendGet(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader in;
        URL realUrl = new URL(url);
        URLConnection connection = realUrl.openConnection();
        connection.connect();
        //字节流转字符流
        in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        String line;
        while ((line = in.readLine()) != null) {
            result.append(line);
        }
        in.close();
        return result.toString();
    }

    static ArrayList<Zhihu> regexString(String targetStr, String patternStr) {
        List<Zhihu> links = new ArrayList<>();
        // 定义一个样式模板，此中使用正则表达式，括号中是要抓的内容 // 相当于埋好了陷阱匹配的地方就会掉下去
        Pattern pattern = Pattern.compile(patternStr);
        // 定义一个matcher用来做匹配
        String hrefRegex = "href=\"(.+?)\"";
        Pattern urlPattern = Pattern.compile(hrefRegex);

        Matcher matcher = pattern.matcher(targetStr);
        // 如果找到了
        while (matcher.find()) {
            // 打印出结果
            Zhihu zhihu = new Zhihu();
            zhihu.setQuestion(matcher.group(1));

            String completeSentence = matcher.group(0);
//            System.out.println(completeSentence);
            String hrefUrl = "";
            Matcher urlMatcher = urlPattern.matcher(completeSentence);
            if (urlMatcher.find()) {
                hrefUrl = urlMatcher.group(1);
            }
            String header = "https://www.zhihu.com";
            zhihu.setZhihuUrl(header + hrefUrl);
            links.add(zhihu);
//            question_link" href="/question/24655180/answer/131501175" data-id="2044113" data-za-element-name="Title">量子力学的基本理论是什么？<
//            System.out.println(matcher.group(1));
        }
        return (ArrayList<Zhihu>) links;
    }


    public static Zhihu parseAnwser(Zhihu zhihu) {
        System.out.println();
//        itemprop="text">复兴号一大早从合肥动车所出来先挂D5497套跑一个合肥南到六安，在六安挂G7162跑一个虹桥，在虹桥变成G14标杆车，在合肥南保养完了不能一大早直接空车回上海吗</span>
        String answerRegex = "CopyrightRichText-richText\" itemprop=\"text\">(.+?)</span>";
        List<String> answers = new ArrayList<>();
        Pattern pattern = Pattern.compile(answerRegex);
        Matcher matcher = pattern.matcher(zhihu.getQuestionPageContext());
        boolean isFind = matcher.find();
        while (isFind) {
            String answerContext = matcher.group(1);
//            System.out.println(answerContext);
            answers.add(answerContext);
            isFind = matcher.find();
        }
        zhihu.setAnswers((ArrayList<String>) answers);
        return zhihu;
    }

}
