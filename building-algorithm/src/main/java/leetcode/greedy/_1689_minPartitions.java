package leetcode.greedy;

/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2022/2/15
 * @description https://leetcode-cn.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 * @copyright COPYRIGHT © 2014 - 2021/5/18 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class _1689_minPartitions {
    public static void main(String[] args) {
        System.out.println(minPartitions("27346209830709182346"));
    }

    public static int minPartitions(String n) {
        char max = '0';
        for (int i = 0; i < n.length(); i++) {
            if (max < n.charAt(i)) {
                max = n.charAt(i);
            }
        }
        return max - 48;
    }
}
