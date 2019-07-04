package com.variety.shop.indi.design.pattern.decorator.log;

import java.util.stream.IntStream;

/**
 * 具体实现类
 * <p>
 * Created by rongbin.xie on 2018/1/30.
 */
public class Operator implements IOperator {
    @Override
    public void operate() {
        IntStream.range(0,10000).forEach(it->{
            System.out.println("operating....");
        });

    }
}
