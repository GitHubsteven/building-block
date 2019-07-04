package com.variety.shop.indi.design.pattern.adapter;

import com.variety.shop.rule.bean.Person;

/**
 * Created by rongbin.xie on 2017/11/13.
 */
public class USABPlayer extends Person implements  IUSABPlayer {
    @Override
    public void train() {
        System.out.println("I, just train");
    }

    @Override
    public void play() {
        System.out.println("I, just play");
    }

    @Override
    public void rest() {
        System.out.println("I, just rest");
    }
}
