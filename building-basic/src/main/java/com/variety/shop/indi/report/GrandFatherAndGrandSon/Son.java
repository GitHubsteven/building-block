package com.variety.shop.indi.report.GrandFatherAndGrandSon;

/**
 * Created by dell on 2017/2/16.
 */
public class Son extends PaPa {
    public Integer orders;
    public Integer returnRate;
    private String priAttr;

    public String getPriAttr() {
        return priAttr;
    }

    public void setPriAttr(String priAttr) {
        this.priAttr = priAttr;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Integer getReturnRate() {
        return returnRate;
    }

    public void setReturnRate(Integer returnRate) {
        this.returnRate = returnRate;
    }
}
