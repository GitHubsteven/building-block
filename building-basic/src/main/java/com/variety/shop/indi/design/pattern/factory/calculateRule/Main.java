package com.variety.shop.indi.design.pattern.factory.calculateRule;

import java.util.*;

/**
 * Created by rongbin.xie on 2017/10/20.
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("1");
        System.out.println(list);

        Set<String> set = new HashSet<>(list) ;
        set.forEach(System.out::println);

    }
}
