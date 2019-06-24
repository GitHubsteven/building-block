package com.effective.java;

import java.util.function.BinaryOperator;

/**
 * Created by rongbin.xie on 2018/1/15.
 */
public class Main {
    public static void main(String[] args) {
        BinaryOperator<Integer> addInt = (x, y) -> x + y;
        Integer apply = addInt.apply(1, 3);
        System.out.println(apply);
    }
}
