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
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }


    public static int trap(int[] height) {
        final int length = height.length;
        if (length <= 2) return 0;
        int sum = 0;
        int start_idx = -1;
        // 用于存储每个闭环的积水量，如果有的话
        int sumTem = 0;
        for (int i = 0; i < length; i++) {
            final boolean isNewStart = i == 0 ? height[0] > height[1] :
                    i == length - 1 ? height[i] > height[length - 1] :
                            height[i] >= height[i - 1] && height[i] > height[i + 1];
            // 如果起点存在，并且
            if (!isNewStart) {
                if (start_idx != -1) {
                    sumTem += height[start_idx] - height[i];
                }
            } else {
                // 如果没有旧的开始点话，就设为水池起点
                if (start_idx != -1) {
                    // 表示有一个水池，需要关闭，并且如果低于起点的话，重新计算水池的积水
                    if (height[i] < height[start_idx]) {
                        sumTem -= (height[start_idx] - height[i]) * (i - start_idx - 1);
                    }
                    // 水池关闭，积水加入总和
                    sum += sumTem;
                    //清除缓存
                    sumTem = 0;
                }
                start_idx = i;
            }
        }
        return sum;
    }
}
