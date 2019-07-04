package com.variety.shop.leetcode;

/**
 * Created by rongbin.xie on 2017/9/19.
 */
public class HammingDistance {
    public static void main(String[] args) {
        int count = hammingDistance(1, 14);
        System.out.println(count);
    }

    public static int hammingDistance(int x, int y) {
        if (x < 0 || y < 0) {
            throw new RuntimeException("number should be more than zero");
        }
        char[] xBitChars = Integer.toBinaryString(x).toCharArray();
        char[] yBitChars = Integer.toBinaryString(y).toCharArray();

        char[] longerChars;
        char[] shorterChars;
        if (xBitChars.length >= yBitChars.length) {
            longerChars = xBitChars;
            shorterChars = yBitChars;
        } else {
            longerChars = yBitChars;
            shorterChars = xBitChars;
        }
        int lengthDiff = longerChars.length - shorterChars.length;
        int count = 0;
        for (int maxNumberPos = longerChars.length - 1; maxNumberPos >= 0; maxNumberPos--) {
            int minNumberPos = maxNumberPos - lengthDiff;
            if (((maxNumberPos >= 0 && minNumberPos >= 0) && (longerChars[maxNumberPos] != shorterChars[minNumberPos]))
                    || ((maxNumberPos >= 0 && minNumberPos < 0)) && (longerChars[maxNumberPos] != '0')) {
                count++;
            }
        }
        return count;
    }

//    public static String[] transferIntToBit(int value) {
//        return null;
//    }
}
