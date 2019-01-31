package com.asa.building.optimize.exception;

import util.LogTimeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: list 或者多个逻辑判断
 * 推测： 逻辑判断可能会占有优势，但是这的数据
 * list可以更加清晰的看到结构，代码比较好维护
 * 多个判断条件会导致判断语句比较复杂，不利于维护
 * <p>
 * 结果：
 * ----------执行次数：10
 * ----listOrArray: 7
 * ----logicOper: 5
 * diff(listOrArray-logicOper): 2
 * ----------执行次数：100
 * ----listOrArray: 13
 * ----logicOper: 27
 * diff(listOrArray-logicOper): -14
 * ----------执行次数：1000
 * ----listOrArray: 69
 * ----logicOper: 63
 * diff(listOrArray-logicOper): 6
 * ----------执行次数：10000
 * ----listOrArray: 161
 * ----logicOper: 214
 * diff(listOrArray-logicOper): -53
 * ----------执行次数：100000
 * ----listOrArray: 2314
 * ----logicOper: 1857
 * diff(listOrArray-logicOper): 457
 * <p>
 * 结论真不好确定，可能数据造的有问题，或者样本太小，不具有说服力。不过暂时这方面没有优化必要，为了可读性，推荐使用listOrArray
 * @Date: Created at 10:17 2019/1/11.
 */
public class ListOrMultiLogicOper {
    public static void main(String[] args) {
        for (int i = 10; i < 1000000; i *= 10) {
            System.out.println("----------执行次数：" + i);
            loopRun(i);
        }
    }

    private static void loopRun(int loop) {
        long runTime = LogTimeUtil.logTime(loop, ListOrMultiLogicOper::listOrArray);
        System.out.println("----listOrArray: " + runTime);

        long logicTime = LogTimeUtil.logTime(loop, ListOrMultiLogicOper::logicOper);
        System.out.println("----logicOper: " + logicTime);

        System.out.println("diff(listOrArray-logicOper): " + (runTime - logicTime));
    }

    public static void listOrArray() {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            data.add(i);
        }
        List<Integer> range = Arrays.asList(1, 5, 8, 10, 12, 24);
        for (Integer datum : data) {
            if (range.contains(datum)) {
//                System.out.println("------" + datum);
            }
        }
    }


    public static void logicOper() {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            data.add(i);
        }
        for (Integer datum : data) {
            if (Objects.equals(1, datum)
                    || Objects.equals(5, datum)
                    || Objects.equals(8, datum)
                    || Objects.equals(10, datum)
                    || Objects.equals(12, datum)
                    || Objects.equals(24, datum)) {
//                System.out.println("------" + datum);
            }
        }
    }
}