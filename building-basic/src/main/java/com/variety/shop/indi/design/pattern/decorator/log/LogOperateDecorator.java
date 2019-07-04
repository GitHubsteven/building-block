package com.variety.shop.indi.design.pattern.decorator.log;

/**
 * Created by rongbin.xie on 2018/1/30.
 */
public class LogOperateDecorator extends OperateDecorator {
    public LogOperateDecorator(IOperator operator) {
        super(operator);
    }

    @Override
    public void operate() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        System.out.println("===> class: " + getClass() + "=== method: " + traceElement.getMethodName() + " start <===");
        super.operate();
        System.out.println("===> class: " + getClass() + "=== method: " + traceElement.getMethodName() + " end <===");


    }
}
