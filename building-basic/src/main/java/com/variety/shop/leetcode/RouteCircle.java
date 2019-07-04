package com.variety.shop.leetcode;

/**
 * Created by rongbin.xie on 2017/9/19.
 */
public class RouteCircle {
    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
    }

    private static boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        char[] chars = moves.toCharArray();
        for (char c : chars) {
            switch (c) {
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                default:
                    throw new RuntimeException("invalid character");
            }
        }
        return x == 0 && y == 0;
    }
}
