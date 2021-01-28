package leetcode.dp;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/1/28
 * @description https://leetcode.com/problems/minimum-path-sum/
 * @copyright COPYRIGHT © 2014 - 2021 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class Lc_64 {
    public static void main(String[] args) {
        int[][] grid = {{1}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        final int row = grid.length;
        final int col = grid[0].length;
        // 处理第一行
        for (int i = 1; i < col; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        // 处理第一列
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[row - 1][col - 1];
    }

    public static int normalDp(int[][] grid) {
        final int row = grid.length;
        final int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                }
            }
        }
        return grid[row - 1][col - 1];
    }

}
