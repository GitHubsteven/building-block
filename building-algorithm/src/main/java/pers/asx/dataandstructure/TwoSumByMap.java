/**
 * @author: asx
 * @date: 2023/7/9
 * @descrition:
 */
package pers.asx.dataandstructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: asx
 * @date: 2023/7/9
 * @descrition:
 */
public class TwoSumByMap {

    Map<Integer, Integer> num2Counts = new HashMap<>();

    public void add(int number) {
        Integer count = num2Counts.getOrDefault(number, 0);
        count = count + 1;
        num2Counts.put(number, count);
    }

    public boolean find(int number) {
        Set<Integer> integers = num2Counts.keySet();
        for (Integer num : integers) {
            Integer cnt = num2Counts.getOrDefault(number - num, 0);
            if ((number == 2 * num && cnt >= 2) || (number != 2 * num && cnt > 0)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
