package com.variety.shop.indi.design.pattern.adapter.adapterExample;

/**
 * Now, i just supply 200v electricity, however the my phone only support 110v
 *
 * Created by rongbin.xie on 2017/11/13.
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("I am in 220v environment, I need a adapter for my 110v electric product");
        I220VRunOperation product = new AdapterFor110vIn220v(135);
        product.run();
        product.stop();
    }
}
