package com.variety.shop.indi.design.pattern.adapter.adapterExample;

/**
 * Created by rongbin.xie on 2017/11/13.
 */
public class One10vProduct implements I110vOperation {
    private  Integer voltage;

    public One10vProduct(Integer voltage) {
        this.voltage = voltage;
    }

    @Override
    public boolean checkEnvironment() {
        return voltage < 110;
    }

    @Override
    public void run() {
        if(checkEnvironment()){
            System.out.println("I run under 110v environment normally");
        }else{
            System.out.println("voltage is too high , i stop");
        }
    }

    @Override
    public void stop() {
        if(checkEnvironment()){
            System.out.println("I stop normally");
        }else{
            System.out.println("I stop abnormally,");
        }
    }
}
