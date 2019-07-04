package com.variety.shop.indi.supplier;

import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 14:48 2018/4/23.
 */
public class SupplierTest {
    public static void main(String[] args) {
//        calculateTime(100, SupplierTest::sum2N);
//        calculateTime("hello", SupplierTest::allLetter);
        calculateTime(SupplierTest::hi);
    }


    public static <T> void calculateTime(T t, Consumer<T> s) {
        System.out.println("start: " + System.currentTimeMillis());
        s.accept(t);
        System.out.println("end: " + System.currentTimeMillis());
    }


    public static <T> void calculateTime(IConsumerOperator operator) {
        System.out.println("start: " + System.currentTimeMillis());
        operator.operator();
        System.out.println("end: " + System.currentTimeMillis());
    }

    public static void hi() {
        System.out.println("hi");
//        return "hi";
    }

    public static int sum2N(int n) {
        int sum = IntStream.range(0, n).sum();
        System.out.println(sum);
        return sum;
    }

    public static void allLetter(String name) {
        for (char c : name.toCharArray()) {
            System.out.println(c);
        }
    }
}
