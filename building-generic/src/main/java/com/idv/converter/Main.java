package com.idv.converter;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 11:23 2019/5/9.
 */
public class Main {
    public static void main(String[] args) {
        CommonBox<Long> box = getBox();
        Long x = box.get();
        System.out.println(x);
    }

    private static CommonBox<Long> getBox() {
        //这个数据也许是第三方的库如ObjectMapper等
        CommonBox box = new CommonBox("asa");
        return box;
    }

    private static CommonBox<Long> getBox1() {
        //此时如果你不能确定类型
        CommonBox box = new CommonBox(123L);
        //转化类型
        return new CommonBox<>((Long) box.get());
    }


    private static <T> CommonBox<T> getBox(Class<T> tClass) {
        //这个数据也许是第三方的库如ObjectMapper等
        T t;
        try {
            t = tClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("instance exception!");
        }
        return new CommonBox<>(t);
    }
}