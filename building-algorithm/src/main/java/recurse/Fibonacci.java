package recurse;

/**
 * Created with IntelliJ IDEA.
 *
 * @Date: 2018/7/26
 * @Time: 11:11
 * @Description:
 * @version: 1.0.0
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }

    static int fibonacci(int sequence) {
        if (sequence <= 0) return 0;
        int first = 0;
        int second = 1;

        if (sequence == 1) return first;
        if (sequence == 2) return second;

        return fibonacci(sequence - 1) + fibonacci(sequence - 2);
    }
}