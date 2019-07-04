package com.variety.shop.indi.report.GrandFatherAndGrandSon.IAttriSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by dell on 2017/2/16.
 */
public class Bean implements IFirstLayer,ISecondLayer {
    public static void main(String[] args) {
        Set<Integer> set =new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(1);
//        set.stream().forEach(Object -> System.out.println(Object));
        List<Integer> list = new ArrayList<>(set);
        List<Integer> tempt = list.stream().filter(Custom ->Custom != 1).collect(Collectors.toList());
//        System.out.println(tempt.toString());
        List <Integer> integerList = new ArrayList<>();
        System.out.println(integerList.stream().filter(Custom -> Custom != null).collect(Collectors.toList()).size());
        integerList.addAll(list);
    }
}
