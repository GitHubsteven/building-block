package com.variety.shop.rule.bean;

/**
 * Created by rongbin.xie on 2017/9/14.
 */
public class Person implements Comparable {
    private Integer id;
    private String type;
    private String name;
    private Integer age;
    private Boolean isStudent;
    private Boolean beyond18;
    private Integer sex;

    public Person() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSex() {
        return sex;
    }

    public Person setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public String getType() {
        return type;
    }

    public Person setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(final String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Person setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Boolean getBeyond18() {
        return beyond18;
    }

    public Person setBeyond18(Boolean beyond18) {
        this.beyond18 = beyond18;
        return this;
    }

    public Person(String name, Integer age, String type) {
        this.type = type;
        this.name = name;
        this.age = age;
    }


    public Boolean getStudent() {
        return isStudent;
    }


    public Person setStudent(Boolean student) {
        isStudent = student;
        return this;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

}
