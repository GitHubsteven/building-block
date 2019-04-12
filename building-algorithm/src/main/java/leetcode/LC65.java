package leetcode;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: https://leetcode.com/problems/valid-number/
 * @Date: Created at 13:26 2019/4/12.
 */
public class LC65 {
    public static void main(String[] args) {

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
        char POINT = '.';
        char
        if (s == null || s.length() == 0) return false;
        char first = s.charAt(0);
        if ((first < '0' || first > '9') && first !='') return false;
        boolean isBase = true;
        int length = s.length();
        for (int i = 1; i < length; i++) {
            char letter = s.charAt(i);
            if (letter == 'e') {
                if (i == length - 1) return false;
                isBase = false;
                continue;
            }
            if (isBase) {
                if (letter == POINT) {
                    char next = s.charAt(i + 1);
                    if (next < '0' || next > '9') return false;
                }
            } else {

            }
        }
        return true;
    }
}