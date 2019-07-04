package com.variety.shop.indi.design.pattern.adapter.adapterExample;

/**
 * Created by rongbin.xie on 2017/11/13.
 */
public class AdapterFor110vIn220v implements I220VRunOperation {

    I110vOperation i110vProduct;
    public AdapterFor110vIn220v(Integer voltage) {
        super();
        i110vProduct = new One10vProduct(voltage);
    }


    @Override
    public boolean checkEnvironment() {
        return i110vProduct.checkEnvironment();
    }

    @Override
    public void run() {
        i110vProduct.run();
    }

    @Override
    public void stop() {
        i110vProduct.stop();
    }
}
