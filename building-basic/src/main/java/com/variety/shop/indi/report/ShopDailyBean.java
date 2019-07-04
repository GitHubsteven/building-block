package com.variety.shop.indi.report;

/**
 * Created by dell on 2017/2/12.
 */
public class ShopDailyBean extends ShopBean{
    String shopDailyAttr1;
    String shopDailyAttr4;
    String shopDailyAttr3;
    String shopDailyAttr2;


    public Integer[] returnArray()
    {
        Integer[] a = {1, 2, 3, 4};
        return a;
    }


    ShopDailyBean(String a1,String a2,String a3,String a4 ,String parentA1,String parentA2,String parentA3,String parentA4){
        super(parentA1,parentA2,parentA3,parentA4);
        this.shopDailyAttr1 = a1;
        this.shopDailyAttr2 = a2;
        this.shopDailyAttr3 = a3;
        this.shopDailyAttr4 = a4;

    }
    protected  void introduce(Integer number)
    {
        System.out.println("protected method with int parameter" + number);
    }

    private void  introduce ()
    {
        System.out.println("I am private method introduce! ");
    }

    void introduce(String str)
    {
        System.out.println("default method with the str parameter :" + str);
    }

    ShopDailyBean(){
        super();
    }

    public String getShopDailyAttr1() {
        return shopDailyAttr1;
    }

    public void setShopDailyAttr1(String shopDailyAttr1) {
        this.shopDailyAttr1 = shopDailyAttr1;
    }

    public String getShopDailyAttr4() {
        return shopDailyAttr4;
    }

    public void setShopDailyAttr4(String shopDailyAttr4) {
        this.shopDailyAttr4 = shopDailyAttr4;
    }

    public String getShopDailyAttr3() {
        return shopDailyAttr3;
    }

    public void setShopDailyAttr3(String shopDailyAttr3) {
        this.shopDailyAttr3 = shopDailyAttr3;
    }

    public String getShopDailyAttr2() {
        return shopDailyAttr2;
    }

    public void setShopDailyAttr2(String shopDailyAttr2) {
        this.shopDailyAttr2 = shopDailyAttr2;
    }
}
