/**
 * @author: asx
 * @date: 2023/7/28
 * @descrition:
 */
package link;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: asx
 * @date: 2023/7/28
 * @descrition:
 */
public class Main {
    private final static ConcurrentHashMap<Integer, Integer> MAP = new ConcurrentHashMap<>(10);


    public static void main(String[] args) {
        MAP.put(1, 1);
    }
}
