package com.asa.building.optimize.inherit;

import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 19:01 2019/2/21.
 */
@Getter
@Setter
public class MethodShare {
    private Person person = new Person();
    private ThreadLocal<Person> personThreadLocal = ThreadLocal.withInitial(Person::new);
}