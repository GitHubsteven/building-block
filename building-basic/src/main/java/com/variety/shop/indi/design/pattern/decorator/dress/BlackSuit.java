package com.variety.shop.indi.design.pattern.decorator.dress;

/**
 * black suit
 * <p>
 * Created by rongbin.xie on 2018/1/30.
 */
public class BlackSuit extends DressDecorator {
    public BlackSuit(IPerson person) {
        super(person);
    }

    @Override
    public void show() {
        super.show();
        System.out.println("dress black suit!");
    }

    ;
}
