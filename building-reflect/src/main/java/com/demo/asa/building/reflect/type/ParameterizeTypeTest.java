package com.demo.asa.building.reflect.type;

import jdk.nashorn.internal.codegen.TypeMap;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author asa.x
 * @Date: Created at 11:13 2020/3/11.
 */
public class ParameterizeTypeTest<T> {
    List<T> list = null;
    Set<T> set = null;
    Map<String, Integer> map = null;
    Map.Entry<String, Integer> entry = null;

    public static void main(String[] args) throws NoSuchFieldException {
//        genericType();
//        rawType();
        ownType();
    }

    private static void genericType() throws NoSuchFieldException {
        Field fieldList = ParameterizeTypeTest.class.getDeclaredField("list");
        Type type = fieldList.getGenericType();
        System.out.println(type.getClass().getName());    //sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl

        Field fieldSet = ParameterizeTypeTest.class.getDeclaredField("set");  //sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
        Type typeSet = fieldSet.getGenericType();
        System.out.println(typeSet.getClass().getName());
    }

    /**
     * return the root type of the parameterized type
     *
     * @throws NoSuchFieldException
     */
    public static void rawType() throws NoSuchFieldException {
        Field fieldMap = ParameterizeTypeTest.class.getDeclaredField("map");
        Type type = fieldMap.getGenericType();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        System.out.println(parameterizedType.getRawType().getTypeName());
        Type[] argTypes = parameterizedType.getActualTypeArguments();
        for (Type argType : argTypes) {
            System.out.println(argType.getTypeName());
        }
    }

    /**
     * return the parent of the raw type such as Map.Entry's own type is Map
     *
     * @throws NoSuchFieldException
     */
    public static void ownType() throws NoSuchFieldException {
        Field fieldList = ParameterizeTypeTest.class.getDeclaredField("entry");
        Type type = fieldList.getGenericType();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        System.out.println(parameterizedType.getOwnerType().getTypeName());    //map
    }
}