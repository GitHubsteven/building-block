package dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/8
 * @Time: 19:04
 * @Description:
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