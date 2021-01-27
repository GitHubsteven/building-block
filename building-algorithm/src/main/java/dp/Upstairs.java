package dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/9
 * @Time: 9:08
 * @Description: dynamic programming -- upstairs question, upstairs to 2 n, 1 or 2 step once, how many choices totally
 * @version: 1.0.0
 */
public class Upstairs {
    public static void main(String[] args) {
//        System.out.println(dp(44));
        System.out.println(loop2(44));  //1134903170
    }

    static int dp(int n) {
        //0 表示原地不动，也有一种方式
        if (n == 0) return 1;
        if (n == 1) return 1;

        return dp(n - 1) + dp(n - 2);
    }

    static int loop(int n) {
        int[] stairs = new int[n];
        if (n < 2) {
            return 1;
        }
        stairs[0] = 1;
        stairs[1] = 2;
        for (int i = 2; i < n; i++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }
        return stairs[n - 1];
    }

    static int loop2(int n) {
        if (n < 2) {
            return 1;
        }
        if (n == 2) return 2;
        int n_2 = 1;
        int n_1 = 2;
        int cur = 0;
        for (int i = 2; i < n; i++) {
            cur = n_1 + n_2;
            n_2 = n_1;
            n_1 = cur;
        }
        return cur;
    }

}