package com.variety.shop.indi.collection.sort;

import com.variety.shop.constant.SpringTestEnum;
import com.variety.shop.rule.bean.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rongbin.xie on 2018/2/7.
 */
public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person().setName("nam1").setAge(12).setSex(SpringTestEnum.GeneralEnum.FEMALE.getVal()));
        persons.add(new Person().setName("nam2").setAge(2).setSex(SpringTestEnum.GeneralEnum.FEMALE.getVal()));
        persons.add(new Person().setName("nam3").setAge(18).setSex(SpringTestEnum.GeneralEnum.MALE.getVal()));
        persons.add(new Person().setName("nam4").setAge(19).setSex(SpringTestEnum.GeneralEnum.MALE.getVal()));
        persons.add(new Person().setName("nam5").setAge(19).setSex(SpringTestEnum.GeneralEnum.FEMALE.getVal()));
        persons.add(new Person().setName("nam6").setAge(99).setSex(SpringTestEnum.GeneralEnum.MALE.getVal()));

        List<Person> personList = persons.stream()
                .sorted((o1, o2) -> {
                    int ageCompare = o1.getAge() - o2.getAge();
                    if (ageCompare != 0) return ageCompare;

                    int sexCompare = o1.getSex() - o2.getSex();
                    if (sexCompare != 0) return sexCompare;

                    return o1.getName().compareToIgnoreCase(o2.getName());
                })
                .collect(Collectors.toList());

        personList.forEach(System.out::println);

        /*
        don't need to qualify case labels with the enum type, just its value.
         */
        SpringTestEnum.GeneralEnum general = SpringTestEnum.GeneralEnum.getGeneralNullable(1);
        switch (general){
            case FEMALE:{
                System.out.println("I am female");
            }
            break;
            case MALE:{
                System.out.println("I am male");
            }
            break;
            default:{
                System.out.println("i have no idea my general");
            }
        }



    }
}
