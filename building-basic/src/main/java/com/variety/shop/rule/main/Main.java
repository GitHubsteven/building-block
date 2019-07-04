package com.variety.shop.rule.main;

import java.io.UnsupportedEncodingException;

/**
 * Created by rongbin.xie on 2017/9/14.
 */
public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //不能编译
//        String key ="ID#taobao"+tradeId;
//        cache.put(key,value);
//        IntegerLimit();
    }

    private static void IntegerLimit() {
        Integer a = 344343;
        Integer b = 344343;
        Integer c =12;
        Integer  d =12;
        System.out.println(c == d);
        System.out.println(a == b);
    }

    public void test(Integer a, Integer b) {

    }
}
