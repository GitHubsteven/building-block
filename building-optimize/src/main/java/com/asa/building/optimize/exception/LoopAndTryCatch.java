package com.asa.building.optimize.exception;

import java.util.*;
import java.util.function.Consumer;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: 如何已处理异常才不会导致速度过慢呢？场景，在循环处理业务的过程中，我们要处理异常，在循环中处理异常
 * 问题：为什么在循环中处理异常会很慢呢？
 * 处理方式选择：
 * 1. 在循环中没有try-catch，直接返回exception，而不是throw，但是这里会有限制，返回的异常不一定能包含所有的异常
 * 2. 在循环中直接处理异常，这个当然是很慢的。
 *
 * 记录分析，
 * Times:              record(ms):             catch(ms):
 *   10               1                   0
 *  100               1                   0
 * 1000              22                   4
 * 10000              91                  44
 * 100000             402                 460
 *
 * 老实说，结合方式一和二，我并没有看出这两个有多大的速度差距，在增长次数达到100000几倍，catch的处理方式才会比较慢，但是，
 * 这点差距好像在这这个级别也不算什么吧
 *
 *
 *
 * @Date: Created at 12:13 2018/11/1.
 */
public class LoopAndTryCatch {
    public static void main(String[] args) {
        int max = 100000;
        Map<Integer, Long> recordEptMap = records(LoopAndTryCatch::recordept, max);
        Map<Integer, Long> catchEptMap = records(LoopAndTryCatch::catchept, max);
        System.out.println("Times:              record(ms):             catch(ms):");
        for (int i = 10; i <= max; i *= 10) {
            System.out.println(String.format("%4d            %4d                %4d",
                    i, recordEptMap.get(i), catchEptMap.get(i)));
        }
    }

    public static Map<Integer, Long> records(Consumer<Integer> consumer, int max) {
        Map<Integer, Long> records = new HashMap<>();
        for (int i = 10; i <= max; i *= 10) {
            long start = new Date().getTime();
            //业务代码
            consumer.accept(i);
            long end = new Date().getTime();
            records.put(i, (end - start));
        }
        return records;
    }

    public static void catchept(int loop) {
        for (int i = 0; i <= loop; i++) {
            try {
                throwEpt();
            } catch (Exception e) {
                //处理异常
                System.out.println();
            }
        }
    }
    public static void recordept(int loop) {
        List<Exception> eptList = new ArrayList<>();
        for (int i = 0; i <= loop; i++) {
            eptList.add(recordEpt());
        }
        //处理异常
        for (Exception ept : eptList) {
            System.out.println();
        }
    }

    public static void throwEpt() {
        throw new RuntimeException("test exception!");
    }

    public static Exception recordEpt() {
        return new RuntimeException("test exception!");
    }
}