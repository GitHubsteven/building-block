package com.variety.shop.indi.java8.stream;

import java.util.stream.Stream;

/**
 * function programming
 * <p>
 * Created by rongbin.xie on 2017/12/28.
 */
public class Chapter3 {
    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(1, 23, 4);
        /*
        如果调用如下函数1 ,那么操作2中，stream流将会被关闭
         */
//        System.out.println(addUp(numbers));                  //1

        Integer min = numbers.min((x, y) -> x - y).orElse(0);  //2
        System.out.println(min);

    }

    static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (x, y) -> x + y);
    }

    //迭代2

}
