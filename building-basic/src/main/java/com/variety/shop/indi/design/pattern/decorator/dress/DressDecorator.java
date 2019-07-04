package com.variety.shop.indi.design.pattern.decorator.dress;

/**
 * dress decorator class
 *
 * Created by rongbin.xie on 2018/1/30.
 */
public class DressDecorator implements IPerson{
    private IPerson person ;

    public DressDecorator(IPerson person) {
        this.person = person;
    }

    @Override
    public void show() {
        if(null  != person){
            person.show();
        }
    }
}
