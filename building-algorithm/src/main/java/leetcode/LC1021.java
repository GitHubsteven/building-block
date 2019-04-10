package leetcode;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: remove outermost parentheses
 * @Date: Created at 11:17 2019/4/10.
 */
public class LC1021 {
    public static void main(String[] args) {
        //test case 1
        String testStr1 = "(()())(())";
        System.out.println(removeOuterMostPar(testStr1));

        String testStr2 = "(()())(())(()(()))";
        System.out.println(removeOuterMostPar(testStr2));

        String testStr3 = "()()";
        System.out.println(removeOuterMostPar(testStr3));
    }

    /**
     * 问题链接：
     * https://leetcode.com/problems/remove-outermost-parentheses/
     * <p>
     * 解决思路：假设Value(charX)
     * = -1， (=')')
     * 1 ，  (='(')
     * <p>
     * 从头开始遍历得到当前i的字符（value）和(Sum)，如果减操作（+ （-1）） sum = 0 的话，是闭合，该删去，如果+1 后sum = 1，
     * 表示这是开启符，该删去
     * 闭合意味着 - 1= 0，如果字符满足上述两者
     *
     * @param validateParentheses 合法的字符串
     */
    public static String removeOuterMostPar(String validateParentheses) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < validateParentheses.length(); i++) {
            char charAt = validateParentheses.charAt(i);
            if (charAt == '(') {
                if (sum != 0) sb.append(charAt);
                sum++;
            } else {
                sum--;
                if (sum != 0) sb.append(charAt);
            }
        }
        return sb.toString();
    }

}