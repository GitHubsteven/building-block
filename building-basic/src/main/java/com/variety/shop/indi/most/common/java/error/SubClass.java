package com.variety.shop.indi.most.common.java.error;

import java.util.Date;

/**
 * Created by rongbin.xie on 2017/9/20.
 */
public class SubClass {
    public static String createHello(String name) {
        return "hello" + name;
    }

    public final String createName(){
        return new Date().toString();
    }
}
