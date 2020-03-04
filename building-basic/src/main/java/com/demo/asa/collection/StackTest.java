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
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

}