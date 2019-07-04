package com.variety.shop.indi.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rongbin.xie on 2017/10/27.
 */
public class RegexMain {
    public static void main(String[] args) {
//        testGroup();
//        testAferClassPractice();
//        String data = "A word Never goNe a !";
//        String data1 = "!";
        //out word \ gone \a  \!
//        int count = countWordStartWithUpperLetter(data);
//        System.out.println(count);
//
        String annotation = "  /**\n" +
                "         * 品牌方SKU\n" +
                "         */";

        findAnnotation(annotation);






//        findExclamation(data1);
    }

    /**
     * test what the matcher.group really result
     */
    private static void testGroup() {
        String context = "Jack don't love rose, he like rose ,rose loves rose,";
        String regex = "ve(.+?),";
//        System.out.println(regex_rose);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        System.out.println(matcher.groupCount());
        while (matcher.find()) {
//            System.out.println(matcher.testGroup());
            System.out.println(matcher.group().length());
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
        }
    }

    private static void testAferClassPractice() {
        String regex = "^[A-Z](.+?)$";
        String sentence = "We will win. jack love rose .";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        } else {
            System.out.println("Not Found!");
        }
//        System.out.println(sentence.startsWith("n"));


    }

    static int countWordStartWithUpperLetter(String data) {
//        String upper_letter_start_regex = "\\b([A-Z])(\\S*?)\\b";
        String no_upper_letter_start_regex = "\\b([^A-Z\\s](\\S)*?)+?\\b";
        Pattern pattern = Pattern.compile(no_upper_letter_start_regex);
        Matcher matcher = pattern.matcher(data);
        int count = 0;
        while (matcher.find()) {
            System.out.println(matcher.group(0));
            count++;
        }
        return count;
    }

    static String findExclamation(String data) {
        String regex = "\\b\\S\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
        return "";
    }

    /**
     * 找到注释,注意一点的是，.也许会包含line terminator，也许不会。
     *
     * @param data 数据
     */
    static String findAnnotation(String data){
        String regex = "/\\*\\*((\r\n|\n)*.*)+?\\*/";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        while(matcher.find()){
            System.out.println(matcher.group(0));
        }
        return null;
    }

}

