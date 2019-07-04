package com.variety.shop.indi.report;

/**
 * Created by dell on 2017/2/12.
 */
public class ShopWeekBean extends ShopBean {
    String shopWeekAttr1;
    String shopWeekAttr4;
    String shopWeekAttr3;
    String shopWeekAttr2;

    ShopWeekBean(){
        super();
    }


    ShopWeekBean(String a1,String a2,String a3,String a4 ,String parentA1,String parentA2,String parentA3,String parentA4){
        super(parentA1,parentA2,parentA3,parentA4);
        this.shopWeekAttr1 = a1;
        this.shopWeekAttr2 = a2;
        this.shopWeekAttr3 = a3;
        this.shopWeekAttr4 = a4;

    }

    public String getShopWeekAttr1() {
        return shopWeekAttr1;
    }

    public void setShopWeekAttr1(String shopWeekAttr1) {
        this.shopWeekAttr1 = shopWeekAttr1;
    }

    public String getShopWeekAttr4() {
        return shopWeekAttr4;
    }

    public void setShopWeekAttr4(String shopWeekAttr4) {
        this.shopWeekAttr4 = shopWeekAttr4;
    }

    public String getShopWeekAttr3() {
        return shopWeekAttr3;
    }

    public void setShopWeekAttr3(String shopWeekAttr3) {
        this.shopWeekAttr3 = shopWeekAttr3;
    }

    public String getShopWeekAttr2() {
        return shopWeekAttr2;
    }

    public void setShopWeekAttr2(String shopWeekAttr2) {
        this.shopWeekAttr2 = shopWeekAttr2;
    }
}
