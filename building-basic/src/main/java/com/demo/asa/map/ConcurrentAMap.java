/**
 * @author: asx
 * @date: 2022/10/26
 * @descrition:
 */
package com.demo.asa.map;

public class ConcurrentAMap<K, V> extends AMap<K, V> {
    @Override
    public V put(K key, V value) {
        synchronized (this) {
            return super.put(key, value);
        }
    }
}
