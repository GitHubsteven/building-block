package leetcode;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 11:05 2019/4/16.
 */
public class LC53 {
    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(array));
    }

    /**
     * Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     *
     * @param nums 数组
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max = 0;
        int tmpSum = 0;
        boolean isPreNeg = false;
        for (int i = 0; i < nums.length - 1; i++) {
            int value = nums[i];
            if (value >= 0) {
                if (!isPreNeg) {
                    tmpSum += value;
                    max = Math.max(tmpSum, max);
                } else {
                    tmpSum = value;
                    max = Math.max(tmpSum, max);
                }
            } else {
                tmpSum = 0;
                isPreNeg = true;
            }
        }
        return max;
    }
}