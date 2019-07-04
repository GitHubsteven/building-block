package com.variety.shop.indi.most.common.java.error;

import com.variety.shop.rule.bean.Person;

import java.util.*;

/**
 * Created by rongbin.xie on 2017/9/14.
 */
public class Main {
    public static void main(String[] args) {
//        List<String> list = wrongAddArrayTransList1();
//        List<String> realList = new ArrayList<>(list);
//        //now you can implement add operation.
//        realList.add("$");
//        wrongRemoveList1(list);
//        wrongRemoveList2();
//        rightRmList1();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

//        removeListRight2(list);
//        rmListRight(list);
//        add();
//        listObjectAdd();
        List<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");

        Person person1 = new Person("jet", 1, "1");
        Person person2 = person1;
        System.out.println(person2);
        person1.setAge(2);
        System.out.println(person2);


    }

    /**
     * run normally
     */
    private static void listObjectAdd() {
        List list1 = new ArrayList();
        list1.add(1);
        list1.add("2");
        list1.add(new Person("test", 1, "1"));
        System.out.println(list1);
    }

    /**
     * Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
     */
    public static void add() {
        List<String> list = new ArrayList<>();
        add(list, 10);
        String s = list.get(0);
    }

    public static void add(List list, Object o) {
        list.add(o);
    }


    private static void rmListRight(List<String> list) {
        Iterator<String> iterator = list.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            System.out.println(++count);
            String ele = iterator.next();
            if ("2".equals(ele)) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    private static void removeListRight2(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " " + list.get(i));
            if ("2".equals(list.get(i)) || "3".equals(list.get(i))) {
                list.remove(i);
            }
        }
        System.out.println(list);
    }

    /**
     * run normally
     */
    private static void rightRmList1() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String s = iter.next();
            if (s.equals("a")) {
                iter.remove();
            }
        }

        System.out.println(list);
    }

    private static List<String> wrongAddArrayTransList1() {
        String[] arr = {"1", "2", "3"};
        List<String> list = Arrays.asList(arr);
        // return arrays.arrayList instead of utils.arrayList, fixed length,not support add operation
        list.add("4");
        //throw a exception>>>>>>>>>>>>>> java.lang.UnsupportedOperationException
        return list;
    }

    private static void wrongRemoveList2() {
        //wrong , arrays.asList return a fixed length list, not support an operation that will change it's length
        ArrayList<String> list3 = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
        for (String s : list3) {
            if (s.equals("a")) {
                list3.remove(s);
            }
        }
    }

    private static void wrongRemoveList1(List<String> list) {
        //remove a element in a list>>>>>>>>>>>>>>>>>>>error>>>>>>>>>>>>>run error>>>>>>>> java.lang.IndexOutOfBoundsException: Index: 2, Size: 2
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        for (int i = 0; i < list.size(); i++) {
            list2.remove(i);
        }
        System.out.println(list2);
    }
}
