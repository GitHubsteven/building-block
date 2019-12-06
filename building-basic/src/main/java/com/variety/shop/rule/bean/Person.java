package com.variety.shop.rule.bean;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * Created by rongbin.xie on 2017/9/14.
 */
@Setter
@Getter
@Accessors(chain = true)
@AllArgsConstructor
@ToString
public class Person implements Comparable {
    private Integer id;
    private String type;
    private String name;
    private Integer age;
    private Boolean student;
    private Boolean beyond18;
    private Integer sex;

    public Person() {

    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public Person(String name, Integer age, String type) {
        this.type = type;
        this.name = name;
        this.age = age;
    }
}
