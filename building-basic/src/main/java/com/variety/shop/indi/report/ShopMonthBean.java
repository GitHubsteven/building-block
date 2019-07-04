package com.variety.shop.indi.report;

/**
 * Created by dell on 2017/2/12.
 */
public class ShopMonthBean extends  ShopBean {
    String shopMonthAttr1;
    String shopMonthAttr4;
    String shopMonthAttr3;
    String shopMonthAttr2;

    ShopMonthBean(){
        super();
    }

    ShopMonthBean(String a1,String a2,String a3,String a4 ,String parentA1,String parentA2,String parentA3,String parentA4){
        super(parentA1,parentA2,parentA3,parentA4);
        this.shopMonthAttr1 = a1;
        this.shopMonthAttr2 = a2;
        this.shopMonthAttr3 = a3;
        this.shopMonthAttr4 = a4;

    }

    public String getShopMonthAttr1() {
        return shopMonthAttr1;
    }

    public void setShopMonthAttr1(String shopMonthAttr1) {
        this.shopMonthAttr1 = shopMonthAttr1;
    }

    public String getShopMonthAttr4() {
        return shopMonthAttr4;
    }

    public void setShopMonthAttr4(String shopMonthAttr4) {
        this.shopMonthAttr4 = shopMonthAttr4;
    }

    public String getShopMonthAttr3() {
        return shopMonthAttr3;
    }

    public void setShopMonthAttr3(String shopMonthAttr3) {
        this.shopMonthAttr3 = shopMonthAttr3;
    }

    public String getShopMonthAttr2() {
        return shopMonthAttr2;
    }

    public void setShopMonthAttr2(String shopMonthAttr2) {
        this.shopMonthAttr2 = shopMonthAttr2;
    }
}
