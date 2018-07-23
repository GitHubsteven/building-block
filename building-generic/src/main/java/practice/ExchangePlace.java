package practice;

import java.lang.reflect.Array;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/7/20
 * @Time: 19:46
 * @Description:
 * @version: 1.0.0
 */
public class ExchangePlace {
    static <T> void exchange(T[] param, int first, int second) {
        if (first < 0 || second > param.length) throw new IllegalArgumentException("index is wrong");
        T firstEle = param[first];
        param[first] = param[second];
        param[second] = firstEle;
    }

    public static void main(String[] args) {
        String[] strs = {"a","b","c","d"};
        exchange(strs,1,3);
        for (String str : strs) {
            System.out.println(str);
        }
    }

    private static void exchangeInt() {
        Integer[] number = {1,2,3,4};
        exchange(number,1,3);
        for (Integer no : number) {
            System.out.println(no);
        }
    }
}