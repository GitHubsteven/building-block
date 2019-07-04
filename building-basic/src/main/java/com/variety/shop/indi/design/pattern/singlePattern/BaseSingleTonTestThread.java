package com.variety.shop.indi.design.pattern.singlePattern;

/**
 * Created by rongbin.xie on 2017/10/26.
 */
public class BaseSingleTonTestThread implements Runnable {
    @Override
    public void run() {
        BaseSpringTestException testException = BaseSpringTestException.newInstance();
        testException.setResponseCode("A");
        System.out.println(testException.hashCode());
    }

    public BaseSingleTonTestThread() {
    }
}
