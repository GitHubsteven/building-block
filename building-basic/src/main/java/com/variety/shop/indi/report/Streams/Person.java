package com.variety.shop.indi.report.Streams;

/**
 * Created by rongbin.xie on 2017/3/31.
 */
public class Person {
    private String name;
    private int age;
    private int sex;
    private String sharp;
    private Boolean isStudent;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public Person() {
    }

    ;

    public Person(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public int getSex() {
        return sex;
    }

    public Person setSex(int sex) {
        this.sex = sex;
        return this;
    }

    public String getAgeSex() {
        return age + "" + sex;
    }

    public String getSharp() {
        return sharp;
    }

    public Person setSharp(String sharp) {
        this.sharp = sharp;
        return this;
    }

    public Boolean getStudent() {
        return isStudent;
    }

    public void setStudent(Boolean student) {
        isStudent = student;
    }
}
