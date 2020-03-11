package com.demo.asa.building.reflect.type;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: 泛型的类型变量，指的是List<T>、Map<K,V>中的T，K，V等值，实际的Java类型是TypeVariableImpl（TypeVariable的子类）；
 * 此外，还可以对类型变量加上extend限定，这样会有类型变量对应的上限；
 * <strong>如果仅仅是描述K,V这些参数值的话，那么ParameterizedType.getArguments依然是可以的的，那么TypeVariable的功能有更强大吗？</strong>
 * @Author asa.x
 * @Date: Created at 12:48 2020/3/11.
 */
public class TypeVariableTest<T extends Number & Serializable & Comparable, R extends Serializable> {
    private T t;

    private TypeVariableTest<Integer, GetOrderResponse> variableTest = null;

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
//        getBounds();
        getMethodTypeVariable();
    }

    private static void getBounds() throws NoSuchFieldException {
        Field fieldT = TypeVariableTest.class.getDeclaredField("t");
        TypeVariable typeVariable = (TypeVariable) fieldT.getGenericType();
        //get bounds
        for (Type bound : typeVariable.getBounds()) {
            System.out.println(bound.getTypeName());
        }
        //get declaration
        System.out.println(typeVariable.getGenericDeclaration());
    }

    private <Q extends Number> Q methodGeneric() {
        return null;
    }

    /**
     * generic declared by method(usually, generic can be declared by class, method, and constructor)
     *
     * @throws NoSuchMethodException
     */
    private static void getMethodTypeVariable() throws NoSuchMethodException {
        Method method = TypeVariableTest.class.getDeclaredMethod("methodGeneric");
        TypeVariable typeVariable = (TypeVariable) method.getGenericReturnType();
        for (Type parameterTypeVariable : method.getGenericParameterTypes()) {
            System.out.println(parameterTypeVariable.getTypeName());
        }
        System.out.println(typeVariable.getGenericDeclaration());

    }
}