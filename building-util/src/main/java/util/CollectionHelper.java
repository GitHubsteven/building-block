package util;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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

    public static void print2Dimension(int[][] data) {
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

    public static List<List<Integer>> combine(int[] filters, int count) {
        List<List<Integer>> list = new ArrayList<>();
        Integer[] filter = new Integer[count];
        boolean[] flags = new boolean[filters.length];
        // 初始化组合标识
        for (int i = 0; i < flags.length; i++) {
            if (i < count) {
                flags[i] = true;
            } else {
                flags[i] = false;
            }
        }

        int point = 0;
        int nextPoint = 0;
        int numCount = 0;
        int sum = 0;
        boolean flagTemp = true;
        while (true) {
            // 判断是否全部移位完毕
            for (int i = flags.length - 1; i >= flags.length - count; i--) {
                if (flags[i]) {
                    sum++;
                }
            }
            // 根据移位生成数据
            for (int i = 0; i < flags.length; i++) {
                if (flags[i]) {
                    point = i;
                    filter[numCount] = filters[point];
                    numCount++;
                    if (numCount == count) {
                        break;
                    }
                }
            }
            // 往返回值列表添加数据
            list.add(Arrays.asList(filter));
            // 当数组的最后count位全部为true退出
            if (sum == count) {
                break;
            }
            sum = 0;
            // 修改从左往右第一个10变成01
            for (int i = 0; i < flags.length - 1; i++) {
                if (flags[i] && !flags[i + 1]) {
                    point = i;
                    nextPoint = i + 1;
                    flags[point] = false;
                    flags[nextPoint] = true;
                    break;
                }
            }

            // 将 i-point个元素的1往前移动 0往后移动
            for (int i = 0; i < point - 1; i++) {
                for (int j = i; j < point - 1; j++) {
                    if (!flags[i]) {
                        flagTemp = flags[i];
                        flags[i] = flags[j + 1];
                        flags[j + 1] = flagTemp;
                    }
                }
            }
            // 重置
            filter = new Integer[count];
            numCount = 0;
        }

        return list;
    }

    public static <T> Object listNumber2IntArr(List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        Object result = null;
        T first = list.get(0);
        if (first instanceof Integer) {
            int[] temp = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                temp[i] = (Integer) list.get(i);
                result = temp;
            }
        } else if (first instanceof Double) {
            double[] temp = new double[list.size()];
            for (int i = 0; i < list.size(); i++) {
                temp[i] = (Double) list.get(i);
                result = temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int[] result = (int[]) listNumber2IntArr(list);
//        if()
        System.out.println(result[0]);
    }
}