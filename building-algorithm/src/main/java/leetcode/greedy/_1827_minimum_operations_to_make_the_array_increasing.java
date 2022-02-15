package leetcode.greedy;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/2/15
 * @description https://leetcode-cn.com/problems/minimum-operations-to-make-the-array-increasing/
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class _1827_minimum_operations_to_make_the_array_increasing {
    public static void main(String[] args) {
        int[] nums = {8};
        System.out.println(minOperations(nums));
    }

    /**
     * 贪心算法，使nums[i+1] = nums[i] + 1，那么这就是最少操作数的
     *
     * @param nums 数列
     */
    public static int minOperations(int[] nums) {
        int operations = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) continue;
            operations += nums[i] + 1 - nums[i + 1];
            nums[i + 1] = nums[i] + 1;
        }
        return operations;
    }
}
