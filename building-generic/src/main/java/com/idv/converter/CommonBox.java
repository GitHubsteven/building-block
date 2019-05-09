package com.idv.converter;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 11:18 2019/5/9.
 */
public class CommonBox<T> implements IBox<T> {

    private T value;

    public CommonBox(T val) {
        this.value = val;
    }


//    @Override
//    public void add(T ele) {
//
//    }

    @Override
    public T get() {
        return value;
    }
}