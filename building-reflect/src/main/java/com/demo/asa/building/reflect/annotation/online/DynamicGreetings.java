package com.demo.asa.building.reflect.annotation.online;

import java.lang.annotation.Annotation;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 13:10 2019/11/13.
 */
public class DynamicGreetings implements Greet {
    private String name;

    public DynamicGreetings(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return DynamicGreetings.class;
    }
}