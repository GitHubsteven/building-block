package backtracking;

import java.util.Scanner;

/**
 * @authoer asa.x
 * @date 2020/7/19
 * @descrition 大数据求模： https://blog.csdn.net/tianhaobing/article/details/76022088
 */
public class BigDataMod {
    public static void main(String[] args) {
        long n, k, m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        k = sc.nextLong();
        m = sc.nextLong();
        BigDataMod main = new BigDataMod();
        long res = main.mod(n, k, m);
        System.out.println(res);
    }

    long mod(long n, long k, long m) {
        long mod = 1;
        long base = n;
        long res = 1;
        if (n > m) {//先减小以下n的值,不然容易超long的范围
            n = n % m;
            base = n;
        } else if (n == m) {
            return 1;
        }
        while (k != 0) {
            if ((k & 1) == 1) {    //取k的二进制最后一位,若为1,则表示存在该项
                mod *= (base % m);
                if (mod == 0) {
                    return 0;  //只要有一个数模为0,直接返回0
                } else if (mod > m) {
                    mod %= m;        //若模大于除数,则可以进行一次求模
                }
                base = base % m;     //base求余,根据余数来算模,以免超出long的范围
            }
            base *= base; //将余数进行平方来算模,能减小数的大小
            base = base % m;
            k >>= 1;          //将k的二进制往右移动一位
        }
        return mod;
    }
}
