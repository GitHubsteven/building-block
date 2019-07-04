package com.variety.shop.indi.sort;

import com.variety.shop.rule.bean.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rongbin.xie on 2017/9/14.
 */
public class Main {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("name1", 1,"1"));
        persons.add(new Person("name2", 2,"2"));
        persons.sort((a, b) -> -(a.getAge().compareTo(b.getAge())));
        persons.forEach(System.out::println);
    }
}
