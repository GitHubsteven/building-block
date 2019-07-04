package com.variety.shop.indi.reflect;

import java.util.List;

/**
 * 方法接口
 * <p>
 * Created by rongbin.xie on 2018/1/26.
 */
public interface IReflectMethod {
    static void introduce() {
        System.out.println("hi,i am IReflectMethod");
    }

    default void welcome() {
        System.out.println("welcome, IReflectMethod!");
    }

    void goodBye(Integer who);

    void goodByeMany(List<Integer> indexes);

}
