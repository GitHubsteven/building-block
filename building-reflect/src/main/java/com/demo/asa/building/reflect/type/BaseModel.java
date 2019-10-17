package com.demo.asa.building.reflect.type;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 17:42 2019/10/16.
 */
public abstract class BaseModel<K> {
    private String name;
    private K key;

    public abstract void buildModel();

    public String getName() {
        return name;
    }

    public BaseModel<K> withName(String name) {
        this.name = name;
        return this;
    }

    public K getKey() {
        return key;
    }

    public BaseModel<K> withKey(K key) {
        this.key = key;
        return this;
    }
}