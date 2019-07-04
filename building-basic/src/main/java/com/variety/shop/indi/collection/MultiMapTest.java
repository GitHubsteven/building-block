package com.variety.shop.indi.collection;


import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by rongbin.xie on 2017/9/13.
 */
public class MultiMapTest {
    private final static Integer RELATION_COUNT = RelationShipEnum.values().length;

    public static void main(String[] args) {

        List<RelationShipBean> relations = new ArrayList<>();
        for (int k = 0; k < 10; k++) {
            RelationShipBean relationShipBean = new RelationShipBean();
            relationShipBean.setAge(k).setName("name" + k).setRelationShip(RelationShipEnum.buildRelationShip(String.valueOf(k % RELATION_COUNT)));
            relations.add(relationShipBean);
        }
        Multimap<String, RelationShipBean> relationShipGroupByRelation = ArrayListMultimap.create();
        relations.forEach(relation -> relationShipGroupByRelation.put(relation.getRelationShip().vlaue(), relation));
//        Map<String, Collection<RelationShipBean>> stringCollectionMap = relationShipGroupByRelation.asMap();
        relationShipGroupByRelation.forEach((relation, infos) -> {
            System.out.println(RelationShipEnum.buildRelationShip(relation).name());
            System.out.println(infos);
        });
    }
}
