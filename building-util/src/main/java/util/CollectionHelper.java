package util;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/9
 * @Time: 14:05
 * @Description:
 * @version: 1.0.0
 */
public class CollectionHelper {
    public static void print2Demension(int[][] data) {
        for (int[] raw : data) {
            for (int col : raw) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static Integer sumList(Collection<Integer> numbers) {
        Integer sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}