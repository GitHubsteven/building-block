package leetcode;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: https://leetcode.com/problems/sort-array-by-parity/
 * @Date: Created at 15:38 2019/4/14.
 */
public class LC905 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        for (int ele : sortArrayByParity1(arr)) {
            System.out.print(" " + ele);
        }
    }

    /**
     * 这里的使用空间竟然更小，一言难尽
     *
     * @param A
     * @return
     */
    public static int[] sortArrayByParity(int[] A) {
        int[] newArray = new int[A.length];
        int start = 0, end = A.length - 1;
        for (int aA : A) {
            if (aA % 2 == 0) {
                newArray[start++] = aA;
            } else {
                newArray[end--] = aA;
            }
        }
        return newArray;
    }

    public static int[] sortArrayByParity1(int[] A) {
        for (int start = 0, end = A.length - 1; start < end; ) {
            if (A[start] % 2 == 0) {
                start++;
                continue;
            }
            while (A[end] % 2 == 1 && end > start) {
                end--;
            }
            if (start >= end) break;
            A[start] = A[start] + A[end];
            A[end] = A[start] - A[end];
            A[start] = A[start] - A[end];
        }
        return A;
    }
}