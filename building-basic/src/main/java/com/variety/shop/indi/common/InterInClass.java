package com.variety.shop.indi.common;

/**
 * Created by rongbin.xie on 2017/10/27.
 */
public class InterInClass {
    private String name ;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    interface InClassInterface{
        String link = "Link";
        int add(int a, int b);

    }
}
