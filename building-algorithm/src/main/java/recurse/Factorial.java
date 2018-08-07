package recurse;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/26
 * @Time: 14:12
 * @Description: factorial is n!
 * @version: 1.0.0
 */
public class Factorial {
    public static void main(String[] args) {
        long result = factorial(10);
        System.out.println(result);
    }

    public static long factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }
}