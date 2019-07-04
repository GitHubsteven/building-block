package com.variety.shop.indi.design.pattern.decorator.dress;

/**
 * Created by rongbin.xie on 2018/1/30.
 */
public class Main {
    public static void main(String[] args) {
        IPerson person = new Person("jack");
        BigTrouser bigTrouser = new BigTrouser(person);
//        bigTrouser.show();
        TShirt tShirt = new TShirt(bigTrouser);
//        tShirt.show();
        BlackSuit blackSuit = new BlackSuit(tShirt);
        blackSuit.show();
    }
}
