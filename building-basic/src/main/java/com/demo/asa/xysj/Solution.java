/**
 * @author: asx
 * @date: 2022/11/10
 * @descrition:
 */
package com.demo.asa.xysj;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Solution {
    public static void main(String[] args) {
        // 65 - 57
//        跳过  80 = x*36*10 +z = (80/36) *10 + (80%36) = 2 + 8
        // f(2) = 2 < 9 ? x: (char) +65
        // 转化公式
        // 1. 数字 - 48
        // 2. 字母的话 -65
        for (int i = 7280; i <= 7299; i++) {
            System.out.println(i + " -> " + numToString(7280));
        }

    }


    public static String numToString(int intValue) {
        Deque<String> stack = new ArrayDeque<>();
        // 至少执行一次
        do {
            // 取余数，余0，会转吗
            int divideR = intValue % 36;
            // 取整除
            intValue = intValue / 36;
            stack.push(getString(divideR));
        } while (intValue > 36);
        // 不小于0，那么转化，否则不转化
        if (intValue != 0) {
            stack.push(getString(intValue));
        }
        // 7209 = 720 +9 = 36 * 200 + 9;   = 200 > 36 ?  numToString(intValue) + numToString(%)
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static String getString(int rangeIntVal) {
        return rangeIntVal >= 0 && rangeIntVal <= 9
                ? String.valueOf(rangeIntVal) : String.valueOf((char) (rangeIntVal + 55));
        // A = 65 = 55 + 10;

    }
}
