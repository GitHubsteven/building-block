package com.variety.shop.indi.design.pattern.decorator.log;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by rongbin.xie on 2018/1/30.
 */
public class Main {

    public static void main(String[] args) {
        IOperator operator = new Operator();

        OperateDecorator decorator = new OperateDecorator(operator);
        LogOperateDecorator logOperateDecorator = new LogOperateDecorator(decorator);
        TimeDecorator timeDecorator = new TimeDecorator(logOperateDecorator);
        timeDecorator.operate();

//        Iterator iterator = Arrays.

    }
}
