package leetcode.greedy;

import javafx.collections.transformation.SortedList;

import java.util.Arrays;
import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/2/15
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class _2160_minimum_sum_of_four_digit_number_after_splitting_digits {
    public static void main(String[] args) {
        System.out.println(bruce_force(4009));
    }

    public static int bruce_force(int num) {
        int[] numbers = new int[4];
        for (int i = 0; i < 4; i++) {
            numbers[i] = num % 10;
            num = num / 10;
        }
        Arrays.sort(numbers);
        return (numbers[0] + numbers[1]) * 10 + (numbers[2] + numbers[3]);
    }
}
