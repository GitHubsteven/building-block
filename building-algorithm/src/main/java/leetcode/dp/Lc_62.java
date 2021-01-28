package leetcode.dp;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/1/27
 * @description url: https://leetcode.com/problems/unique-paths/
 * @copyright COPYRIGHT © 2014 - 2021 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class Lc_62 {
    public static void main(String[] args) {
        Lc_62 main = new Lc_62();
        //1916797311
        final long start = System.currentTimeMillis();
        final int paths = main.dp(51, 9);
        System.out.println(paths);
        System.out.println(System.currentTimeMillis() - start);
    }

    public int dp(int m, int n) {
        if (m <= 1 || n <= 1) return 1;
        return dp(m - 1, n) + dp(m, n - 1);
    }


    public int loop(int m, int n) {
        if (m <= 1 || n <= 1) return 1;
        int[][] count = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i < 1 || j < 1) {
                    count[i][j] = 1;
                } else {
                    count[i][j] = count[i - 1][j] + count[i][j - 1];
                }
            }
        }
        return count[m - 1][n - 1];
    }
}
