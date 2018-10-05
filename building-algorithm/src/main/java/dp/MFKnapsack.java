package dp;

import util.CollectionHelper;

public class MFKnapsack {
    private static int[] val = {12, 10, 20, 15};
    private static int[] weight = {2, 1, 3, 2};
    private static int max_weight = 5;

    private static int[][] result = new int[val.length + 1][max_weight + 1];

    //初始化result
    static {
        for (int i = 1; i < val.length + 1; i++) {
            int[] tmp = result[i];
            for (int k = 1; k < max_weight + 1; k++) {
                result[i][k] = -1;
            }
        }
    }


    public static void main(String[] args) {
        CollectionHelper.print2Dimension(result);
        for (int i = 1; i <= val.length; i++) {
            for (int j = 1; j <= max_weight; j++) {
                mfKnapsack(i, j);
            }
        }
        System.out.println("=====================");
        CollectionHelper.print2Dimension(result);


    }

    /**
     * @param i 第n个物品
     * @param j 背包可承受的重量
     */
    public static int mfKnapsack(int i, int j) {
        int w_index = i - 1;
        int v_index = i - 1;
        if (result[i][j] < 0) {
            if (j < weight[w_index]) {
                result[i][j] = mfKnapsack(i - 1, j);
            } else {
                result[i][j] = Math.max(mfKnapsack(i - 1, j), val[v_index] + mfKnapsack(i - 1, j - weight[w_index]));
            }
        }
        return result[i][j];
    }
}
