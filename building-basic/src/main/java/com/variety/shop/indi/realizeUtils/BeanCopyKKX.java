package com.variety.shop.indi.realizeUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 这是为了实现beanUtils的copy功能
 * <p>
 * Created by rongbin.xie on 2017/9/1.
 */
public class BeanCopyKKX {
    /**
     * test case, instead of the test function
     *
     * @param args
     */
    public static void main(String[] args) {
        Source source = new Source(12, "source", "1");
        Target target = new Target();
//        ThirdClass thirdClass = new ThirdClass("thirdClass");
        copy(source, target);
        System.out.println(target.getName() + " " + target.getAge());
    }

    /**
     * @param source source实例
     * @param target target实例
     * @param <S>    source 类型
     * @param <T>    target 类型
     */
    private static <S, T> void copy(S source, T target) {
        Field[] declaredFields = source.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String fieldName = declaredField.getName();
            System.out.println(fieldName);
            Field targetField;
            try {
                targetField = target.getClass().getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                System.out.println(e.getMessage());
                continue;
            }
            if (targetField == null) {
                continue;
            }
            String methodFieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            try {
                Method getMethod = source.getClass().getMethod("get" + methodFieldName);
                // TODO: 2017/9/4  不知道为什么不能用declareClass.getclass() 
                Object value = getMethod.invoke(source);
                Method setMethod = target.getClass().getMethod("set" + methodFieldName, value.getClass());
                setMethod.invoke(target, value);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        // TODO: 2017/9/1 无法解决不同数据类型的值，如何获取到方法参数的值，或许不用这么做
        return;
    }

}

/**
 * source的父类
 */
class Father {
    public String pub;

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }
}

/**
 * 数据来源类
 */
class Source extends Father {
    private Integer age;
    private String name;
    private String sex;

    public Source(Integer age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

/**
 * 数据copy目标类
 */
class Target {
    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * 第三方类
 */
class ThirdClass {
    private String name;

    public ThirdClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}