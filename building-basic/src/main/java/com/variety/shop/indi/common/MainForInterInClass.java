package com.variety.shop.indi.common;


import org.apache.commons.collections4.map.LinkedMap;

import java.util.LinkedHashSet;

/**
 * Created by rongbin.xie on 2017/10/27.
 */
public class MainForInterInClass<K, V> {
    public static void main(String[] args) {
        InterInClass test = new InterInClass();
        String link = InterInClass.InClassInterface.link;

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
//        linkedHashSet
        LinkedMap linkedMap = new LinkedMap();
        linkedMap.keySet();
        linkedMap.entrySet();
        LinkedMap map = new LinkedMap();
        map.mapIterator();
    }
}
