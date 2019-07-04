package com.variety.shop.indi.design.pattern.singlePattern;

/**
 * Created by rongbin.xie on 2017/10/26.
 */
public class Main {
    public static void main(String[] args) {
        BaseSingleTonTestThread baseRunnable = new BaseSingleTonTestThread();
        Thread thread1 = new Thread(baseRunnable);
        Thread thread2 = new Thread(baseRunnable);
        thread1.start();
        thread2.start();

    }
}
