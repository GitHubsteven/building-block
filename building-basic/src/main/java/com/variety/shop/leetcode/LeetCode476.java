package com.variety.shop.leetcode;

/**
 * Created by rongbin.xie on 2017/11/27.
 */
public class LeetCode476 {
    public static void main(String[] args) {
        Integer x = 2;
        String binaryString = Integer.toBinaryString(x);
        System.out.println(binaryString);
        int intValue = Integer.parseInt(binaryString, 2);
        System.out.println(intValue);
    }
}
