package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/20
 * @Time: 21:13
 * @Description:
 * @version: 1.0.0
 */
public class FindMax {
    public static void main(String[] args) {
        List<Integer> number = new ArrayList<>();
        number.add(10);
        number.add(3);
        number.add(2);
        number.add(5);

        Integer max = findMax(number, 0, 3);
        System.out.println(max);
    }

    // TODO: 2018/7/20 不是很明白这里的写法为什么会是这样子
    public static <T extends Object & Comparable<? super T>> T findMax(List<T> list, int inclusive, int exclusive) {
        T max = list.get(inclusive);
        for (++inclusive; inclusive < exclusive; ++inclusive) {
            if (max.compareTo(list.get(inclusive)) < 0) {
                max = list.get(inclusive);
            }
        }
        return max;
    }

    public static <T extends Object & Iterable<? super T>> T test(List<T> list){
        return  null;
    }
}