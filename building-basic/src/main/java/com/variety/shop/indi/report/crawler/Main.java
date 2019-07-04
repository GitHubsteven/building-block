package com.variety.shop.indi.report.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rongbin.xie on 2017/5/9.
 */
public class Main {

    public static void main(String[] args) {
        String url = "https://www.baidu.com/";
//        System.out.println(doGet(url));
        String content = doGet(url);
        String testContent = " <img src=//www.baidu.com/img/gs.gif> </p> </div> </div> </div> </body> </html>";
        String regex = "src=(.+?)";
        String imgSrc = getUrl(testContent, regex);

        System.out.println(imgSrc);
//        doRegex();
    }

    public static String doGet(String url) {
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                result += line;
            }
        } catch (IOException e) {
            System.out.println("send GET REQUEST exception " + e);
            e.printStackTrace();
        } finally {
            try {
                if (null != in)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static void doRegex() {
        Pattern pattern = Pattern.compile("href=\"(.+?)\"");
        Matcher matcher = pattern.matcher("<a href=\"index.html\">我的主页</a>");
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }

    public static String getUrl(String source, String regexStr) {
        Pattern pattern = Pattern.compile(regexStr);
        Matcher matcher = pattern.matcher(source);
        if (matcher.find()) {
            return matcher.group(0);
        } else {
            return null;
        }
    }

}
