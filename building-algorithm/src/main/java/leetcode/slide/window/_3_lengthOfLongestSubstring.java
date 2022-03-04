package leetcode.slide.window;

import java.util.Arrays;
import java.util.Map;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/3/4
 * @description
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class _3_lengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] charIndex = new int[126];
        // init flg array
        Arrays.fill(charIndex, -1);
        int max = Integer.MIN_VALUE;
        int cnt = 0;
        int startInclusive = 0;
        boolean[] flags = new boolean[s.length()];
        while (startInclusive < s.length() && !flags[startInclusive]) {
            Arrays.fill(charIndex, -1);
            for (int i = startInclusive; i < s.length(); i++) {
                char value = s.charAt(i);
                if (charIndex[value] == -1) {
                    cnt++;
                    charIndex[value] = i;
                } else {
                    startInclusive = charIndex[value] + 1;
                    max = Math.max(max, cnt);
                    cnt = 0;
                    break;
                }
            }
            flags[startInclusive] = true;
        }
        return max;
    }

}
