package com.demo.asa.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/1/23
 * @description
 * @copyright COPYRIGHT © 2014 - 2021 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class HashTest {
    public static void main(String[] args) {
        int size = 1000000;
        List<String> list = new ArrayList<>(size);
        Map<Integer, String> hashMap = new HashMap<>(size);
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            String value = String.valueOf(i);
            setValue(list, value);
        }
        list.indexOf("50000");
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            String value = String.valueOf(i);
            setValue(hashMap, i, value);
        }
        hashMap.get(50000);
        System.out.println(System.currentTimeMillis() - start);

    }

    static void setValue(List<String> list, String value) {
        list.add(value);
    }

    static void setValue(Map<Integer, String> map, int key, String value) {
        map.put(key, value);
    }
}
