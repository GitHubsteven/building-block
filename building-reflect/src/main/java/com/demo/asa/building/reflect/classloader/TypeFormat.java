package com.demo.asa.building.reflect.classloader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 11:36 2019/6/17.
 */
public class TypeFormat {

    private static ObjectMapper OM = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        List<Person> people = new ArrayList<>();

        Person person = new Person();
        person.setAge(12).setName("name");

        people.add(person);
        System.out.println(OM.writeValueAsString(people));

        System.out.println(OM.writeValueAsString(getResult()));

        String json = "[{\"name\":\"name\",\"age\":12}]";
    }

    static Void getResult() {
        return null;
    }

    @Setter
    @Getter
    @Accessors(chain = true)
    static class Person {
        private String name;
        private Integer age;
    }
}