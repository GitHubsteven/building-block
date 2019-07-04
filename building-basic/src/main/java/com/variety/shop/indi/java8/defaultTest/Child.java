package com.variety.shop.indi.java8.defaultTest;

/**
 * Created by rongbin.xie on 2018/1/26.
 */
public interface Child extends Parent {
    @Override
    default void welcome() {
        message("Child:hi!");
    }
}
