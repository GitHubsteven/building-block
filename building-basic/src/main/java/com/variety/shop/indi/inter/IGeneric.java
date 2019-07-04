package com.variety.shop.indi.inter;


import java.util.Collection;
import java.util.Set;

/**
 * Created by rongbin.xie on 2017/9/14.
 */
public interface IGeneric<K, V> {
    Set<K> keySet();
    
    Collection<V> values();
}
