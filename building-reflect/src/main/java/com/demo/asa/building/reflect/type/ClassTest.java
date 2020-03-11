package com.demo.asa.building.reflect.type;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author asa.x
 * @Date: Created at 14:38 2020/3/11.
 */
public class ClassTest {
    private ClassTest classTest;

    public static void main(String[] args) throws NoSuchFieldException {
        getClassTest();
    }

    private static void getClassTest() throws NoSuchFieldException {
        Field field = ClassTest.class.getDeclaredField("classTest");
        Type type = field.getGenericType();
        System.out.println(type);
    }
}