package brute.force;

import java.util.Arrays;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2020/7/18
 * @description: 选择算法
 * @copyright COPYRIGHT © 2014 - 2020 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] numbers = {89, 45, 68, 90, 29, 34, 17};
        sort(numbers);
    }

    public static void sort(int[] numbers) {
        System.out.println("numbers before sort: " + Arrays.toString(numbers));
        int swapTemp;
        for (int i = 0; i < numbers.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIdx]) minIdx = j;
            }
            swapTemp = numbers[i];
            numbers[i] = numbers[minIdx];
            numbers[minIdx] = swapTemp;
        }
        System.out.println("numbers after sort: " + Arrays.toString(numbers));

    }
}
