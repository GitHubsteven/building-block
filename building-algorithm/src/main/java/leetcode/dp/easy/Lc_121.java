package leetcode.dp.easy;

/**
 * @Authoer: asa.x
 * @Date: 2021/1/25
 * @Descrition:
 */
public class Lc_121 {
    public static void main(String[] args) {
        ThreadLocal<Object> cache = new ThreadLocal<>();
        cache.set("a");
        cache.get();

        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(dp(prices));
    }

    /**
     * 股票的连续值之和
     *
     * @param prices 股票价格
     * @return 数字序列中的最大差距
     */
    public static int dp(int[] prices) {
        if (prices.length <= 0) return 0;
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public static int violence(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return Math.max(0, max);
    }
}
