package com.variety.shop.indi.java8.group;

import com.variety.shop.indi.report.Streams.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by rongbin.xie on 2018/1/24.
 */
public class StreamGroupTest {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person().setName("a").setSharp("handsome"));
        persons.add(new Person().setName("b"));
        Map<String, List<Person>> map = persons.stream().collect(Collectors.groupingBy(Person::getSharp));
        map.forEach((key, value) -> {
            System.out.println(key);
        });
    }

}
