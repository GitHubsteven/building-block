package com.variety.shop.indi.report.Streams;

/**
 * Created by dell on 2017/2/16.
 */
public class Boys extends  Man {

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void iAmABoy()
    {
        System.out.println(String.format(" I am a : %s", "boy"));
    }
}
