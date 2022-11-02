package leetcode.greedy;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/2/15
 * @description https://leetcode-cn.com/problems/container-with-most-water/
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class _11_container_with_most_water {
    public static void main(String[] args) {
        int[] heights = {1};
        System.out.println(bruce_force(heights));
    }

    /**
     * 暴力枚举法，O(n^2)，YYDS
     *
     * @param height 高度
     */
    public static int bruce_force(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(Math.min(height[i], height[j]) * (j - i), maxArea);
            }
        }
        return Math.max(maxArea, 0);
    }

    public static int kadane(int[] height) {
        if (height.length == 1) return 0;
        // TODO: 2022/2/15
        return 0;
    }
}
