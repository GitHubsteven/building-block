package com.demo.asa.java8;

import java.util.LinkedList;
import java.util.List;

/**
 * @Authoer: asa.x
 * @Date: 2020/2/12
 * @Descrition:
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(10);
        list.add(12);

        System.out.println(list.poll());
        System.out.println(list);
    }
}
