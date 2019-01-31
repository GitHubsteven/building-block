package common;

/**
 * Eratosthenes筛选法 原理：
 * 一个合数总是可以分解成若干个质数的乘积，那么如果把质数（最初只知道2是质数）的倍数都去掉，那么剩下的就是质数了。
 * 参考blog ：https://blog.csdn.net/u012102306/article/details/71407105
 */
public class SieveofEratosthenes {

    public static void main(String[] args) {
        System.out.println(count(10));
    }

    public static int count(int n) {
        if (n <= 1) return 0;

        boolean[] flag = new boolean[n];
        int[] values = new int[n];
        for (int i = 1; i <= n; i++) {
            flag[i - 1] = true;
            values[i - 1] = i;
        }

        //从2开始循环到n
        for (int k = 2; k < n; k++) {
            //如果标志位为true，那么开始循环查找小于n的倍数，并把标志位置为false
            if (flag[k - 1]) {
                for (int j = k; j * k < n; j++) {
                    flag[j * k - 1] = false;
                }
            }
        }

        int result = 0;
        for (int x = 1; x < n - 1; x++) {
            if (flag[x]) {
                result++;
            }
        }
        return result;
    }

}
