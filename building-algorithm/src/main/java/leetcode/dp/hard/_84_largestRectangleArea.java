package leetcode.dp.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class _84_largestRectangleArea {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    /**
     * 原以为用dp可以解决这个问题，但是好像方向有点问题
     *
     * @param heights 所有的长度
     */
    public static int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int min, max = 0;
        for (int i = 0; i < length; i++) {
            int height = heights[i];
            if (height == 0) continue;
            min = height;
            for (int j = i; j >= 0; j--) {
                if (heights[j] == 0) break;
                min = Math.min(heights[j], min);
                max = Math.max(max, min * (i - j + 1));
            }
        }
        return max;
    }

    public static int queue(int[] heights) {
        // 这里为了代码简便，在柱体数组的头和尾加了两个高度为 0 的柱体。
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);

        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int i = 0; i < tmp.length; i++) {
            // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
            // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                area = Math.max(area, (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }

        return area;
    }
}
