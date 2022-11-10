/**
 * @author: asx
 * @date: 2022/11/3
 * @descrition:
 */
package com.demo.asa.map;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * hash map 内存溢出
 * 参考文章：https://blog.csdn.net/riemann_/article/details/89426634
 */
public class HashMapHeapOverStockFlow {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(()->{

        });
    }
}
