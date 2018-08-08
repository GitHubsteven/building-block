package dp;

import static java.lang.Math.max;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/7
 * @Time: 16:59
 * @Description:
 * @version: 1.0.0
 */
public class PackageQuestion {
    private static int PACKAGE_MAX = 21;

    public static void main(String[] args) {
        int[] goodWeights = {2, 7, 9, 10, 17};
        int[] revert = {9, 8, 6, 5, 2};
        int maxLimited = backPack(PACKAGE_MAX, revert);
        System.out.println(maxLimited);
    }

    /**
     * 最大价值
     *
     * @param goodValues
     * @param packageMax
     */
    public static void maxVal(int[] goodValues, int packageMax) {

    }

    /**
     * 最大数量
     *
     * @param goodValues
     * @param packageMax
     */
    public static void maxNumber(int[] goodValues, int packageMax) {

    }

    public static int backPack(int limit, int[] numbers) {
        // write your code here
        if (numbers == null || 0 == numbers.length || limit == 0)
            return 0;
        int len = numbers.length;
        //初始化决策表
        int[][] statusTab = new int[len][limit + 1];
        for (int i = 0; i < len; i++) {
            statusTab[i][0] = 0;
        }
        for (int j = 0; j < limit + 1; j++) {
            if (j >= numbers[0]) {
                statusTab[0][j] = numbers[0];
            }
        }
        printDArray(statusTab);

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < limit + 1; j++) {
                if (j >= numbers[i]) {
                    statusTab[i][j] = max(statusTab[i - 1][j], statusTab[i - 1][j - numbers[i]] + numbers[i]);
                } else {
                    statusTab[i][j] = statusTab[i - 1][j];
                }
            }
        }
        System.out.println("===========================================");
        printDArray(statusTab);
        return statusTab[len - 1][limit];
    }

    static void printDArray(int[][] data) {
        for (int[] raw : data) {
            for (int ele : raw) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}