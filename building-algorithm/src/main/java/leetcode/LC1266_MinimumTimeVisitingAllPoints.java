package leetcode;

import com.sun.org.apache.bcel.internal.generic.PopInstruction;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: url：https://leetcode.com/problems/minimum-time-visiting-all-points/
 * @Author asa.x
 * @Date: Created at 16:08 2020/1/21.
 */
public class LC1266_MinimumTimeVisitingAllPoints {
    /**
     * On a plane there are n points with integer coordinates points[i] = [xi, yi]. Your task is to find the minimum time in seconds to visit all points.
     * <p>
     * You can move according to the next rules:
     * <p>
     * In one second always you can either move vertically, horizontally by one unit or diagonally (it means to move one unit vertically and one unit horizontally in one second).
     * You have to visit the points in the same order as they appear in the array.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: points = [[1,1],[3,4],[-1,0]]
     * Output: 7
     * Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
     * Time from [1,1] to [3,4] = 3 seconds
     * Time from [3,4] to [-1,0] = 4 seconds
     * Total time = 7 seconds
     * Example 2:
     * <p>
     * Input: points = [[3,2],[-2,2]]
     * Output: 5
     * <p>
     * <p>
     * Constraints:
     * <p>
     * points.length == n
     * 1 <= n <= 100
     * points[i].length == 2
     * -1000 <= points[i][0], points[i][1] <= 1000
     */

    public int minTimeToVisitAllPoints(int[][] points) {
        return normal(points);
    }


    public int normal(int[][] points) {
        int sum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            sum = sum + minPath(points[i], points[i + 1]);
        }
        return sum;
    }

    private int minPath(int[] start, int[] end) {
        return Math.max(Math.abs(end[0] - start[0]), Math.abs(end[1] - start[1]));
    }

    public static void main(String[] args) {
        LC1266_MinimumTimeVisitingAllPoints main = new LC1266_MinimumTimeVisitingAllPoints();
        int[][] points = {{3, 2}, {-2, 2}};
        int minTimeToVisitAllPoints = main.minTimeToVisitAllPoints(points);
        System.out.println(minTimeToVisitAllPoints);
    }
}