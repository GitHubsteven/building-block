package com.variety.shop.indi.java8;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by rongbin.xie on 2017/11/14.
 */
public class LocaleDateTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now() ;
        now = now.plusMinutes(-5);
        LocalDate today = LocalDate.now();
        java.util.Date from = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        long time = from.getTime();
        System.out.println(now);
        System.out.println(from);
    }
}
