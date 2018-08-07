package util;

import bean.SimpleBean;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/24
 * @Time: 13:37
 * @Description:
 * @version: 1.0.0
 */
public class AssignUtil {
    private final static Class<?>[] primitiveClazz = {Integer.class, String.class, Double.class, Float.class,
            Long.class, Character.class, Short.class, Boolean.class};

    private final static Class<?>[] likePrimitiveClazz = {Date.class};

    private final static Class<?>[] collectionClass = {Iterable.class, Map.class};


    public static void main(String[] args) {
        try {
            SimpleBean instance = assign(SimpleBean.class);
            System.out.println(instance);
        } catch (IllegalAccessException | InstantiationException e) {
            System.out.println("initialize failed");
        }
    }

    public static <T> T assign(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        T instance = tClass.newInstance();
        //get all declared methods including all access.
        Method[] methods = tClass.getDeclaredMethods();
        Field[] fields = tClass.getDeclaredFields();
        Random random = new Random();
        //循环所有的成员变量，并且给成员赋值
        Arrays.stream(fields).forEach(field -> {
            String fieldName = field.getName();
            //设置setter 方法
            String setMethodName = "set" + upperFirstLetter(fieldName);
            Method method = Arrays.stream(methods)
                    .filter(it -> it.getName().equalsIgnoreCase(setMethodName))
                    .findFirst()
                    .orElse(null);
            if (method == null) return;
            Class<?> type = field.getType();
            Object value = null;
            if (type == String.class) {
                value = fieldName + random.nextInt(100);
            } else if (type == Integer.class) {
                value = random.nextInt(10);
            } else if (type == Double.class) {
                value = Math.random() * 10;
            } else if (type == Long.class) {
                value = 10L;
            } else if (type == Date.class) {
                value = new Date();
            } else if (type == Boolean.class) {
                value = Boolean.FALSE;
            } else if (type == tClass) {
                System.out.println("不初始化相同类");
            } else {
                System.out.println(String.format("初始化非基础类型[%s]", type.getName()));
            }
            //调用setter设置值
            try {
                method.invoke(instance, value);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        return instance;
    }

    /**
     * 设置第一个大写
     *
     * @param str 待修改的字段
     * @return 第一个字符大写
     */
    public static String upperFirstLetter(String str) {
        if (str == null || str.length() == 0) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }


}