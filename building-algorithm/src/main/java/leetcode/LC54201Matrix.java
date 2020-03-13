package leetcode;

import data.structure.book.graph.store.Matrix;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: url: https://leetcode.com/problems/01-matrix/
 * @Author asa.x
 * @Date: Created at 10:46 2020/3/12.
 */
public class LC54201Matrix {
    public static void main(String[] args) {
        LC54201Matrix main = new LC54201Matrix();
    }

    /**
     * Input:
     * [[0,0,0],
     * [0,1,0],
     * [1,1,1]]
     * <p>
     * Output:
     * [[0,0,0],
     * [0,1,0],
     * [1,2,1]]
     *
     * @param matrix matrix
     * @return distance of nearest 0 point
     */
    public int[][] updateMatrix(int[][] matrix) {
        //init the result matrix.
        int[][] result = new int[matrix.length][];
        for (int row_idx = 0; row_idx < matrix.length; row_idx++) {
            result[row_idx] = new int[matrix[row_idx].length];
        }

        return matrix;
    }

    public static int getPointNearestDis(int row_idx, int col_idx, int[][] matrix, int distance) {

    }

    public static int dfs(int row_idx, int col_idx, int[][] matrix, int distance) {
        if (matrix[row_idx][col_idx] == 0) return 0;
        if (matrix[row_idx - 1][col_idx] == 0)
    }
}