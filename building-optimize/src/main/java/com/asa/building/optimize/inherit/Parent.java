package com.asa.building.optimize.inherit;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 17:15 2019/2/21.
 */
public class Parent {
    public void method1(int period) {
        System.out.println("method run first step1 ...");
        if (period == 2) {
            System.out.println("method interrupt... ");
            return;
        }
        System.out.println("parent.method1 completed");
    }
}