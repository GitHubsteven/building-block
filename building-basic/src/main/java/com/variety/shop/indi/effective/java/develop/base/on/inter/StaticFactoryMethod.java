package com.variety.shop.indi.effective.java.develop.base.on.inter;

/**
 * Created by rongbin.xie on 2017/12/7.
 */
public class StaticFactoryMethod {
    public static void main(String[] args) {
        int i =2;
        Boolean b1 = Boolean.valueOf(i == 0);
        Boolean b2 = Boolean.valueOf(i == 1);
        System.out.println(b1 = b2);


        Boolean a1 = new Boolean(i ==0);
        Boolean a2 = new Boolean(i ==1);
        System.out.println(a1 == a2);

        System.out.println("======================");
        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());
        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());

    }
}
