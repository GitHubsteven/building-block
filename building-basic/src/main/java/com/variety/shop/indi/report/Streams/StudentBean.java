package com.variety.shop.indi.report.Streams;

import java.io.Serializable;

/**
 * Created by rongbin.xie on 2017/4/25.
 */
public class StudentBean implements Serializable {
    private String name;
    private Integer age ;

    public String getName() {
        return name;
    }

    public StudentBean setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public StudentBean setAge(Integer age) {
        this.age = age;
        return this;
    }

}
