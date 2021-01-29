package leetcode.dp;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/1/29
 * @description
 * @copyright COPYRIGHT © 2014 - 2021 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class Lc_121 {
    /**
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     * <p>
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transactions are done and the max profit = 0.
     */
    public static void main(String[] args) {
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(violence(prices));
    }

    /**
     * time out error
     *
     * @param prices 价格
     */
    public static int violence(int[] prices) {
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > sum) {
                    sum = prices[j] - prices[i];
                }
            }
        }

        return Math.max(sum, 0);
    }

    /**
     * let minBuyPrice = Infinity;
     * let maxProfit = 0;
     * <p>
     * for (let price of prices) {
     * if (price < minBuyPrice) {
     * minBuyPrice = price;
     * } else if (price - minBuyPrice > maxProfit) {
     * maxProfit = price - minBuyPrice;
     * }
     * }
     * <p>
     * return maxProfit;
     *
     * @param prices 价格数组
     */
    public static int dp(int[] prices) {
        int minBuyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minBuyPrice) {
                minBuyPrice = price;
            } else if (price - minBuyPrice > maxProfit) {
                maxProfit = price - minBuyPrice;
            }
        }

        return maxProfit;
    }
}
