/**
 * @author: asx
 * @date: 2022/10/26
 * @descrition:
 */
package com.demo.asa.map;

import java.util.Arrays;

public class BinarySearchTest {
    public static void main(String[] args) {
        int[] numbers = new int[]{12, 3, 49, 5, 63, 6, 73, 2};
        Arrays.sort(numbers);
        int idx = Arrays.binarySearch(numbers, 63);
        System.out.println(numbers[idx]);
    }
}
