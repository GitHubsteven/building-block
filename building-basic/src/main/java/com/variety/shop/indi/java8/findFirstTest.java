package com.variety.shop.indi.java8;

import com.variety.shop.rule.bean.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by rongbin.xie on 2017/11/14.
 */
public class findFirstTest {
    static final List<Person> persons = new ArrayList<>();

    static {
        persons.add(new Person("name1", 12, "type1"));
        persons.add(new Person("name2", 13, "type1"));
        persons.add(new Person("name3", 14, "type2"));
        persons.add(new Person("name4", 15, "type3"));
        persons.add(new Person("name5", 16, "type3"));
    }

    public static void main(String[] args) {
        System.out.println("persons before handle: ");
        printList(persons);
        System.out.println("persons after handle: ");
        Map<String, List<Person>> typeToPersons = persons.stream().collect(Collectors.groupingBy(Person::getType));
        typeToPersons.forEach((type, personList) -> {
            System.out.println("type :" + type);
            printList(personList);
        });
    }

    static <T> void printList(List<T> list) {
        list.forEach(item -> {
            System.out.println(item.toString());
        });
    }
}
