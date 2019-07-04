package com.variety.shop.indi.report.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dell on 2017/2/14.
 */
public class ListLearn {
    public static void main(String[] args) {
        Integer[]  test={1,2,3,4,5};
        List<Integer> list= Arrays.asList(test);
        List<Integer> newList = new ArrayList(list);
        newList.add(0,-1);
        newList.forEach(Object-> System.out.println(Object));
    }
}
