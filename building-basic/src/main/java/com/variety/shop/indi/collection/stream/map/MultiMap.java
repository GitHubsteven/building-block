package com.variety.shop.indi.collection.stream.map;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.variety.shop.indi.collection.bean.WmsMtSkuInfoModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 10:18 2018/3/29.
 */
public class MultiMap {
    public static void main(String[] args) {
        Multimap<String,String> map = HashMultimap.create();
        List<WmsMtSkuInfoModel> skuInfoModels = new ArrayList<>();
        WmsMtSkuInfoModel model1 = new WmsMtSkuInfoModel();
        model1.setSku("a");
        model1.setChannelId("001");

        WmsMtSkuInfoModel model2 = new WmsMtSkuInfoModel();
        model2.setSku("b");
        model2.setChannelId("001");

        WmsMtSkuInfoModel model3 = new WmsMtSkuInfoModel();
        model3.setSku("c");
        model3.setChannelId("002");

        WmsMtSkuInfoModel model4 = new WmsMtSkuInfoModel();
        model4.setSku("d");
        model4.setChannelId("002");
        skuInfoModels.add(model1);
        skuInfoModels.add(model2);
        skuInfoModels.add(model3);
        skuInfoModels.add(model4);

        skuInfoModels.forEach(it->map.put(it.getChannelId(),it.getSku()));
        Map<String, Collection<String>> newMap = map.asMap();
        List<String> channelList = new ArrayList<>();
//        List<String> skuList = newMap.entrySet().stream().flatMap(it -> {
//            channelList.add(it.getKey());
//            return it.getValue().stream();
//        }).collect(Collectors.toList());
//        channelList.forEach(System.out::println);
//        skuList.forEach(System.out::println);
        List<String> channels = newMap.entrySet().stream().map(it -> {
            System.out.println(it.getKey());
            return it.getKey();
        }).collect(Collectors.toList());
    }
}
