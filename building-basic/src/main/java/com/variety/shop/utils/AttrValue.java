package com.variety.shop.utils;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 14:13 2018/4/17.
 */
public class AttrValue {
    private String name;
    private String type;
    private String Annotation;

    public String getName() {
        return name;
    }

    public AttrValue setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public AttrValue setType(String type) {
        this.type = type;
        return this;
    }

    public String getAnnotation() {
        return Annotation;
    }

    public AttrValue setAnnotation(String annotation) {
        Annotation = annotation;
        return this;
    }
}
