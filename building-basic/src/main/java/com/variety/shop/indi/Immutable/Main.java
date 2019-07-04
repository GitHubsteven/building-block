package com.variety.shop.indi.Immutable;

/**
 * Created by rongbin.xie on 2017/9/14.
 */
public class Main {

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "abcd";
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str1 == str2);
        str1 = "abc";
        System.out.println(str2);
    }
}
