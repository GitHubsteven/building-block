/**
 * @author: asx
 * @date: 2023/7/28
 * @descrition:
 */
package link;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: asx
 * @date: 2023/7/28
 * @descrition:
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;

    public LRUCache(int initialCapacity, float loadFactor, int cacheSize) {
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }
}
