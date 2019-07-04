package com.variety.shop.indi.design.pattern.decorator.log;

/**
 * Created by rongbin.xie on 2018/1/30.
 */
public class OperateDecorator implements IOperator {
    IOperator operator;

    public OperateDecorator(IOperator operator) {
        this.operator = operator;
    }

    @Override
    public void operate() {
        if(null != operator){
            operator.operate();
        }
    }

}
