/**
 * @author: asx
 * @date: 2022/11/8
 * @descrition:
 */
package leetcode.daily;

import scala.Char;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _1684 {
    public static void main(String[] args) {

    }

    public static int countConsistentStrings(String allowed, String[] words) {
        int cnt = 0;
        boolean[] exists = new boolean[127];
        Arrays.fill(exists, false);
        for (int i = 0; i < allowed.length(); i++) {
            exists[allowed.charAt(i)] = true;
        }
        boolean isConsistent = true;
        for (String word : words) {
            // reset
            isConsistent = true;
            for (char c : word.toCharArray()) {
                if (!exists[c]) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                cnt++;
            }
        }
        return cnt;
    }
}
