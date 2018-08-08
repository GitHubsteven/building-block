package dp;

import javafx.scene.AmbientLight;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/8
 * @Time: 11:13
 * @Description:
 * @version: 1.0.0
 */
public class SplitOrder {
    private static double AMOUNT_MAX = 20;
    private static int CNT_MAX = 4;

    public static void main(String[] args) {
        List<Integer> goodPrices = new ArrayList<>(Arrays.asList(14, 13, 12, 11, 10, 8, 7, 7, 4, 3, 3, 1));
        splitOrder(goodPrices);
        printCollection(goodPrices);
    }

    private static void splitOrder(List<Integer> goodPrices) {
        while (goodPrices.size() > 0) {
            List<Integer> now = new ArrayList<>(goodPrices.subList(0, 1));
            List<Integer> may = new ArrayList<>(goodPrices.subList(1, goodPrices.size()));
            may.sort(Comparator.naturalOrder());
            List<Integer> group = findGroup(now, may);
            printCollection(group);
            System.out.println();
            removeAllButOnlyOne(goodPrices, group);
        }
    }


    public static List<Integer> findGroup(List<Integer> now, List<Integer> may) {
        //验证没有新成员增加到组中了
        if (may.size() == 0) return now;
        if (now.size() >= CNT_MAX) return now;
        Integer sumNow = sumList(now);
        if (sumNow + may.get(0) > AMOUNT_MAX) return now;
        //说明是一定有可以新加的成员的
        int stop = -1;                   // 在may中可以放在now组中的最大索引
        for (int i = 0; i < may.size(); i++) {
            //如果相加小于最大金额，那么继续
            //如果相等，把 i 赋值给stop，中断循环
            //如果大于的话，那么把i-1赋值给stop 中断循环
            int temp = may.get(i) + sumNow;
            if (temp == AMOUNT_MAX) {
                stop = i;
                break;
            } else if (temp > AMOUNT_MAX) {
                stop = i - 1;
                break;
            }
        }
        if (stop == -1) {
            stop = may.size() - 1;
        }
        //找到了group新加的成员
        now.add(may.get(stop));
        may.remove(stop);            //may中删除被取消的成员
        return findGroup(now, may);
    }

    private static Integer sumList(Collection<Integer> numbers) {
        Integer sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    static <T> void removeAllButOnlyOne(List<T> source, List<T> delete) {
        for (T del : delete) {
            for (T sor : source) {
                if (sor.equals(del)) {
                    source.remove(sor);
                    //只删除一个
                    break;
                }
            }
        }
    }

    static <E> void printCollection(Collection<E> collection) {
        collection.forEach(it -> System.out.print(it + " "));
    }
}