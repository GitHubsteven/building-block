package general;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/9
 * @Time: 16:52
 * @Description:
 * @version: 1.0.0
 */
public class MaxSubSet {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(violence(nums));
    }

    /**
     * find the max sum subSet from given collection
     *
     * @param data given data collection
     * @return max sum subSet
     */
    static List<Integer> maxSubSet(int[] data) {
        return null;
    }

    public static int violence(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Integer.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static int dp(int[] nums) {
        int currMaxSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currMaxSum = Math.max(currMaxSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currMaxSum);
        }
        return maxSum;
    }

    public int fasterButOccupied(int[] nums) {
        int maxSub = nums[0], curSum = 0;
        for (int num : nums) {
            if (curSum <= 0)
                curSum = 0;
            curSum += num;
            maxSub = Math.max(maxSub, curSum);
        }
        return maxSub;
    }
}