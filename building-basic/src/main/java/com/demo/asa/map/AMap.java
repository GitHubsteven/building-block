package com.demo.asa.map;

import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@EqualsAndHashCode
public class AMap<K, V> implements Map<K, V> {

    public static class LinkNode {
        Object key;
        Object value;

        @Override
        public int hashCode() {
            return Objects.hashCode(key) * 31 + Objects.hash(value) * 31;
        }
    }


    public static class TreeNode {
        Object key;

        Object value;

        TreeNode leftChild;

        TreeNode rightChild;

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }


    private volatile int size = 0;

    private volatile int[] keys = {};


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

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
