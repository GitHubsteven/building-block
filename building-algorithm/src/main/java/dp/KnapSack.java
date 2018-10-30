package dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/9
 * @Time: 15:37
 * @Description:
 * @version: 1.0.0
 */
public class KnapSack {
    private static int[] val = {12, 10, 20, 15};
    private static int[] weight = {2, 1, 3, 2};

    public static void main(String[] args) {
        int MAX_WEIGHT = 5;
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= MAX_WEIGHT; j++) {
                System.out.print(String.format("%02d ", getMaxVal(i, j)));
            }
            System.out.println();
        }
//        int track = trackBack(37, 4, 5);
    }

    /**
     * 获取当第几件物品的时候，背包重量为packageWeight的时候的最大价值量
     *
     * @param goodNo        第几件物品，从1开始，但计算从1开始
     * @param packageWeight 可以从0开始
     * @return 对应的最大价值量
     */
    static int getMaxVal(int goodNo, int packageWeight) {
        if (goodNo <= 0) return 0;
        if (packageWeight <= 0) return 0;

        int goodIndex = goodNo - 1;
        int wi = weight[goodIndex];
        int vi = val[goodIndex];
        if (wi > packageWeight) return getMaxVal(goodIndex, packageWeight);
        return Math.max(getMaxVal(goodNo - 1, packageWeight), getMaxVal(goodNo - 1, packageWeight - wi) + vi);
    }

    /**
     * 回溯
     *
     * @param value         当前价值
     * @param goodNo        物品号
     * @param packageWeight 背包重量，不为0
     * @return 被选择的物品
     */
    static int trackBack(int value, int goodNo, int packageWeight) {
        if (value == 0) {
            System.out.println(String.format("goodNo: %s", "stop"));
            return 0;
        }
        int goodIndex = goodNo - 1;
        int wi = weight[goodIndex];
        int vi = val[goodIndex];
        int lastStepMaxValueNoThis = getMaxVal(goodNo - 1, packageWeight);
        if (lastStepMaxValueNoThis == value) {
            System.out.println(String.format("goodNo: %s 没有被选择", goodNo));
            return trackBack(value, goodNo - 1, packageWeight);
        } else {
            System.out.println(String.format("goodNo: %s 被选择", goodNo));
            value = value - vi;
            return trackBack(value, goodNo - 1, packageWeight - wi);
        }
    }
}