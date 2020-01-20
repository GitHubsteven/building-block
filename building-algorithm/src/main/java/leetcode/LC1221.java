package leetcode;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: url: https://leetcode.com/problems/split-a-string-in-balanced-strings/
 * @Author asa.x
 * @Date: Created at 17:03 2020/1/20.
 */
public class LC1221 {
    /**
     * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
     * <p>
     * Given a balanced string s split it in the maximum amount of balanced strings.
     * <p>
     * Return the maximum amount of splitted balanced strings.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "RLRRLLRLRL"
     * Output: 4
     * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
     * Example 2:
     * <p>
     * Input: s = "RLLLLRRRLR"
     * Output: 3
     * Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
     * Example 3:
     * <p>
     * Input: s = "LLLLRRRR"
     * Output: 1
     * Explanation: s can be split into "LLLLRRRR".
     * Example 4:
     * <p>
     * Input: s = "RLRRRLLRLL"
     * Output: 2
     * Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 1000
     * s[i] = 'L' or 'R'
     */
    public static int balancedStringSplit(String s) {
        int count = 0;
        int sum = 0;
        //set 'r' =1, 'l' = -1, sum is the value of a continue
        for (int i = 0; i < s.length(); i++) {
            char ele = s.charAt(i);
            if (ele == 'R') {
                sum = sum + 1;
                if (sum == 0) count++;
            } else {
                sum = sum - 1;
                if (sum == 0) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
        System.out.println(balancedStringSplit("LLLLRRRR"));
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
    }
}