package com.variety.shop.indi.collection.stream.map;

import com.variety.shop.rule.bean.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by rongbin.xie on 2017/12/11.
 */
public class CollectionAddNull {
    public static void main(String[] args) {
        Map<Integer, Integer> ageToCount = new HashMap<>();
        ageToCount.put(0, 3);
        ageToCount.put(10, 2);

        List<Person> persons = new ArrayList<>();
        int i = 0;
        for (int age = 0; age < 100; age += 10) {
            Person person = new Person();
            person.setAge(age);
            person.setName("" + i);
            persons.add(person);
            i++;
        }

        Map<Integer, List<Person>> ageToPersons = persons.stream()
                .collect(Collectors.groupingBy(it -> it.getAge() % 20));

        List<String> names = ageToCount.keySet().stream().flatMap(it -> {
            List<Person> personList = ageToPersons.get(it);
            Integer count = ageToCount.get(it);
            int countInNeed = Math.min(count, personList.size());
            return personList.subList(0, countInNeed).stream().map(ele -> ele.getName());
        }).collect(Collectors.toList());
        System.out.println(names);

    }
}
