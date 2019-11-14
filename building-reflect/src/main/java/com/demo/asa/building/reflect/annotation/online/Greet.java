package com.demo.asa.building.reflect.annotation.online;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 10:58 2019/11/13.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Greet {
    /**
     * @return - The name of the person to greet.
     */
    String name() default "";
}