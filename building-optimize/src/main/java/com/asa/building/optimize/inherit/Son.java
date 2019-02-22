package com.asa.building.optimize.inherit;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 继承还是有坑啊，return可以作用于父类，但是不能作用于子类
 * @Date: Created at 17:17 2019/2/21.
 */
public class Son extends Parent {
    @Override
    public void method1(int period) {
        super.method1(period);
        if (period == 2) {
            System.out.println("son.method1 should return when period = " + period);
        }
        System.out.println("son method1 execute...");
        System.out.println("son method1 completed!");
    }

    public static void main(String[] args) {
        Parent son = new Son();
        son.method1(2);
    }
}