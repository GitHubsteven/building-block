package com.demo.asa.java8;

import com.variety.shop.rule.bean.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 15:31 2019/12/6.
 */
public class SetAndFilter {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        //person1
        Person person1 = new Person();
        person1.setName("p1").setAge(11).setSex(1).setBeyond18(false);
        people.add(person1);
        //person2
        Person person2 = new Person();
        person2.setName("p2").setAge(21).setSex(1).setBeyond18(true);
        people.add(person2);
        //person3
        Person person3 = new Person();
        person3.setName("p3").setAge(31).setSex(1).setBeyond18(true);
        people.add(person2);
        List<String> ignoreList = new ArrayList<>();
        people = people.stream().filter(it -> {
            Boolean beyond18 = it.getBeyond18();
            if (!beyond18) {
                ignoreList.add(it.getName());
                return false;
            }
            it.setName("adult: " + it.getName());
            return true;
        }).collect(Collectors.toList());
        System.out.println(ignoreList);
        people.forEach(System.out::println);
    }
}