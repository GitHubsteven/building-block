package com.variety.shop.indi.report;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by rongbin.xie on 2017/8/31.
 */
public class checkOutTest {

    List<Integer> list = new ArrayList<>();

    /**
     * treeSet ordered and not repeatedly
     * @param args
     */
    public static void main(String[] args) {

        TreeSet<Integer> set = new TreeSet();
        set.add(3);
        set.add(3);
        set.add(2);
        set.forEach(System.out::println);
    }
}
