package dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/9
 * @Time: 9:08
 * @Description: dynamic programming -- upstairs question, upstairs to 2 n, 1 or 2 step once, how many choices totally
 * @version: 1.0.0
 */
public class Upstairs {
    public static void main(String[] args) {
        System.out.println(upstairs(4));
    }

    static int upstairs(int n) {
        if (n == 0) return 1;   //0 表示原地不动，也有一种方式
        if (n == 1) return 1;

        int result = upstairs(n - 1) + upstairs(n - 2);
        return result;
    }
}