/**
 * @author: asx
 * @date: 2023/6/30
 * @descrition:
 */
package topk;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: asx
 * @date: 2023/6/30
 * @descrition: https://leetcode.cn/problems/top-k-frequent-elements/
 */
public class LC347topkfrequentelements {

    public static void main(String[] args) {
        int[] numbers = new int[]{-1, -1, 1, 1, 1, 2, 2, 3};
        int[] topKnumbers = topKFrequent(numbers, 3);
        System.out.println(Arrays.toString(topKnumbers));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // 前k的数字值，因为删除操作平凡，所以用linkedList
        int[] topKNo = new int[k];
        //记录数据对应点频次
        Map<Integer, Integer> numFrequent = new HashMap<>(nums.length);
        // 循环，从1开始，统计数据，此时时间复杂度为O(n)
        for (int num : nums) {
            // 获取数字num
            Integer freq = numFrequent.get(num);
            if (freq == null) {
                freq = 1;
            } else {
                freq = freq + 1;
            }
            numFrequent.put(num, freq);
        }
        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(numFrequent.entrySet());
        // 排序,快拍的时间复杂度为log(n)
        sortedEntries.sort((e1, e2) -> e1.getValue().compareTo(e2.getValue()) * -1);
        for (int i = 0; i < k; i++) {
            topKNo[i] = sortedEntries.get(i).getKey();
        }
        return topKNo;
    }

}
