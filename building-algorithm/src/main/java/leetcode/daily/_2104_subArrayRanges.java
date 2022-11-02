package leetcode.daily;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/3/4
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class _2104_subArrayRanges {
    public static void main(String[] args) {
        int[] numbers = {1,3};
        System.out.println(brute_force(numbers));
    }

    public static long subArrayRanges(int[] nums) {
        return 0L;
    }


    public static long brute_force(int[] nums) {
        if (nums == null || nums.length == 1) return 0;
        long range = 0;
        int subMin;
        int subMax;
        for (int start = 0; start < nums.length - 1; start++) {
            subMax = nums[start];
            subMin = nums[start];
            for (int j = start + 1; j < nums.length; j++) {
                subMax = Math.max(subMax, nums[j]);
                subMin = Math.min(subMin, nums[j]);
                range += subMax - subMin;
            }
        }
        return range;
    }
}
