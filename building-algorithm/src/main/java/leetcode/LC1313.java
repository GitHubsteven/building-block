package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: url: https://leetcode.com/problems/decompress-run-length-encoded-list/
 * @Author jet.xie
 * @Date: Created at 18:01 2020/1/19.
 */
public class LC1313 {
    /**
     * <h4>decompress-run-length-encoded-list</h4>
     * <p>
     * We are given a list nums of integers representing a list compressed with run-length encoding.
     * <p>
     * Consider each adjacent pair of elements [a, b] = [nums[2*i], nums[2*i+1]] (with i >= 0).
     * For each such pair, there are a elements with value b in the decompressed list.
     * <p>
     * Return the decompressed list.
     * <p>
     * Input: nums = [1,2,3,4]
     * Output: [2,4,4,4]
     * Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
     * The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
     * At the end the concatenation [2] + [4,4,4,4] is [2,4,4,4].
     * <p>
     * 2 <= nums.length <= 100
     * nums.length % 2 == 0
     * 1 <= nums[i] <= 100
     */
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i = i + 2) {
            int freq = nums[i];
            int value = nums[i + 1];
            for (int j = 0; j < freq; j++) {
                list.add(value);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = new LC1313().decompressRLElist(nums);
        System.out.println(Arrays.toString(result));
    }

    public int[] decompressRLElistFastest(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length - 1; i += 2) n += nums[i];
        int[] run = new int[n];
        int k = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                run[k++] = nums[i + 1];
            }
        }
        return run;
    }
}