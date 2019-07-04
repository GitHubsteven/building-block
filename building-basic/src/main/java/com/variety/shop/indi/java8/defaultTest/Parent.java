package com.variety.shop.indi.java8.defaultTest;

/**
 * Created by rongbin.xie on 2018/1/26.
 */
public interface Parent {

    void message(String body);

    default void welcome() {
        message("Parent: Hi!");
    }

    String getLastMessage();
}
