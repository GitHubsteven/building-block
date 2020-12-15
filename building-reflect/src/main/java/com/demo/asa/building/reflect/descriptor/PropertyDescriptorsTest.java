package com.demo.asa.building.reflect.descriptor;

import bean.Person;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/8/20
 * @description
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class PropertyDescriptorsTest {
    public static void main(String[] args) throws Exception {
        Person person = new Person("asa.x", 12);
        person.setId(1L);
        person.setModified(new Date());
        person.setModifier("rb.x");

        PropertyDescriptor[] personProperties = getPropertyDescriptors(Person.class);
        for (PropertyDescriptor descriptor : personProperties) {
            Object result = descriptor.getReadMethod().invoke(person);
            System.out.println(descriptor.getName() + " :" + (result == null ? null : result.toString()));
        }

        String template = "UPDATE com_message_info\n" +
                "SET\n" +
                "message = CASE id\n" +
                "WHEN #{list[0].id} THEN ifNull(#{list[0].message},`message`)\n" +
                "END\n" +
                "WHERE id in (#{list[0].id})";
        System.out.println(template);
    }

    protected static PropertyDescriptor[] getPropertyDescriptors(Class<?> beanClass) throws Exception {
        List<PropertyDescriptor> propDescs = new ArrayList<>();
        for (; beanClass != Object.class; beanClass = beanClass.getSuperclass()) {
            for (Field field : beanClass.getDeclaredFields()) {
                if (!field.isSynthetic() && !Modifier.isStatic(field.getModifiers())) {
                    propDescs.add(new PropertyDescriptor(field.getName(), beanClass));
                }
            }
        }
        return propDescs.toArray(new PropertyDescriptor[0]);
    }
}
