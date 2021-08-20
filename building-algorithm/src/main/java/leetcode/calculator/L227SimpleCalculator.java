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
        String expression = "3+2*2/4+2";
        int result = calculate(expression);
        System.out.println(result);

        System.out.println((int) '0');
        System.out.println((int) '9');
    }

    public static int calculate(String expression) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int length = expression.length();
        for (int i = 0; i < length; i++) {
            char value = expression.charAt(i);
            // 空格跳过
            if (value == ' ') {

            } else if (isNumber(value)) {
                // 数字压入stack
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
                        System.out.println(value);
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
}
