package com.asa.building.optimize.exception;

import bean.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 是否选择stream
 * @Date: Created at 17:05 2019/1/10.
 */
public class StreamOrNot {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        int loop = 10;
        for (int i = 0; i < loop; i++) {
            Person person = new Person();
            person.setName("name" + i);
            person.setAge(i);
            personList.add(person);
        }

        System.out.println("stream:....");
        logTime(personList, StreamOrNot::stream);

        System.out.println("for:....");
        logTime(personList, StreamOrNot::common);

        System.out.println("foreach:....");
        logTime(personList, StreamOrNot::foreach);
    }

    public static void logTime(List<Person> persons, Consumer<List<Person>> consumer) {
        long start = System.currentTimeMillis();
        consumer.accept(persons);
        System.out.println("run time(ms): " + (System.currentTimeMillis() - start));
    }

    public static void stream(List<Person> persons) {
        List<Person> rangePersons = persons.stream()
                .filter(it -> isRange(it.getAge()))
                .collect(Collectors.toList());
    }

    public static void common(List<Person> persons) {
        ArrayList<Person> people = new ArrayList<>();
        for (Person person : persons) {
            if (isRange(person.getAge())) {
                people.add(person);
            }
        }
    }

    public static void foreach(List<Person> persons) {
        ArrayList<Person> people = new ArrayList<>();
        persons.forEach(el -> {
            if (isRange(el.getAge())) {
                people.add(el);
            }
        });
    }


    public static boolean isRange(int age) {
        return Objects.equals(age, 12)
                || Objects.equals(age, 240)
                || Objects.equals(age, 480)
                || Objects.equals(age, 780)
                || Objects.equals(age, 998);
    }
}