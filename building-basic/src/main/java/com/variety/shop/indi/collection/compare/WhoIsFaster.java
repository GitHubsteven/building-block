package com.variety.shop.indi.collection.compare;

import com.variety.shop.rule.bean.Person;

import java.util.List;
import java.util.Map;

/**
 * Created by rongbin.xie on 2018/3/14.
 */
public class WhoIsFaster {
    private List<DataBean> dataList;
    private Map<Integer, Integer> dataMap;

    public WhoIsFaster() {
    }

    public static void main(String[] args) {
//        DataBean data = new DataBean();
//        data.setIndex(1).setValue(2);
//        printPerson(data);
        long x = 1000L;
        int y = 1000;
        System.out.println(true);

    }

    public static void printPerson(DataBean data) {
        if (data == null || data.getPerson() == null) {
            System.out.println("can not get person!");
            return;
        }
        Person person = data.getPerson();
        System.out.println(person.getName());
    }
}
