/**
 * @author: asx
 * @date: 2023/7/8
 * @descrition:
 */
package pers.asx.dataandstructure;

import divdeandconquer.QuickSort;

import java.util.Arrays;

/**
 * @author: asx
 * @date: 2023/7/8
 * @descrition: https://leetcode.cn/problems/two-sum-iii-data-structure-design/description/
 */
public class TwoSum {
    int[] numbers = new int[0];
    int size = 0;

    public TwoSum() {

    }

    public void add(int number) {
        int idx = getIdx(number);
        int[] newNumbers = new int[size + 1];
        if (idx > 0) {
            System.arraycopy(numbers, 0, newNumbers, 0, idx);
        }
        if (size > idx) {
            System.arraycopy(numbers, idx, newNumbers, idx + 1, size - idx);
        }
        newNumbers[idx] = number;
        numbers = newNumbers;
        size++;
    }

    private int getIdx(int number) {
        int idx = 0;
        for (int i = 0; i < size; i++) {
            if (number < numbers[i]) {
                idx = i;
                break;
            } else {
                // 如果大于等于当前的值，那么在后面插入
                idx = i + 1;
                // 如果i不是最后一位，并且小于后面的以为，那么就break;
                if ((i + 1 < size - 1) && (number < numbers[i + 1])) {
                    break;
                }
            }
        }
        return idx;
    }


    public boolean find(int value) {
        int idx;
        for (int i = 0; i < numbers.length; i++) {
            idx = Arrays.binarySearch(numbers, 0, i, value - numbers[i]);
            if (idx >= 0) {
                return true;
            } else {
                idx = Arrays.binarySearch(numbers, i + 1, numbers.length,
                        value - numbers[i]);
                if (idx >= 0)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        obj.add(3);
        obj.add(2);
        obj.add(1);
        System.out.println(obj.find(2));
        System.out.println(obj.find(3));
        System.out.println(obj.find(4));
        System.out.println(obj.find(5));
        System.out.println(obj.find(6));
    }
}
