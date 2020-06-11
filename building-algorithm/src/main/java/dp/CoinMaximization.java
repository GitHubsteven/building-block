package dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/8
 * @Time: 19:04
 * @Description: input: 输入一个硬币值的数组，不一定不相同
 * 要求：只能求互不相同的的硬币
 * 求：能收取到最多的硬币值
 * <p>
 * 分析下：对于最后一个硬币来说f(x),它会有两种情形
 * 1. val(x)被取， f(x) = val(x) + f(x -2)
 * 2. val(x)不会被取，那么f(x) = f(x-1)
 * <p>
 * 问题的关键在于如何到达val(x)
 * @version: 1.0.0
 */
public class CoinMaximization {
    private static int[] resultTracking = new int[100];
    private static int[] values = {5, 1, 2, 10, 6, 2};

    public static void main(String[] args) {
        for (int i = 0; i <= values.length; i++) {
            int max = getMax(i);
            resultTracking[i] = max;
            System.out.print(max + " ");
        }
    }

    static int getMax(int n) {
        if (n == 0) return 0;
        if (n == 1) return values[0];
        return Math.max(getMax(n - 1), getMax(n - 2) + values[n - 1]);
    }
}