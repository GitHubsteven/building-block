package com.variety.shop.indi.report.GrandFatherAndGrandSon.MultiThread;

/**
 * Created by dell on 2017/2/24.
 */
public class Main {
    public static void main(String[] args) {
        TestThread thread = new TestThread(2,0);
        try {
            Thread t = new Thread(thread);
            t.start();
        } catch (Throwable e) {
            System.out.println("main :          ");
        }
    }
}
