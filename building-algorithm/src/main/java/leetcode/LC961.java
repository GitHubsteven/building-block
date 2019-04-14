package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 12:14 2019/4/14.
 */
public class LC961 {
    public static void main(String[] args) {
        int[] A1 = {9, 5, 6, 9};
        System.out.println(repeatedNTimes(A1));
    }


    /**
     * 基于一个原理，一定存在连续的四个数有两个重复的数字
     *
     * @param A
     * @return
     */
    public static int repeatedNTimes(int[] A) {
        for (int i = 0; i <= A.length - 4; i++) {
            if (A[i] == A[i + 1] || A[i] == A[i + 2] || A[i] == A[i + 3]) return A[i];
            if (A[i + 1] == A[i + 2] || A[i + 1] == A[i + 3]) return A[i + 1];
            if (A[i + 2] == A[i + 3]) return A[i + 2];
        }
        if (A[A.length - 1] == A[A.length - 2] || A[A.length - 1] == A[A.length - 3] || A[A.length - 1] == A[A.length - 4])
            return A[A.length - 1];
        if (A[A.length - 2] == A[A.length - 3] || A[A.length - 2] == A[A.length - 4]) return A[A.length - 2];
        if (A[A.length - 3] == A[A.length - 4]) return A[A.length - 3];
        return -1;
    }

    /**
     * 官方的一个答案，好无聊
     *
     * @param A 数组
     */
    public static int repeatedNTimes1(int[] A) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : A) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        for (int k : count.keySet())
            if (count.get(k) > 1)
                return k;

        return -1;
    }
}