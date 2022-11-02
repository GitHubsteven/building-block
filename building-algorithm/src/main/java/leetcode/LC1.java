package leetcode;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/1/23
 * @description
 * @copyright COPYRIGHT © 2014 - 2021 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class LC1 {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        final int[] idxes = twoSum(nums, target);
        assert idxes != null;
        System.out.printf("%d %d%n", idxes[0], idxes[1]);
    }

    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return null;
    }
}
