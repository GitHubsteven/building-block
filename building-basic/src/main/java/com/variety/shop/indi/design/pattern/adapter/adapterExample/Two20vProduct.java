package com.variety.shop.indi.design.pattern.adapter.adapterExample;

/**
 * Created by rongbin.xie on 2017/11/13.
 */
public class Two20vProduct implements I220VRunOperation {
    private Integer voltage;

    public Two20vProduct(Integer voltage) {
        this.voltage = voltage;
    }

    @Override
    public boolean checkEnvironment() {
        return voltage < 220;
    }

    @Override
    public void run() {
        if (checkEnvironment()) {
            System.out.println("I am running under 220v");
        } else {
            System.out.println("some unpredicted problem would show");
        }
    }

    @Override
    public void stop() {
        if (checkEnvironment()) {
            System.out.println("I am stopping under 220v");
        } else {
            System.out.println("I stopped for some special condition");
        }
    }

    public Integer getVoltage() {
        return voltage;
    }

    public void setVoltage(Integer voltage) {
        this.voltage = voltage;
    }
}
