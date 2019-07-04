package com.variety.shop.indi.java8.defaultTest;

/**
 * parent impl
 * Created by rongbin.xie on 2018/1/26.
 */
public class ParentImpl implements Parent, Comparable<ParentImpl>{
    private String msg;
    @Override
    public void message(String body) {
        this.msg = body;
    }


    @Override
    public String getLastMessage() {
        return msg;
    }

    @Override
    public int compareTo(ParentImpl o) {
        return 0;
    }
}
