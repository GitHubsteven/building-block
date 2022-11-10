/**
 * @author: asx
 * @date: 2022/11/3
 * @descrition:
 */
package com.demo.asa.map;

import org.junit.Assert;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1};
        int idex = binarySearch(nums, 2);
        Assert.assertEquals(-1, idex);
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        int mid = (left + right) / 2;
        while (left != right) {
            if (nums[mid] == target) {
                index = mid;
                break;
            }
            // 不等于逻辑
            if (nums[mid] < target) {
                // 大于中位数，取右部分
                left = mid;
                mid = (left + right) / 2;
            } else {
                // 小于中位数 ，取左部分
                right = mid;
                mid = (left + right) / 2;
            }
        }
        return nums[mid] == target ? mid : index;
    }
}
