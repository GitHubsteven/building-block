package com.demo.asa.building.proxy;

import com.demo.asa.building.proxy.impl.PersonService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/6/8
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class PersonServiceProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, params, proxy) -> {
            if (method.getDeclaringClass() != Object.class
                    && method.getReturnType() == String.class) {
                Object result = proxy.invokeSuper(obj, params);
                return result;
            } else {
                return proxy.invokeSuper(obj, params);
            }
        });
        PersonService proxy = (PersonService) enhancer.create();
        System.out.println(proxy.sayHello(null));
        int lengthOfName = proxy.lengthOfName("Mary");
        System.out.println(lengthOfName);
    }

}
