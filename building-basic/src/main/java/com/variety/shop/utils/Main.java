package com.variety.shop.utils;

import com.sun.xml.internal.ws.model.ParameterImpl;
import javafx.util.Pair;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 14:48 2020/1/16.
 */
public class Main {
    public static void main(String[] args) {
        List<Bean> beanList = new ArrayList<>();
        beanList.add(new Bean(1, 1, 10, 1, 2));
        beanList.add(new Bean(2, 2, 1, 3, 4));
        beanList.add(new Bean(3, 1, 2, 5, 6));

//        getWhenMap(beanList);
        flatMapParallel(beanList);
    }

    private static void flatMapParallel(List<Bean> beanList) {
        List<TypeInfo> result = beanList.stream()
                .flatMap(it -> {
                    TypeInfo bad = new TypeInfo();
                    bad.setId(it.getId());
                    bad.setQty(it.getBad());
                    bad.setType("bad");
                    TypeInfo good = new TypeInfo();
                    good.setId(it.getId());
                    good.setQty(it.getGood());
                    good.setType("good");
                    return Stream.of(bad, good);
                }).collect(Collectors.toList());
        System.out.println(result);
    }

    private static void getWhenMap(List<Bean> beanList) {
        AtomicInteger sum = new AtomicInteger(0);
        List<Bean> list = beanList.stream().filter(bean -> {
            if (bean.getType() == 1) {
                sum.getAndAdd(bean.getValue());
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        System.out.println(sum);

        System.out.println(list);
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @ToString
    public static class Bean {
        private Integer id;
        private int type;
        private int value;
        private Integer good;
        private Integer bad;
    }

    @Setter
    @Getter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors(chain = true)
    public static class TypeInfo {
        private Integer id;
        /**
         * 1表示good，0表示bad
         */
        private String type;
        private Integer qty;
    }
}