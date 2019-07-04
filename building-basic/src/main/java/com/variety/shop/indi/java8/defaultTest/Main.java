package com.variety.shop.indi.java8.defaultTest;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * 主类
 * <p>
 * Created by rongbin.xie on 2018/1/26.
 */
public class Main {
    public static void main(String[] args) {
        Parent parent = new OverridingParent();
        parent.welcome();
//        System.out.println(parent.getLastMessage());
//        Stream
    }

}
