package exhuast;

import util.CollectionHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/10
 * @Time: 10:24
 * @Description:
 * @version: 1.0.0
 */
public class SplitOrderE {
    public static void main(String[] args) {

    }

    static List<Collection<Integer>> splitOrder(List<Integer> goodsPrice, int MAX_AMOUNT, int MAX_GOOD_NO) {
        return null;
    }


    /**
     * 从一组数据中找出最接近某个值的子集集合，有多个返回多个,values的值小于target
     *
     * @param values     集合价值
     * @param maxAmount 子集最大数量
     * @param target     目标值
     * @return 符合情况的子集集合
     */
    static List<List<Integer>> findCombinesNearVal(List<Integer> values, int maxAmount, int target) {
        List<List<Integer>> totalCombines = new ArrayList<>();
        // 找出所有的组合Cm-1,Cm-2,....Cm-m;
        for (int i = 1; i <= maxAmount; i++) {
            List<List<Integer>> combines = CollectionHelper.combine((int[]) Objects.requireNonNull(CollectionHelper.listNumber2IntArr(values)), i);
            totalCombines.addAll(combines);
        }
        // 找出所有的小于等于target最接近的组合，也许有多个，把所有的都获取出来
        List<List<Integer>> matchedCombines = new ArrayList<>();
        // 最接近的值
        int nearestVal = 0;
        for (List<Integer> combine : totalCombines) {
            int sum = combine.stream().mapToInt(it -> it).sum();
            //如果大于目标或者小于当前nearestVal的值，那么跳过
            if (sum > target || sum < nearestVal) continue;
            //如果大于当前最近接target的话，那么，交换最近接值，并且把这个分组保存到匹配到的最接近的分组中
            if (sum > nearestVal) {
                nearestVal = sum;
                matchedCombines.clear();
                matchedCombines.add(combine);
            }
            if (sum == nearestVal) {
                matchedCombines.add(combine);
            }
        }

        return matchedCombines;
    }
}