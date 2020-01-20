package leetcode;

import java.util.Arrays;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: url: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 * @Author asa.x
 * @Date: Created at 14:28 2020/1/20.
 */
public class LC1295 {


    /**
     * Given an array nums of integers, return how many of them contain an even number of digits.
     * Example1:
     * <p>
     * Input: nums = [12,345,2,6,7896]
     * Output: 2
     * Explanation:
     * 12 contains 2 digits (even number of digits).
     * 345 contains 3 digits (odd number of digits).
     * 2 contains 1 digit (odd number of digits).
     * 6 contains 1 digit (odd number of digits).
     * 7896 contains 4 digits (even number of digits).
     * Therefore only 12 and 7896 contain an even number of digits.
     * <p>
     * Example 2:
     * Input: nums = [555,901,482,1771]
     * Output: 1
     * Explanation:
     * Only 1771 contains an even number of digits.
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 500
     * 1 <= nums[i] <= 10^5
     */
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (isEvenNumber2(num)) count++;
        }
        return count;
    }

    private boolean isEvenNumber(int number) {
        return String.valueOf(number).length() % 2 == 0;
    }

    private boolean isEvenNumber2(int number) {
        int size = 0;
        while (number != 0) {
            number = number / 10;
            size++;
        }
        return size % 2 == 0;
    }


    public static void main(String[] args) {
        LC1295 countEvenNumber = new LC1295();
        int[] numbers1 = {12, 345, 2, 6, 7896};
        int[] numbers2 = {555, 901, 482, 1771};
        System.out.println(countEvenNumber.findNumbers(numbers1));
        System.out.println(countEvenNumber.findNumbers(numbers2));
    }
}