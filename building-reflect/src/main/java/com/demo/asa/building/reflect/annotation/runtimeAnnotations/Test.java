package com.demo.asa.building.reflect.annotation.runtimeAnnotations;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 11:43 2019/11/13.
 */
public class Test {
    public static class TestClass {
    }

    public static void main(String[] args) {
        TestAnnotation annotation = TestClass.class.getAnnotation(TestAnnotation.class);
        System.out.println("TestClass annotation before:" + annotation);

        Map<String, Object> valuesMap = new HashMap<>();
        valuesMap.put("value", "some String");
        RuntimeAnnotations.putAnnotation(TestClass.class, TestAnnotation.class, valuesMap);

        annotation = TestClass.class.getAnnotation(TestAnnotation.class);
        System.out.println("TestClass annotation after:" + annotation);
    }
}