package leetcode;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 15:59 2019/4/15.
 */
public class LC832 {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[][] A = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] A2 = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        for (int[] row : flipAndInvertImage(A2)) {
            for (int col : row) {
                System.out.print(" " + col);
            }
            System.out.println();
        }
    }

    /**
     * 1.Input: [[1,1,0],[1,0,1],[0,0,0]]
     * Output: [[1,0,0],[0,1,0],[1,1,1]]
     * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
     * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
     * <p>
     * 2.Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
     * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     */
    public static int[][] flipAndInvertImage(int[][] A) {
        int tmp;
        for (int[] row : A) {
            int idx = 0;
            while (idx < row.length % 2 + row.length / 2) {
                tmp = row[row.length - 1 - idx];
                row[row.length - 1 - idx] = 1 - row[idx];
                row[idx] = 1 - tmp;
                idx++;
            }
        }
        return A;
    }
}