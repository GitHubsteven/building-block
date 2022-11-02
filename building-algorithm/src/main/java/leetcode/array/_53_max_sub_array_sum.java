package leetcode.array;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/2/15
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class _53_max_sub_array_sum {
    public static void main(String[] args) {
        int[] nums = {1};
        bruce_force(nums);
        kadane(nums);
    }

    /**
     * O(n^2)
     *
     * @param nums 数列
     */
    public static int bruce_force(int[] nums) {
        int max = Integer.MIN_VALUE, curSum = 0;
        int from = 0, to = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum = 0;
            for (int j = i; j < nums.length; j++) {
                curSum += nums[j];
                if (curSum > max) {
                    max = curSum;
                    from = i;
                    to = j;
                }
            }
        }
        System.out.printf("max sum is: %d, from:%d->to:%d\n", max, from + 1, to + 1);
        return max;
    }

    /**
     * kadane算法,O(n)
     *
     * @param nums 数组
     */
    public static int kadane(int[] nums) {
        int max = Integer.MIN_VALUE, curSum = 0;
        int curFrom = 0;
        int maxFrom = 0, maxTo = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum > max) {
                max = curSum;
                maxTo = i;
                maxFrom = curFrom;
            }
            if (curSum < 0) {
                curSum = 0;
                curFrom = i + 1;
            }
        }
        System.out.printf("max sum is: %d, from:%d->to:%d\n", max, maxFrom + 1, maxTo + 1);
        return max;
    }
}
