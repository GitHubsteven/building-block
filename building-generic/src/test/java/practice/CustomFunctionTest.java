package practice;

import customfunction.CustomFunction;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/20
 * @Time: 17:50
 * @Description:
 * @version: 1.0.0
 */
public class CustomFunctionTest {
    public static void main(String[] args) {
        run((param) -> {
            for (Object ele : param) {
                System.out.println(ele);
            }
            return String.valueOf(1);
        });
    }

    public static void run(CustomFunction<String> function) {
        Object[] param = {1, 2, "a"};
        String run = function.run(param);
        System.out.println("====================");
        System.out.println(run);
    }
}