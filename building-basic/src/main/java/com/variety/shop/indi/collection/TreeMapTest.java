package com.variety.shop.indi.collection;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by rongbin.xie on 2017/9/26.
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("1");
        treeSet.add("2");
        treeSet.add("1");
        treeSet.add("0");
        System.out.println(treeSet);
    }
}
