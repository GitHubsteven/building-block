package leetcode.daily;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/2/14
 * @description https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class _540_single_element_in_a_sorted_array {
    public static void main(String[] args) {
        int[] nums = {3};
        System.out.println(singleNonDuplicate(nums));
    }

    /**
     * 总数量 为2*N +1，i = n
     * if(num[i] ==num[i+1]) 那么表示single_number一定在（i+2,2*n）
     * 问题就化为在[i+2,2*n]中查找那个单数了
     * else single_num一定在[0,i-1]中
     *
     * @param nums 数列
     */
    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1, middle;
        while (left <= right) {
            if (left == right) return nums[left];
            middle = (right + left) / 2;
            if (nums[middle] == nums[middle + 1]) {
                if ((right - middle) % 2 == 0) {
                    left = middle + 2;
                } else {
                    right = middle - 1;
                }
            } else if (nums[middle] == nums[middle - 1]) {
                if ((middle - left) % 2 == 0) {
                    right = middle - 2;
                } else {
                    left = middle + 1;
                }
            } else {
                return nums[middle];
            }
        }
        return -1;
    }
}
