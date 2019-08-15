package leetcode;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 10:31 2019/8/15.
 */
public class LC807 {
    public static void main(String[] args) {
//        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
//        System.out.println(maxIncreaseKeepingSkyline(grid));
        int[][] grid2 = {{1, 2, 3}};
        System.out.println(maxIncreaseKeepingSkyline(grid2));
    }


    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int inc_sum = 0;
        int[] row_max = new int[grid.length];
        int col_number = grid[0].length;
        int[] col_max = new int[col_number];
        //先求出left/right skyline
        for (int row = 0; row < grid.length; row++) {
            int max = 0;
            for (int number : grid[row]) {
                if (max < number) max = number;
            }
            row_max[row] = max;
        }
        //求出top/bottom的skyline
        for (int col = 0; col < col_number; col++) {
            int max = 0;
            for (int[] aGrid : grid) {
                if (aGrid[col] > max) max = aGrid[col];
            }
            col_max[col] = max;
        }
        //统计增加的数目
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < col_number; col++) {
                int inc = Math.min(row_max[row], col_max[col]) - grid[row][col];
                if (inc > 0) inc_sum += inc;
            }
        }
        return inc_sum;
    }
}