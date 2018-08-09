package general;

import util.CollectionHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/9
 * @Time: 16:52
 * @Description:
 * @version: 1.0.0
 */
public class MaxSubSet {
    interface Status {
        String P2P = "00";
        String P2N = "01";
        String N2N = "11";
        String N2P = "10";
    }

    public static void main(String[] args) {
        int[] maxSubSet = new int[2];
        System.out.println(maxSubSet[1]);
    }

    /**
     * find the max sum subSet from given collection
     *
     * @param data given data collection
     * @return max sum subSet
     */
    static List<Integer> maxSubSet(int[] data) {
        List<Integer> maxSubSet = new ArrayList<>();
        List<Integer> negativeSet = new ArrayList<>();
        List<Integer> curPG = new ArrayList<>();
        List<Integer> nextPositiveSet = new ArrayList<>();
        // TODO: 2018/8/9 to realize
        return null;
    }
}