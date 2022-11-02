package leetcode.greedy;

import java.util.Arrays;

public class _1874_min_multiply_sum {
    public static void main(String[] args) {
        int[] nums1 = {2,1,4,5,7}, nums2 = {3,2,4,8,6};
        System.out.println(minProductSum(nums1,nums2));
    }

    /**
     * https://leetcode-cn.com/problems/minimize-product-sum-of-two-arrays/
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum+= nums1[i]*nums2[nums1.length -i-1];
        }
        return sum;
    }
}
