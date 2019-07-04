package com.variety.shop.indi.collection.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 对数据模型提供基础字段
 * create by chuanyu.liang on 2016-12-27
 *
 * @author chuanyu.liang
 * @version 3.0.0
 */
public abstract class BaseModel<K> implements Serializable {

    private K id;

    private Date created;

    private String creater;

    private Date modified;

    private String modifier;

    public K getId() {
        return id;
    }

    public void setId(K id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

}
