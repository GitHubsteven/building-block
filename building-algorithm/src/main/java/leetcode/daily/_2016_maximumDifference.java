package leetcode.daily;

public class _2016_maximumDifference {
    public static void main(String[] args) {
        int[] numbers = {7,1,5,4};
        System.out.println(maximumDifference(numbers));
    }

    public static int maximumDifference(int[] nums) {
        int min = nums[0],max_diff = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            max_diff = Math.max(nums[i] - min,max_diff);
            if(min > nums[i]) min = nums[i];
        }
        return max_diff;
    }
}
