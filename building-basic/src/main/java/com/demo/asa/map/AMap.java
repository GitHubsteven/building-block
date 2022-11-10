/**
 * @author: asx
 * @date: 2022/10/26
 * @descrition:
 */
package com.demo.asa.map;

import java.util.*;

/**
 * map,定义一个二维数组，put一个key,value保存下来
 * get: 查询
 * insert: 插入
 */
@SuppressWarnings("unchecked")
public class AMap<K, V> implements Map<K, V> {
    private int size = 8;

    private int occupiedSize = 0;

    private Object[] keys = new Object[size];

    private Object[] values = new Object[size];


    public AMap(int size) {
        this.size = size;
    }

    public AMap() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(value, values[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        int keyIdx = findKeyIdx(key);
        return keyIdx == -1 ? null : (V) values[keyIdx];
    }

    @Override
    public V put(K key, V value) {
        // 查询key是否存在
        int keyIdx = findKeyIdx(key);
        // 判断是否存在，存在的话，更新，不存在插入
        if (keyIdx >= 0) {
            values[keyIdx] = value;
        }
        // 插入，判断是否需要扩容
        if (this.occupiedSize >= size) {
            //扩容
            Object[] newKeys = new Object[size + 16];
            System.arraycopy(keys, 0, newKeys, 0, size);
            Object[] newValues = new Object[size + 16];
            System.arraycopy(values, 0, newValues, 0, size);
            // 重新赋值
            this.keys = newKeys;
            this.values = newValues;
            this.keys[size] = key;
            this.values[size] = value;
            // 重置map的相关信息
            size += 16;
        } else {
            // 不需要扩容
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    keys[i] = key;
                    values[i] = value;
                    break;
                }
            }
        }
        occupiedSize++;
        return value;
    }


    private int findKeyIdx(Object key) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(key, keys[i])) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public V remove(Object key) {
        int keyIdx = findKeyIdx(key);
        keys[keyIdx] = null;
        V value = (V) values[keyIdx];
        values[keyIdx] = null;
        return value;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {
        this.occupiedSize = 0;
        this.size = 8;
        Arrays.fill(this.keys, null);
        Arrays.fill(this.values, null);
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
