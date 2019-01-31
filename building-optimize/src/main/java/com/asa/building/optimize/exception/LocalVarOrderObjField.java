package com.asa.building.optimize.exception;

import bean.Person;

import java.util.function.Consumer;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 局部变量或者不是对象属性--->局部变量
 * @Date: Created at 14:42 2019/1/10.
 */
public class LocalVarOrderObjField {
    public static void main(String[] args) {
        int loop = 1000;
        Person person = new Person();
        person.setAge(12);
        person.setName("test-name");
        LocalVarOrderObjField testObj = new LocalVarOrderObjField();
        System.out.println("local ...");
        logTime(loop, testObj::printNameLocal, person);
        System.out.println("obj field ...");
        logTime(loop, testObj::printName, person);
    }

    public static void logTime(int loop, Consumer<Person> task, Person person) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            task.accept(person);
        }
        System.out.println("------runTime(ms): " + (System.currentTimeMillis() - startTime));
    }


    public void printName(Person person) {
        System.out.println(person.getName());
        System.out.println(person.getName());
        System.out.println(person.getName());
        System.out.println(person.getName());
        System.out.println(person.getName());
        System.out.println(person.getName());
        System.out.println(person.getName());
        System.out.println(person.getName());
        System.out.println(person.getName());
    }

    public void printNameLocal(Person person) {
        String name = person.getName();
        System.out.println(name);
        System.out.println(name);
        System.out.println(name);
        System.out.println(name);
        System.out.println(name);
        System.out.println(name);
        System.out.println(name);
        System.out.println(name);
        System.out.println(name);
    }
}
