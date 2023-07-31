/**
 * @author: asx
 * @date: 2023/7/28
 * @descrition:
 */
package link;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author: asx
 * @date: 2023/7/28
 * @descrition:
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(10, 0.75f, true);
        map.put(2, 2);
        map.put(3, 3);
        map.put(1, 1);
        // 访问第二个元素
        map.get(2);
        map.get(3);

        System.out.println(map);
    }
}
