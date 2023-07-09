/**
 * @author: asx
 * @date: 2023/7/7
 * @descrition:
 */
package pers.asx.com.building.algorithm.huawei;

import heap.Heap;

import java.util.Arrays;

/**
 * @author: asx
 * @date: 2023/7/7
 * @descrition:
 */
public class HeapDemo {
    public static void main(String[] args) {
        int[] nums = {
                1,3,4,4
        };
        int[] result = twoSum(nums, 8);
        System.out.println(Arrays.toString(result));
    }

    public static  int[] twoSum(int[] numbers, int target) {
        int r1_idx = -1;
        int r2_idx = -1;
        int temp;
        for (int i = 0; i < numbers.length; i++) {
            temp = numbers[i];
            int added_idx = Arrays.binarySearch(numbers, target - temp);
            if (added_idx == i) {
                added_idx = Arrays.binarySearch(numbers,
                        added_idx + 1, numbers.length, target - temp);
            }
            if (added_idx > -1) {
                r1_idx = i + 1;
                r2_idx = added_idx + 1;
                break;
            }
        }
        return new int[]{r1_idx, r2_idx};
    }
}
