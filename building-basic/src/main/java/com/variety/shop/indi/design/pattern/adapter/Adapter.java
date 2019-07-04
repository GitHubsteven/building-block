package com.variety.shop.indi.design.pattern.adapter;

import com.variety.shop.rule.bean.Person;

/**
 * Created by rongbin.xie on 2017/11/13.
 */
public class Adapter extends Person implements IUSABPlayer {
    IChineseBPlayer chineseBPlayer = new ChineseBPlayer();

    @Override
    public void train() {
        chineseBPlayer.训练();
    }

    @Override
    public void play() {
        chineseBPlayer.比赛();
    }

    @Override
    public void rest() {
        chineseBPlayer.休息();
    }
}
