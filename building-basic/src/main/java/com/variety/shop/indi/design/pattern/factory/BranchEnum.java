package com.variety.shop.indi.design.pattern.factory;

/**
 * Created by rongbin.xie on 2017/10/16.
 */
public enum BranchEnum {

    ADIDAS("0"),
    NIKE("1"),
    NEW_BALANCE("2"),
    REEBOK("3");

    private String value;

    BranchEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
