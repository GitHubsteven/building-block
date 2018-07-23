package practice;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/20
 * @Time: 22:17
 * @Description:
 * @version: 1.0.0
 */
public class RelativePrime {
    /**
     * How do you invoke the following method to find the first integer in a list that is relatively prime to a list of specified integers?
     *
     * @param list  待分配的数组
     * @param begin 开始地址
     * @param end   结束地址
     * @param p     类型
     * @param <T>
     * @return
     */
    public static <T> int findFirst(List<T> list, int begin, int end, UnaryPredicate<T> p) {
        for(; begin < end; ++begin){
            if(p.test(list.get(begin))) return begin;
            return -1;
        }
        return 0;
    }

    /**
     * find the greatest common divisor
     *
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        for (int r; (r = a % b) != 0; a = b, b = r) {
        }
        return b;
    }
}