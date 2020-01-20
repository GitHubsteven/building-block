package leetcode;

import org.springframework.beans.factory.NoUniqueBeanDefinitionException;

import java.sql.SQLOutput;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: url: https://leetcode.com/problems/maximum-69-number/
 * @Author asa.x
 * @Date: Created at 16:32 2020/1/20.
 */
public class LC1323 {
    /**
     * Given a positive integer num consisting only of digits 6 and 9.
     * <p>
     * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
     * <p>
     * Example 1:
     * <p>
     * Input: num = 9669
     * Output: 9969
     * Explanation:
     * Changing the first digit results in 6669.
     * Changing the second digit results in 9969.
     * Changing the third digit results in 9699.
     * Changing the fourth digit results in 9666.
     * The maximum number is 9969.
     * Example 2:
     * <p>
     * Input: num = 9996
     * Output: 9999
     * Explanation: Changing the last digit 6 to 9 results in the maximum number.
     * Example 3:
     * <p>
     * Input: num = 9999
     * Output: 9999
     * Explanation: It is better not to apply any change.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= num <= 10^4
     * num's digits are 6 or 9.
     */
    public int maximum69Number(int num) {
        int[] numbers = new int[4];
        int index = numbers.length - 1;
        while (num != 0) {
            numbers[index--] = num % 10;
            num = num / 10;
        }

        int result = 0;
        boolean isChanged = false;
        for (int i = 0; i < numbers.length; i++) {
            int value = numbers[i];
            if (value == 0) continue;
            if (value == 6 && !isChanged) {
                isChanged = true;
                value = 9;
            }
            result = result + value * pow(10, numbers.length - 1 - i);
        }
        return result;
    }

    private int pow(int background, int index) {
        int result = 1;
        for (int i = 0; i < index; i++) {
            result = result * background;
        }
        return result;
    }

    public static void main(String[] args) {
        LC1323 lc1323 = new LC1323();
        System.out.println(lc1323.maximum69Number(9669));
        System.out.println(lc1323.maximum69Number(9996));
        System.out.println(lc1323.maximum69Number(9999));
    }

}