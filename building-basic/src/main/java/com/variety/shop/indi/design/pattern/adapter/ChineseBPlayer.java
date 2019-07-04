package com.variety.shop.indi.design.pattern.adapter;

import com.variety.shop.rule.bean.Person;

/**
 * Created by rongbin.xie on 2017/11/13.
 */
public class ChineseBPlayer extends Person implements  IChineseBPlayer{

    @Override
    public void 训练() {
        System.out.println("我只是训练");
    }

    @Override
    public void 比赛() {
        System.out.println("我只是比赛");
    }

    @Override
    public void 休息() {
        System.out.println("我只是休息");
    }
}
