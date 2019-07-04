package com.variety.shop.indi.report.Itest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * Created by rongbin.xie on 2017/5/4.
 */
public class Test {
    public static void main(String[] args) {
//        try {
//            throwException();
//            System.out.println("exception not occurs!");
//        } catch (Exception e) {
////            e.printStackTrace();
//
//            System.out.println("exception occurs");
//        }
//        System.out.println("insert into db");
        System.out.println("a test case need be tested".replaceFirst("test","function"));

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");

        list.removeAll(list1);

        System.out.println(list);
    }

    private static void test() throws Exception {
        try {
            int a =9;
            int b =0;
            System.out.println(a/b);
        } catch (Exception e) {
            throw new IOException();
//            System.out.println("-__-");
//            throw new Exception("this is not a zero exception");
//            e.printStackTrace();
        }
    }

    public  static void throwException() throws Exception {
//        throw new Exception();
    }

    public void cronJObTest(){
    }

}
