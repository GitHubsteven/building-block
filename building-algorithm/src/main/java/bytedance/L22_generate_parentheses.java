/**
 * @author: asx
 * @date: 2023/6/28
 * @descrition:
 */
package bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: asx
 * @date: 2023/6/28
 * @descrition:
 */
public class L22_generate_parentheses {
    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> parentheses = new ArrayList<>();
        int length = 2 * n;
        char[] charArray = new char[length];
        generateParent(0, n, charArray, 0, 0, parentheses);
        System.out.println(parentheses);
        return parentheses;
    }

    public static void generateParent(int curIndex, int n, char[] charArray, int existedButUsedLeft, int existedButFreeLeft, List<String> createdPar) {
        if (curIndex == 0) {
            charArray[curIndex] = '(';
            generateParent(curIndex + 1, n, charArray, existedButUsedLeft, existedButFreeLeft + 1, createdPar);
            return;
        }
        // 如果是终点的话，那么结束
        if (curIndex == (2 * n - 1) || (existedButUsedLeft == n)) {
            charArray[curIndex] = ')';
            createdPar.add(new String(charArray));
            return;
        }
        // 如果没有（，并且使用了的（数小于限定
        if (existedButFreeLeft == 0) {
            // 必须为（
            if ((existedButFreeLeft + existedButUsedLeft) < n) {
                charArray[curIndex] = '(';
                generateParent(curIndex + 1, n, charArray, existedButUsedLeft,
                        existedButFreeLeft + 1, createdPar);
            }
        } else {
            // 如果存在（可以使用，并且existedAll == n，那么就只能是）了
            if ((existedButFreeLeft + existedButUsedLeft) == n) {
                charArray[curIndex] = ')';
                generateParent(curIndex + 1, n, charArray, existedButUsedLeft + 1,
                        existedButFreeLeft - 1, createdPar);
            } else {
                charArray[curIndex] = '(';
                generateParent(curIndex + 1, n, charArray, existedButUsedLeft,
                        existedButFreeLeft + 1, createdPar);
                // 重新赋值，考虑另外一种情况
                charArray[curIndex] = ')';
                generateParent(curIndex + 1, n, charArray, existedButUsedLeft + 1,
                        existedButFreeLeft - 1, createdPar);
            }
        }
    }

}
