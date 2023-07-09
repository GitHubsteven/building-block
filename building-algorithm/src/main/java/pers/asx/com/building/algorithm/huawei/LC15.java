/**
 * @author: asx
 * @date: 2023/7/5
 * @descrition:
 */
package pers.asx.com.building.algorithm.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: asx
 * @date: 2023/7/5
 * @descrition: https://leetcode.cn/problems/3sum/?company_slug=huawei
 */
public class LC15 {
    public static void main(String[] args) {
        int[] nums = {
                -1, 0, 1, 2, -1, -4
        };
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // 如果全是整数或者全是负数，那么返回空数组
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> result = new ArrayList<>();
        // 暴力循环，a+b+c = 0，
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return result;
    }
}
