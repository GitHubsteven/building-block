package com.variety.shop.indi.report.Streams;

/**
 * Created by dell on 2017/2/16.
 */
public class Girl extends Man{
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void LovedStar()
    {
        System.out.println(String.format("My loved star is %s", "Jay"));
    }
}
