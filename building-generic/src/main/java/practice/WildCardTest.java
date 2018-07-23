package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/20
 * @Time: 21:05
 * @Description:
 * @version: 1.0.0
 */
public class WildCardTest {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);

//        print(nums);

        List<Double> doubles = new ArrayList<>();
        doubles.add(1.2D);
        doubles.add(2.3D);
        print(doubles);
    }

    public static void print(List<? extends Number> list) {
        for (Number number : list) {
            System.out.print(number + " ");
            System.out.println();
        }
    }
}