package com.demo.asa.building.reflect.annotation.online;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 10:59 2019/11/13.
 */
public class AnnotationHelper {

    private static final String ANNOTATIONS = "annotations";
    public static final String ANNOTATION_DATA = "annotationData";

    public static void main(String[] args) {
        System.err.println("JDK 7 ? " + AnnotationHelper.isJDK7OrLower());
        Greet greet = Demo.class.getAnnotation(Greet.class);
        System.err.println("Hello there [" + greet.name() + "]");
        DynamicGreetings altered = new DynamicGreetings("KungFu Panda");
        AnnotationHelper.alterAnnotationOn(Demo.class, Greet.class, altered);
        greet = Demo.class.getAnnotation(Greet.class);
        System.err.println("After alteration...Hello there [" + greet.name() + "]");

    }

    public static void alterAnnotationOn(Class clazzToLookFor, Class<? extends Annotation> annotationToAlter,
                                         Annotation annotationValue) {
        if (isJDK7OrLower()) {
            try {
                Field annotations = Class.class.getDeclaredField(ANNOTATIONS);
                annotations.setAccessible(true);
                Map<Class<? extends Annotation>, Annotation> map =
                        (Map<Class<? extends Annotation>, Annotation>) annotations.get(clazzToLookFor);
                map.put(annotationToAlter, annotationValue);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            try {
                //In JDK8 Class has a private method called annotationData().
                //We first need to invoke it to obtain a reference to AnnotationData class which is a private class
                Method method = Class.class.getDeclaredMethod(ANNOTATION_DATA, null);
                method.setAccessible(true);
                //Since AnnotationData is a private class we cannot create a direct reference to it. We will have to
                //manage with just Object
                Object annotationData = method.invoke(clazzToLookFor);
                //We now look for the map called "annotations" within AnnotationData object.
                Field annotations = annotationData.getClass().getDeclaredField(ANNOTATIONS);
                annotations.setAccessible(true);
                Map<Class<? extends Annotation>, Annotation> map =
                        (Map<Class<? extends Annotation>, Annotation>) annotations.get(annotationData);
                map.put(annotationToAlter, annotationValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isJDK7OrLower() {
        boolean jdk7OrLower = true;
        try {
            Class.class.getDeclaredField(ANNOTATIONS);
        } catch (NoSuchFieldException | SecurityException e) {
            jdk7OrLower = false;
        }
        return jdk7OrLower;
    }

    @Greet(name = "Dragon Warrior")
    public static class Demo {
    }
}