package leetcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/2/15
 * @description https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class _1380_lucky_numbers_in_a_matrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        System.out.println(luckyNumbers(matrix));
    }


    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        int min_col_idx, min;
        for (int[] value : matrix) {
            // 找出该行中最小的值的index
            min = value[0];
            min_col_idx = 0;
            for (int j = 0; j < value.length; j++) {
                if (value[j] < min) {
                    min_col_idx = j;
                    min = value[j];
                }
            }
            // 判断该只是否为该列中最大的值
            boolean isMax = true;
            for (int[] ints : matrix) {
                if (ints[min_col_idx] > min) {
                    isMax = false;
                    break;
                }
            }
            if (isMax) {
                luckyNumbers.add(min);
            }
        }
        return luckyNumbers;
    }
}
