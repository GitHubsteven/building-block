package com.asa.building.optimize.inherit.child;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 15:20 2019/2/27.
 */
public class Child extends Parent {
    public Child() {
        setName("child1");
    }

    public static void main(String[] args) {
        String template = "上海市浦东新区张江镇498上海市上海市上海市";
        String newStr = template.replaceFirst("上海市", "");
        System.out.println(newStr);
    }
}