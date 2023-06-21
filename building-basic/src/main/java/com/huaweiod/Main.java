/**
 * @author: asx
 * @date: 2023/6/21
 * @descrition:
 */
package com.huaweiod;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] strings = input.split(",");
        int length = strings.length;
        int[][] valueMatrix = new int[length][length];
        // -1表示没有计算过，0是有意义的
        for (int[] matrix : valueMatrix) {
            Arrays.fill(matrix, -1);
        }
        int max = 0, cur;
        // 循环计算两个string的值
        String raw = "";
        String col = "";
        boolean isDif;
        for (int i = 0; i < length; i++) {
            raw = strings[i];
            for (int j = 0; j < length; j++) {
                // 相同字符串没有必要比较
                if (i == j) {
                    valueMatrix[i][j] = 0;
                } else if ((valueMatrix[i][j] > -1)) {
                    // 比较过了的，跳过
                } else {
                    // 假设是不同的
                    isDif = true;
                    col = strings[j];
                    for (int k = 0; k < raw.length(); k++) {
                        for (int l = 0; l < col.length(); l++) {
                            if (raw.charAt(k) == col.charAt(l)) {
                                isDif = false;
                                // 如果存在相同的话，那么跳过，不需要比较了
                                break;
                            }
                        }
                    }
                    if (isDif) {
                        // 如果不同，那么计算值，并且和max比较
                        cur = raw.length() * col.length();
                        valueMatrix[i][j] = valueMatrix[j][i] = cur;
                        max = Math.max(cur, max);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
