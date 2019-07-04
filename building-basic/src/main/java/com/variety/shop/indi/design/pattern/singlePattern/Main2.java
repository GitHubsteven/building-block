package com.variety.shop.indi.design.pattern.singlePattern;

/**
 * Created by rongbin.xie on 2017/10/26.
 */
public class Main2 {
    public static void main(String[] args) {
        BaseSpringTestException exception = BaseSpringTestException.newInstance();
        BaseSpringTestException exception3 = BaseSpringTestException.newInstance();
//        BaseSpringTestException exception2 = new BaseSpringTestException();

//        System.out.println(Objects.equals(exception.hashCode(),exception2.hashCode())+
//                String.format(" exception hashCode：%s, exception2 hashCode: %s",exception.hashCode(),exception2.hashCode()));
//        assert exception == exception3;
        System.out.println(exception == exception3);
    }
}
