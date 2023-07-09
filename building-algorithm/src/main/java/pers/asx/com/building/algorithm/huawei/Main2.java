/**
 * @author: asx
 * @date: 2023/7/7
 * @descrition:
 */
package pers.asx.com.building.algorithm.huawei;

import java.util.Stack;

/**
 * @author: asx
 * @date: 2023/7/7
 * @descrition:
 */
public class Main2 {
    public static void main(String[] args) {

        boolean result = isValid("()");
        System.out.println(result);
    }

    public static boolean isValid(String s) {
        int length = s.length();
        Stack<Character> leftPar = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if ('(' == c || '{' == c || '[' == c) {
                leftPar.push(c);
            } else {
                if (leftPar.isEmpty())
                    return false;
                Character pop = leftPar.pop();
                if (')' == c) {
                    if (pop == '(') {
                        continue;
                    } else {
                        return false;
                    }

                }
                if ('}' == c) {
                    if (pop == '{') {
                        continue;
                    } else {
                        return false;
                    }
                }
                if (']' == c) {
                    if (pop == '[') {
                        continue;
                    } else {
                        return false;
                    }
                }
                return false;
            }
        }
        return leftPar.isEmpty();
    }
}
