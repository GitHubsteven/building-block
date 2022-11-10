/**
 * @author: asx
 * @date: 2022/11/3
 * @descrition:
 */
package com.demo.asa.ebay;

import java.util.List;

public class Round2 {
    public static void main(String[] args) {

    }

    /**
     * 只有一个入参
     * 6,5,4,3,2,1,0
     *
     * @param x
     * @return
     */
    public static void dec(int x) {
        // 打印
        System.out.println(x);
        if (x < 0) {
            // 遇到 < 0 ,结束
            return;
        }
        dec(x - 1);
    }

    /**
     * 0,1,2,3,4,5,6
     *
     * @param x
     * @return
     */
    public static void inc(int x) {
        if (x < 0) {
            // 遇到 < 0 ,结束
            return;
        }
        inc(x - 1);
        System.out.println(x);
    }
}
