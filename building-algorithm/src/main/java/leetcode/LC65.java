package leetcode;

import java.util.Objects;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: https://leetcode.com/problems/valid-number/
 * @Date: Created at 13:26 2019/4/12.
 */
public class LC65 {
    public static void main(String[] args) {
        String example = "\"0\" => true\n" +
                "\" 0.1 \" => true\n" +
                "\"abc\" => false\n" +
                "\"1 a\" => false\n" +
                "\"2e10\" => true\n" +
                "\" -90e3   \" => true\n" +
                "\" 1e\" => false\n" +
                "\"e3\" => false\n" +
                "\" 6e-1\" => true\n" +
                "\" 99e2.5 \" => false\n" +
                "\"53.5e93\" => true\n" +
                "\" --6 \" => false\n" +
                "\"-+3\" => false\n" +
                "\".1\" => true\n" +
                "\"95a54e53\" => false";
        String[] examples = example.replaceAll("\"", "").split("\n");
        for (String exea : examples) {
            String[] values = exea.split(" => ");
            if (values.length != 2) {
                System.out.println("err split:" + exea);
                continue;
            }
            boolean expectedResult = Objects.equals(values[1].trim(), "true");
            if (expectedResult != isNumber(values[0])) {
                System.out.println("err test case:" + exea);
            }
        }
        System.out.println(isNumber("+.8"));
    }

    /**
     * "0" => true
     * " 0.1 " => true
     * "abc" => false
     * "1 a" => false
     * "2e10" => true
     * " -90e3   " => true
     * " 1e" => false
     * "e3" => false
     * " 6e-1" => true
     * " 99e2.5 " => false
     * "53.5e93" => true
     * " --6 " => false
     * "-+3" => false
     * "95a54e53" => false
     *
     * @param s
     * @return
     */
    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        String realStr = s.trim();
        if (realStr.length() == 0) return false;
        char POINT = '.';
        char MINUS_LETTER = '-';
        char ADD_LETTER = '+';
        char SPLIT_LETTER = 'e';
        //对于一个字符串是否为合法的数值标志
        boolean isSigned = false;
        boolean isPoint = false;
        boolean hasVal;
        //对于第一个值开始判断
        char first = realStr.charAt(0);
        if ((first > '9' || first < '0')) {
            if (first == MINUS_LETTER || first == ADD_LETTER) {
                isSigned = true;
            } else if (first == POINT) {
                isPoint = true;
            } else {
                return false;
            }
        }
        hasVal = !isSigned && !isPoint;
        //对于一个字符是否为底数还是指数
        boolean isExponent = false;
        boolean isExpSigned = false;
        boolean expHasValue = false;
        boolean isExp1st = true;
        int length = realStr.length();
        for (int i = 1; i < length; i++) {
            char letter = realStr.charAt(i);
            if (letter == SPLIT_LETTER) {
                if (!hasVal || isExponent) return false;
                if (i == length - 1) return false;
                isExponent = true;
                continue;
            }
            if (isExponent) {
                if ('0' <= letter && letter <= '9') {
                    expHasValue = true;
                    isExp1st = false;
                } else {
                    if (letter == '-' || letter == '+') {
                        if (isExpSigned) return false;
                        if (isExp1st) {
                            isExpSigned = true;
                            isExp1st = false;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            } else {
                if ('0' <= letter && letter <= '9') {
                    hasVal = true;
                } else {
                    if (letter == POINT) {
                        if (isSigned && i == 1) continue;
                        if (hasVal) {
                            if (!isPoint) {
                                isPoint = true;
                                continue;
                            } else return false;
                        }
                        return false;
                    } else if (letter == MINUS_LETTER || letter == ADD_LETTER) {
                        return false;
                    } else {
                        return false;
                    }
                }
            }
        }
        return hasVal && (!isExponent || expHasValue);
    }
}