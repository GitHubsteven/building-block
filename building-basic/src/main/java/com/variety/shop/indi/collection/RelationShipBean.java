package com.variety.shop.indi.collection;

/**
 * Created by rongbin.xie on 2017/9/13.
 */
public class RelationShipBean {
    private String name;
    private RelationShipEnum relationShip;
    private Integer age;

    public String getName() {
        return name;
    }

    public RelationShipBean setName(String name) {
        this.name = name;
        return this;
    }

    public RelationShipEnum getRelationShip() {
        return relationShip;
    }

    public RelationShipBean setRelationShip(RelationShipEnum relationShip) {
        this.relationShip = relationShip;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public RelationShipBean setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "RelationShipBean{" +
                "name='" + name + '\'' +
                ", relationShip=" + relationShip.name() +
                ", age=" + age +
                '}';
    }
}
