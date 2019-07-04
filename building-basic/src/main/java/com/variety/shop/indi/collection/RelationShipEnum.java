package com.variety.shop.indi.collection;

import java.util.Arrays;

/**
 * Created by rongbin.xie on 2017/9/13.
 */
public enum RelationShipEnum {
    parent("0"),
    family("1"),
    friend("2"),
    colleague("3"),
    stranger("4");

    String value;

    RelationShipEnum(String value) {
        this.value = value;
    }

    String vlaue() {
        return this.value;
    }

    public static RelationShipEnum buildRelationShip(String relationCode) {
        RelationShipEnum[] values = RelationShipEnum.values();
        return Arrays.stream(values).filter(rel -> rel.vlaue().equals(relationCode)).findFirst().orElse(null);
    }
}
