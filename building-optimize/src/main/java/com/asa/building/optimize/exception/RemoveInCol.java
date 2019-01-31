package com.asa.building.optimize.exception;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description: remove 存在bug
 * @Date: Created at 11:48 2019/1/11.
 */
public class RemoveInCol {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();

        data.add(1);
        data.add(2);
        data.add(3);
        removeByIter(data);

    }

    /**
     * 索引改变了，并不能正真的达到目的
     *
     * @param data
     */
    public static void removeByFor(List<Integer> data) {
        for (Integer ele : data) {
            if (Objects.equals(2, ele) || Objects.equals(3, ele)) {
                data.remove(ele);
            }
        }
        System.out.println(data);
    }

    public static void removeByIter(List<Integer> data) {
        Iterator<Integer> iterator = data.iterator();
        while (iterator.hasNext()) {
            Integer ele = iterator.next();
            if (Objects.equals(2, ele) || Objects.equals(3, ele)) {
                iterator.remove();
            }
        }
        System.out.println(data);
    }
}