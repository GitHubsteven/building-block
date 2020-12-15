package com.demo.asa.building.reflect.descriptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/8/20
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class MapSetNullValue {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>(0);

//        List<Integer> first = map.compute(ele, (it, list) -> {
//            if (list == null) {
//                list = new ArrayList<>();
//            }
//            list.add(it);
//            return list;
//        });
//        first.add(1);

        System.out.println(map);
    }
}
