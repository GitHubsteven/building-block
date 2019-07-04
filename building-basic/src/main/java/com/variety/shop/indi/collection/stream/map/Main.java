package com.variety.shop.indi.collection.stream.map;

import com.variety.shop.rule.bean.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rongbin.xie on 2017/9/28.
 */
public class Main {
    /*
    java 8 list stream map has return result.you can use it transfer data type;
     */
    public static void main(String[] args) {
        List<Integer> sequence = new ArrayList<>();
        List<Person> persons = sequence.stream().map(number -> {
            Person person = new Person("name" + number, number, String.valueOf(number % 3));
            return person;
        }).collect(Collectors.toList());
        List<String> collect = persons.stream().map(Person::getName).collect(Collectors.toList());
    }
}
