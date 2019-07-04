package com.variety.shop.indi.reflect;

import com.variety.shop.indi.report.DateTimeUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 15:58 2018/4/8.
 */
public class ProxyCase {
    public static void main(String[] args) {
        Method[] methods = ProxyCase.class.getDeclaredMethods();
        Stream.of(methods).forEach(method -> {
            System.out.println(method.getName());
            Stream.of(method.getAnnotatedParameterTypes()).forEach(it->{
                System.out.println(it.getType());
                System.out.println(it.getClass().getName());
        });
//        ProxyCase.class.
//            Method sleepTest = ProxyCase.class.getMethod("sleepTest");
//            timeProxyCase(sleepTest, (Object) null);
    });
    }

    static void timeProxyCase(Method method, Object... params) throws InvocationTargetException, IllegalAccessException {
        System.out.println("start to run method: " + method.getName() + "at " + DateTimeUtils.getNow());
        method.invoke(params);
        System.out.println("method " + method.getName() + "end at " + DateTimeUtils.getNow());
    }

    static void sleepTest() throws InterruptedException {
        Thread.sleep(2000);
    }
}
