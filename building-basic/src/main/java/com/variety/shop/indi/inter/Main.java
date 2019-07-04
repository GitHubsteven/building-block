package com.variety.shop.indi.inter;

import com.variety.shop.rule.bean.Person;

/**
 * 这个类是为了学习接口编程
 * <p>
 * Created by rongbin.xie on 2017/9/5.
 */
public class Main {
    public static void main(String[] args) {
//        interParamFun(1);
        Person person = new Person();
        person.setName("jack");
        Integer age = person.getAge();
        age = age == null ? 0 : age;
        person.setAge(age);
        System.out.println(person);

    }

    static void interParamFun(int x, FuncInterTest1 funcInterTest1) {
        int y = funcInterTest1.getData();
        int z = funcInterTest1.getNext(y);
        int w = funcInterTest1.getMul(z);
        System.out.println(String.format("w : %s, y: %s,z: %s", w, y, z));
    }
}
