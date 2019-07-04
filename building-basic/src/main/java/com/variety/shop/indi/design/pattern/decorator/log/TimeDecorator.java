package com.variety.shop.indi.design.pattern.decorator.log;

/**
 * Created by rongbin.xie on 2018/1/30.
 */
public class TimeDecorator extends OperateDecorator {
    public TimeDecorator(IOperator operator) {
        super(operator);
    }

    @Override
    public void operate() {
        long start = System.currentTimeMillis();
        System.out.println("start run, time: " + start);
        super.operate();
        long end = System.currentTimeMillis();
        System.out.println("start end, time: " + end);
        System.out.println("RunTime: " + (end - start));
    }
}
