package com.variety.shop.indi.java8.defaultTest;

/**
 * Created by rongbin.xie on 2018/1/26.
 */
public class OverridingParent extends ParentImpl {
    @Override
    public void welcome() {
        message("Class Parent: Hi!");
    }
}
