package com.variety.shop.indi.report.list;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by rongbin.xie on 2017/5/19.
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","b");
        for(String str: list){
//            System.out.println(str);
        }
//        List<String> list1 = list.stream().filter(ele->ele.equals("3")).collect(Collectors.toList());
//        String result = StringUtils.join(list1,",");
//        System.out.println(list1);
//        System.out.println(result);
//        list1.stream().map(String::toUpperCase).collect(Collectors.toList());
        for(String str:list){
            if(str == "a"){
                continue;
            }
            System.out.println(str);
        }
    }
}
