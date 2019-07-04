package com.variety.shop.indi.collection;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by rongbin.xie on 2017/11/18.
 */
public class ArrayTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("1s");
        stack.push("2s");
        stack.push("3s");
        stack.push(100);
        Iterator iterator = stack.iterator();
//        while(iterator.hasNext()){
//            Object next = iterator.next();
//            System.out.println(next);
//        }

        Stack<String> stringStack = new StringStack();
        stringStack.push("a");
        stringStack.push("b");
//        System.out.println(stringStack.pop());

        stringStack.forEach(System.out::println);


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        List<Integer> first = list.subList(0, 1);   //sublist 果然是返回一个新的list地址，copy了一份数据
        first.forEach(it->{
            it=it*3;
        });

        System.out.println(list);

        List<String> stringList = new ArrayList<>();
        stringList.add("c");
        stringList.add("e");
        stringList.add("a");
        stringList.sort(String::compareTo);

    }
}
