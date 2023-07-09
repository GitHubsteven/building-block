/**
 * @author: asx
 * @date: 2023/7/1
 * @descrition:
 */
package pers.asx.merge;

/**
 * @author: asx
 * @date: 2023/7/1
 * @descrition:
 */
public class LC169 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 4};
        int result = majorityElement(nums);
        System.out.println(result);
    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 2) {
            return nums[0];
        }
        return compare(0, nums.length - 1, nums);
    }

    public static int compare(int left, int right, int[] nums) {
        if (left == right) return nums[left];
        int mid = (left + right) / 2;
        int leftR = compare(left, mid, nums);
        int rightR = compare(mid + 1, right, nums);

        int leftRCount = count(leftR, left, right, nums);
        int rightRcount = count(rightR, left, right, nums);
        return leftRCount > rightRcount ? leftR : rightR;
    }

    public static int count(int target, int left, int right, int[] nums) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }
}
