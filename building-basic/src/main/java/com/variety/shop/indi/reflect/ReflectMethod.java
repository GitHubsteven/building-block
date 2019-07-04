package com.variety.shop.indi.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 用于反射方法集合
 * <p>
 * Created by rongbin.xie on 2018/1/26.
 */
public class ReflectMethod implements IReflectMethod {
    @Override
    public void welcome() {
        System.out.println("welcome,ReflectMethod!");
    }

    @Override
    public void goodBye(Integer i) {
        IntStream.range(0, i).forEach(it -> {
            System.out.println("goodBye " + it);
        });
    }

    @Override
    public void goodByeMany(List<Integer> indexes) {

    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        IReflectMethod reflectMethod = new ReflectMethod();
        Method goodBye = IReflectMethod.class.getMethod("goodBye", Integer.class);

        goodBye.invoke(reflectMethod, 10);

    }

    public void testMethodProxy(String methodName, Object runObj, Object[] params) throws NoSuchMethodException {
//        Method[] methods = runObj.getClass().getMethods();
//        Arrays.stream(methods).filter(it-> Objects.equals(it.getName(),methodName))
        List<? extends Class<?>> paramTypeList = Arrays.stream(params)
                .map(Object::getClass)
                .collect(Collectors.toList());
        Object[] paramTypes = paramTypeList.toArray();
//        Method method = runObj.getClass().getMethod(methodName, paramTypes);
//        method.invoke(runObj,)
    }
}
