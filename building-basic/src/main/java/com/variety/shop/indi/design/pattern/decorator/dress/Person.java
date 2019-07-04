package com.variety.shop.indi.design.pattern.decorator.dress;

/**
 * Created by rongbin.xie on 2018/1/30.
 */
public class Person implements IPerson {
    private String name;

    public Person() {

    }


    public Person(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println(String.format("dress person: %s", name));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
