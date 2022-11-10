/**
 * @author: asx
 * @date: 2022/11/8
 * @descrition:
 */
package com.demo.asa.mszq;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 2, 3, 2, 4, 5, 4, 5, 5};
        int result = singleNumber(numbers);
        Assert.assertEquals("", 4, result);
    }

    public static int singleNumber(int[] numbers) {
        return bruceForce(numbers);
    }


    // 暴力法
    public static int bruceForce(int[] numbers) {
        Map<Integer, Integer> number2count = new HashMap<>();
        // 遍历映射 O(N)
        for (int number : numbers) {
            Integer cnt = number2count.get(number);
            if (cnt == null) {
                cnt = 1;
            } else {
                cnt++;
            }
            number2count.put(number, cnt);
        }
        int number = -1;
        // 遍历查找 O(m) M < N
        for (Integer key : number2count.keySet()) {
            if (Objects.equals(number2count.get(key), 1)) {
                number = key;
                break;
            }
        }
//        O(N) + O(m)
        return number;
    }


    public static int dp(int[] numbers) {
        Map<Integer, Integer> number2count = new HashMap<>();
        // 遍历映射
        for (int number : numbers) {
            Integer cnt = number2count.get(number);
            if (cnt == null) {
                cnt = 1;
            } else {
                cnt++;
            }
            number2count.put(number, cnt);
        }
        int number = -1;
        // 遍历查找
        for (Integer key : number2count.keySet()) {
            if (Objects.equals(number2count.get(key), 1)) {
                number = key;
                break;
            }
        }
        return number;
    }
}