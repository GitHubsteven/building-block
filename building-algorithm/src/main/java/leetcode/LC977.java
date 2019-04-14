package leetcode;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 17:26 2019/4/14.
 */
public class LC977 {
    public static void main(String[] args) {
        int[] numbers = {-4, -1, 0, 3, 10};
        for (int i : sortedSquares(numbers)) {
            System.out.println(i);
        }
    }

    public static int[] sortedSquares(int[] A) {
        int[] squares = new int[A.length];
        int start = 0, end = A.length - 1, idx = A.length - 1;
        while (start <= end) {
            if (Math.abs(A[start]) > Math.abs(A[end])) {
                squares[idx--] = (int) Math.pow(A[start++], 2);
            } else {
                squares[idx--] = (int) Math.pow(A[end--], 2);
            }
        }
        return squares;
    }
}