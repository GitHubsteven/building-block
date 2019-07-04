package com.variety.shop.indi.collection.compare;


import com.variety.shop.rule.bean.Person;

/**
 * Created by rongbin.xie on 2018/3/14.
 */
public class DataBean {
    private Integer index;
    private Integer value;
    private Person person;

    public Integer getIndex() {
        return index;
    }

    public DataBean setIndex(Integer index) {
        this.index = index;
        return this;
    }

    public Integer getValue() {
        return value;
    }

    public DataBean setValue(Integer value) {
        this.value = value;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public DataBean setPerson(Person person) {
        this.person = person;
        return this;
    }
}
