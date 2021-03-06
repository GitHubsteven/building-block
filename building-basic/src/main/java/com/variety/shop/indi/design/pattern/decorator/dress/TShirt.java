package com.variety.shop.indi.design.pattern.decorator.dress;

/**
 * Created by rongbin.xie on 2018/1/30.
 */
public class TShirt extends DressDecorator {
    public TShirt(IPerson person) {
        super(person);
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Big TShirt!");
    }
}
