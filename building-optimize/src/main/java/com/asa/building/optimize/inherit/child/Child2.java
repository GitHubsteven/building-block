package com.asa.building.optimize.inherit.child;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 15:21 2019/2/27.
 */
public class Child2 extends Parent {
    Child2() {
        setName("child2");
    }

    public static void main(String[] args) {
        Parent ins = new Child2();

        System.out.println(ins.getClass().getSimpleName());
    }
}