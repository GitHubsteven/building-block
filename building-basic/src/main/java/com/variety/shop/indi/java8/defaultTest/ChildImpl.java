package com.variety.shop.indi.java8.defaultTest;

/**
 * child 接口实现
 * <p>
 * Created by rongbin.xie on 2018/1/26.
 */
public class ChildImpl implements Child {
    private String msg;

    @Override
    public void message(String body) {
        this.msg = body;
    }

    @Override
    public void welcome() {
        message("ChildImpl,hi!");
    }

    @Override
    public String getLastMessage() {
        return msg;
    }
}
