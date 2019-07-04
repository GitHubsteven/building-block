package com.variety.shop.indi.collection;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.variety.shop.rule.bean.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rongbin.xie on 2017/9/27.
 */
public class ListToMap {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Person p = new Person("name" + i, i + 20, String.valueOf(i % 3));
            list.add(p);
        }

        Map<String, String> relation = new HashMap<>();
        relation.put("0", "type1");
        relation.put("1", "type1");
        relation.put("2", "type2");


        Multimap<String, Person> typeMap = ArrayListMultimap.create();
        list.forEach(person -> typeMap.put(relation.get(person.getType()), person));
        Map map = typeMap.asMap();
        map.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });
    }
}
