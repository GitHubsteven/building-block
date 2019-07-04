package com.variety.shop.indi.collection;

import com.variety.shop.rule.bean.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/4
 * @Time: 15:16
 * @Description:
 * @version: 1.0.0
 */
public class DownStreamTest {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person().setName("name1").setSex(0));
        people.add(new Person().setName("name2").setSex(1));
        people.add(new Person().setName("name3").setSex(1));

        Map<Integer, Person> map = people.stream()
                .collect(Collectors.groupingBy(Person::getSex, Collectors.reducing(null, (o1, o2) -> o1 != null ? o1 : o2)));
        map.forEach((key, value) -> {
            System.out.println("key: " + key);
            System.out.println("value" + value);
        });
    }
}