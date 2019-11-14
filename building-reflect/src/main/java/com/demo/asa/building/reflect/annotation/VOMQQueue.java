package com.demo.asa.building.reflect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface VOMQQueue {
    String value();

    String exchange() default "";

    boolean isBackMessage() default false;

    boolean isDeclareQueue() default true;
}
