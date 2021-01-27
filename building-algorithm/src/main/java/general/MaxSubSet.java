package general;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/9
 * @Time: 16:52
 * @Description: https://lucifer.ren/blog/2019/12/11/LSS/
 * @version: 1.0.0
 */
public class MaxSubSet {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(violence(nums));
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

    /**
     * 最大连续的子序列，设S(i）=Sum(0,...,i)
     * 1. 设S(k,j) = maxSum
     * 2. S(k,j) = S(j) - S(k)
     * 3. 如果想要S(k,j)->max == Max(Sum(j)) - Min(Sum(k))
     * <p>
     * 数据公式上是这样的，但是不知道实际上的数据变化不知道
     */
    public int mathAnalyze(int[] nums) {
        int maxSum = nums[0];
        int sum = 0;
        int minSum = 0;
        for (int num : nums) {
            // prefix sum
            sum += num;

            maxSum = Math.max(maxSum, sum - minSum);

            minSum = Math.min(minSum, sum);
        }
        return maxSum;
    }
}