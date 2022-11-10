/**
 * @author: asx
 * @date: 2022/11/3
 * @descrition:
 */
package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */
public class _3 {
    public static void main(String[] args) {
        String s = " ";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        // 假设一开始都没有重复的字符串，知道有重复的终止，重启计算，并且认为当前字符是最长的，直到下一个终端字符
        // old_seq 和latest_seq比较长度，
        // 思想，动态规划 + 假设
        int longest = 0;
        int curLength = 0;
        // 确定是否存在
        int[] bloom = new int[127];
        Arrays.fill(bloom, -1);
        int index;
        for (int i = 0; i < s.length(); ) {
            index = s.charAt(i);
            if (bloom[index] != -1) {
                if (curLength > longest) {
                    longest = curLength;
                }
                curLength = 0;
                // 重置start
                // 这里理论不会越界吧
                i = bloom[index] + 1;
                // 表示开始重复了，需要重新清空
                Arrays.fill(bloom, -1);
            } else {
                // 表示还没有重复，长度+1;
                curLength++;
                // 标识为true
                bloom[index] = i++;
            }
        }
        return Math.max(longest, curLength);
    }

}
