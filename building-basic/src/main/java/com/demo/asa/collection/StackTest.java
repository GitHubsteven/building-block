package com.demo.asa.collection;

import java.util.*;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author asa.x
 * @Date: Created at 12:38 2020/3/2.
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stock = new Stack<>();
        stock.add(1);
        stock.add(2);
        stock.add(3);

        while (!stock.isEmpty()) {
            System.out.println(stock.pop());
        }

        System.out.println("-----------------------");
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        while (!deque.isEmpty()) {
            System.out.println(deque.pollFirst());
            ;
        }
    }
}