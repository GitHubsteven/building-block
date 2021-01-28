package leetcode.dp;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/1/28
 * @description https://leetcode.com/problems/trapping-rain-water/
 * @copyright COPYRIGHT © 2014 - 2021 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class Lc_42 {
    public static void main(String[] args) {

    }


    public static int trap(int[] height) {
        // TODO: 2021/1/28  如果没有画出网格图，那么暂时就不做了吧
        final int length = height.length;
        if (length <= 2) return 0;
        int sum = 0;
        int start = -1;
        int end = -1;
        for (int i = 0; i < length - 2; i++) {
            if (height[i] > height[i + 1]) start = i;
//            if (height[])
        }

        return 0;
    }
}
