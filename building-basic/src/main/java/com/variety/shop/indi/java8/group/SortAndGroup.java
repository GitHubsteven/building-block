package com.variety.shop.indi.java8.group;

import com.variety.shop.rule.bean.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 17:51 2018/5/9.
 */
public class SortAndGroup {
    public static void main(String[] args) {
        List<Person> persons = IntStream.range(1, 11)
                .mapToObj(it -> {
                    Person person = new Person();
                    person.setId(it);
                    int random = (int) Math.floor(Math.random() * 10);
                    person.setName("name" + random);
                    person.setAge(10 + (it % 4));
                    person.setType("type" + it);
                    return person;
                }).collect(Collectors.toList());
        persons.stream().sorted((p1,p2)->p1.getAge().compareTo(p2.getAge()));
        Map<Integer, List<Person>> age2PersonsMap = persons.stream().collect(Collectors.groupingBy(Person::getAge));
        age2PersonsMap.forEach((age,personList)->{
            System.out.println("age" + age);
            System.out.println("persons" );
            personList.forEach(System.out::println);
        });
    }
}
