package com.asa.building.optimize.exception;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 13:23 2019/1/10.
 */
public class MethodInOrOut {
    public static void main(String[] args) {
        int loop = 1000;
        System.out.println("method 1 ...");
        logTime(loop,MethodInOrOut::method1);
        System.out.println("method 2 ...");
        logTime(loop,MethodInOrOut::method2);
    }

    public static void logTime(int loop, Runnable task) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            task.run();
        }
        System.out.println("runTime(ms): " + (System.currentTimeMillis() - startTime));
    }


    public static void method1() {
        step1();
        step2();
        step3();
        step4();
        step5();
    }


    public static void method2() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(13);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(14);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void step1() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void step2() {
        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void step3() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void step4() {
        try {
            Thread.sleep(13);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void step5() {
        try {
            Thread.sleep(14);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}