package com.variety.shop.indi.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rongbin.xie on 2017/10/30.
 */
public class ListGroup {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map1 = new HashMap<>();
        map.computeIfAbsent("H", s -> 13);
        map.computeIfPresent("H", (s, integer) -> 11);
        map.forEach((sku, qty) -> map1.merge(sku, qty, (value, newValue) -> value + newValue));
        map.merge("H", 2, (integer, integer2) -> integer + integer2);
        System.out.println(map);
    }
}
