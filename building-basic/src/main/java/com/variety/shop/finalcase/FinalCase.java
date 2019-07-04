package com.variety.shop.finalcase;


import com.variety.shop.rule.bean.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 10:35 2018/4/17.
 */
public class FinalCase {
    public static void main(String[] args) {
        FinalCase finalCase = new FinalCase();
//        finalCase.testNullify();
        finalCase.testRef();
    }

    public void testNullify() {
        Collection<Integer> c = new ArrayList<>();
        nullify(c);
        assertNotNull(c);
        final Collection<Integer> c1 = c;
        assertTrue(c1.equals(c));
        change(c);
        assertTrue(c1.equals(c));
    }

    private void change(Collection<Integer> c) {
        c = new ArrayList<Integer>();
    }

    public void nullify(Collection<?> t) {
        t = null;
        t = Arrays.asList(12, 3);
    }

    void testRef() {
        Person person = createPerson();
        shapePerson(person);
        System.out.println(person);
    }


    Person createPerson() {
        return new Person();
    }

    void shapePerson(final Person person) {
        person.setName("jack")
                .setAge(10)
                .setBeyond18(false)
                .setStudent(true);

    }

    void swap(int x, int y) {
    }
}
