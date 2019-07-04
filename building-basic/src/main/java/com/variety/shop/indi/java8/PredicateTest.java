package com.variety.shop.indi.java8;

import java.util.function.Predicate;

/**
 * Created by rongbin.xie on 2018/1/26.
 */
public class PredicateTest {
    public static void main(String[] args) {
        Predicate<Integer> gt2 = x -> x > 2;
        boolean test = gt2.test(2);
        System.out.println(test);
    }
}
