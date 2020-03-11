package com.demo.asa.building.reflect.type;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author asa.x
 * @Date: Created at 12:31 2020/3/11.
 */
public class GenericArrayTypeTest<T> {
    private T[] t;
    private List<String>[] listArray;

    public static void main(String[] args) throws NoSuchFieldException {
        genericArrayType();
    }

    public static void genericArrayType() throws NoSuchFieldException {
        Field fieldArrayList = GenericArrayTypeTest.class.getDeclaredField("t");
        Type type = fieldArrayList.getGenericType();
        GenericArrayType genericArrayType = (GenericArrayType) type;
        Type componentType = genericArrayType.getGenericComponentType();
        System.out.println(componentType.getTypeName());
        if (componentType instanceof ParameterizedType) {
            ParameterizedType parameterizedComponentType = (ParameterizedType) componentType;
            System.out.println(parameterizedComponentType.getRawType().getTypeName());
            for (Type argument : parameterizedComponentType.getActualTypeArguments()) {
                System.out.println(argument.getTypeName());
            }
        }
    }
}