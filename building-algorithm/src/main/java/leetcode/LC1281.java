package leetcode;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * @Author asa.x
 * @Date: Created at 16:25 2020/1/20.
 */
public class LC1281 {
    /**
     * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
     * <p>
     * Example 1:
     * <p>
     * Input: n = 234
     * Output: 15
     * Explanation:
     * Product of digits = 2 * 3 * 4 = 24
     * Sum of digits = 2 + 3 + 4 = 9
     * Result = 24 - 9 = 15
     * Example 2:
     * <p>
     * Input: n = 4421
     * Output: 21
     * Explanation:
     * Product of digits = 4 * 4 * 2 * 1 = 32
     * Sum of digits = 4 + 4 + 2 + 1 = 11
     * Result = 32 - 11 = 21
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= n <= 10^5
     */
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while (n != 0) {
            int val = n % 10;
            n = n / 10;
            sum = sum + val;
            product = product * val;
        }
        return product - sum;
    }

    public static void main(String[] args) {
        LC1281 lc1281 = new LC1281();
        System.out.println(lc1281.subtractProductAndSum(234));
        System.out.println(lc1281.subtractProductAndSum(4421));
    }
}