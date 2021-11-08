/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date
 * @description
 * @copyright COPYRIGHT © 2014 - VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
package leetcode.calculator;

import java.util.Stack;

public class L227SimpleCalculator {
    public static void main(String[] args) {
        String expression = "32";
        System.out.println(calculate(expression));
    }

    /**
     * 1. operation _after
     *
     * @param expression 表达式
     * @return 运算结果
     */
    public static int calculate(String expression) {
        expression = expression.replaceAll(" ", "");
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int length = expression.length();
        StringBuilder preNumber = new StringBuilder();
        StringBuilder nextNumber = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char value = expression.charAt(i);
            if (isNumber(value)) {
                // 数字压入stack
                preNumber.append(value);
                nums.push(Character.getNumericValue(value));
            } else {
                // 操作符
                switch (value) {
                    case ('*'): {
                        int right = Character.getNumericValue(expression.charAt(i + 1));
                        nums.push(nums.pop() * right);
                        i++;
                        break;
                    }
                    case ('/'): {
                        int right = Character.getNumericValue(expression.charAt(i + 1));
                        nums.push(nums.pop() / right);
                        i++;
                        break;
                    }
                    case ('+'):
                    case ('-'): {
                        ops.push(value);
                    }
                    default: {
                    }
                }
            }
        }
        // 计算stack
        int result = nums.pop();
        while (!ops.empty()) {
            Character operation = ops.pop();
            switch (operation) {
                case '*': {
                    result = result * nums.pop();
                    break;
                }
                case '/': {
                    result = nums.pop() / result;
                    break;
                }
                case '+': {
                    result = nums.pop() + result;
                    break;
                }
                case '-': {
                    result = nums.pop() - result;
                    break;
                }
            }
        }
        return result;
    }

    public static boolean isNumber(char val) {
        return (int) val >= 48 && (int) val <= 57;
    }

    public static int getNextOperateCharIdx(String expression, int startInclusive) {
        for (int i = startInclusive; i < expression.length(); i++) {
            if (!isNumber(expression.charAt(i))) return i;
        }
        return expression.length() - 1;
    }
}
