package com.variety.shop.indi.thread;

import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Created by rongbin.xie on 2017/9/26.
 */
public class Main {
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return super.initialValue();
        }
    };

    public static void main(String[] args) {
        Instant date = Instant.MAX;
        System.out.println(date);
    }

}
