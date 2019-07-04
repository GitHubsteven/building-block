package com.variety.shop.indi.report;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dell on 2017/2/12.
 */
public class DealData {

    public void showAllValues(ShopDailyBean shopDailyBean) {
        Field[] fields = shopDailyBean.getClass().getDeclaredFields();      //获取当前类所拥有的public 属性
        Method [] Methods=shopDailyBean.getClass().getDeclaredMethods();   //获取当前类所在的公共方法

        Field[] basePubFields = shopDailyBean.getClass().getSuperclass().getDeclaredFields();      //获取当前类所拥有的public 属性
        Field[] baseFields = shopDailyBean.getClass().getSuperclass().getFields();
//        System.out.println(shopDailyBean.getClass().getSuperclass().getSimpleName());
        List< Field > list= Arrays.asList(baseFields);
        List< Method > list1= Arrays.asList(Methods);
//        list1.forEach(Object -> System.out.println(Object.getName()));
        list.forEach(Object -> System.out.println(Object.getName().substring(0,1).toUpperCase()+Object.getName().substring(1)));
    }

    public static void main(String[] args) {
        DealData d = new DealData();
        d.showAllValues(StaticClassOne.shopDailyBeanList.get(0));  //ShopDailyBean
   /*     ShopDailyBean sdb = StaticClassOne.shopDailyBeanList.get(0);
        String methodName = "getShopDailyAttr1";
        String arrayName = "returnArray";
        Class sdbc = ShopDailyBean.class;
//
//        Arrays.asList(sdbc.getMethods()).forEach(Object -> System.out.println(Object.getName()));
        System.out.println("------------------------------");
//        Arrays.asList(sdbc.getDeclaredMethods()).forEach(Object -> System.out.println(Object.getName()));
        Method method1 = null ;
        Method methodArray = null ;
        try {
            method1 = sdbc.getMethod(methodName, new Class []{});
            methodArray = sdbc.getMethod(arrayName, new Class []{});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        //一直方法名称，根据方法名称，获取方法名返回的值
        Object value= null;
        Integer []  arrayValue = null;
        List<Integer> valueList = null;
        try {
            value = method1.invoke(sdb);
            arrayValue = (Integer[]) methodArray.invoke(sdb);
            valueList = Arrays.asList(arrayValue);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        valueList.forEach(Object -> {
            System.out.println(Object);
        });*/

     /*   String sValue = (String) value;
        System.out.println(sValue);*/
    }
}
