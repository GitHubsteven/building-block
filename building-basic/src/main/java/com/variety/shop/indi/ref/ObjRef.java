package com.variety.shop.indi.ref;

import com.variety.shop.rule.bean.Person;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 11:06 2018/3/22.
 */
public class ObjRef {
    public static void main(String[] args) {
        Person name1 = new Person().setName("name1").setAge(1).setBeyond18(false).setSex(1);
        growUp(name1);
        System.out.println(name1.getAge());
    }

    static void growUp(Person person) {
        person.setAge(person.getAge() + 1);
    }
}
