package com.demo.asa.collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author asa.x
 * @Date: Created at 13:29 2020/3/2.
 */
public class QueueTest {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
        queue.add(1);
        queue.add(2);
        queue.offer(3);

        System.out.println(queue.poll());

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }


    }
}