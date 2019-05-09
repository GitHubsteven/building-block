package com.idv.converter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 11:16 2019/5/9.
 */
public interface IBox<T> {
//    /**
//     * 增加一个元素
//     *
//     * @param ele 元素
//     */
//    void add(T ele);

    /**
     * 获取元素
     *
     * @return 获取到的元素，可以为空
     */
    T get();
}