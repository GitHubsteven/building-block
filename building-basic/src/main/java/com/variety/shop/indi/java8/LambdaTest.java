package com.variety.shop.indi.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * forEach 遇到异常会中断吗
 *
 * Created by rongbin.xie on 2018/2/28.
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.forEach(number -> {
            if(number ==3){
                throw new RuntimeException("number 不能为3");
            }
            System.out.println(number);
        });

        List<Integer> newNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
        newNumbers.parallelStream().forEach(System.out::println);

    }

    public void runTime(Function function){
        long start = System.currentTimeMillis();
    }
}
