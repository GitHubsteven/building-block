package dp;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/9
 * @Time: 13:39
 * @Description: grid n*m，some have coin but some not.one robot from top-left to right-bottom,
 * robot can only move rightly or down, find the way that the robot can collect the most coins
 * @version: 1.0.0
 */
public class RobotCoinCollection {
    public static void main(String[] args) {
        int[][] grid = new int[10][6];
        Random random = new Random();
        for (int[] raw : grid) {
            for (int col : raw) {
                col = random.nextInt(2);
            }
        }
//        CollectionHelper.print2Demension(grid);
    }

    static int robotCoinCollection(int[][] grid) {
        return 0;
    }

    /**
     * 在 raw, column点收集到最大的数量
     * 分析：
     * maxCol（x,y） = max{max(maxCol(x-1,y),maxCol(x,y-1))}
     *
     * @param grid   grid
     * @param raw    start from 1
     * @param column start from 1
     * @return max collections number
     */
    static int maxCol(int[][] grid, int raw, int column) {
        if (raw < 1) return 0;
        if (column < 1) return 0;
        if (raw == 1 && column == 1) return grid[0][0];

        return Math.max(maxCol(grid, raw - 1, column), maxCol(grid, raw, column)) + grid[raw][column];
    }
}