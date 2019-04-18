package com.asa.x.jxls;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:04 2019/4/18.
 */
public enum ClzFieldsRelationEnum {
    Same("0"),
    Sub("-1"),
    Parent("1"),
    Dif("-2"),
    Ignore("3");
    private String value;

    ClzFieldsRelationEnum(String value) {
        this.value = value;
    }

    public ClzFieldsRelationEnum getClzFieldRelEnum(String val) {
        return ClzFieldsRelationEnum.valueOf(val);
    }

    public String value() {
        return this.value;
    }
}