package recurse;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/26
 * @Time: 14:25
 * @Description: euclid greatest common divisor
 * @version: 1.0.0
 */
public class EuclidGCD {
    public static void main(String[] args) {
        int gcd = euclidGcd(200, 120);
        System.out.println(gcd);
    }

    public static int euclidGcd(int first, int second) {
        int temp = first % second;
        if (temp == 0) return second;
        return euclidGcd(second, temp);
    }
}