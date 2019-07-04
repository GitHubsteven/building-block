package com.variety.shop.indi.report;

/**
 * Created by dell on 2017/2/12.
 */
public class ShopBean  extends BaseBean{

    public String shopCommon1;
    public String shopCommon2;
    public String shopCommon3;
    public String shopCommon4;


    public ShopBean(String sb1,String sb2,String sb3,String sb4,String sb5,String sb6,String sb7,String sb8){
        super(sb5,sb6,sb7,sb8);
        this.shopCommon1 = sb1;
        this.shopCommon2 = sb2;
        this.shopCommon3 = sb3;
        this.shopCommon4 = sb4;
    }

    public ShopBean(String sb1,String sb2,String sb3,String sb4)
    {
        this.shopCommon1 = sb1;
        this.shopCommon2 = sb2;
        this.shopCommon3 = sb3;
        this.shopCommon4 = sb4;
    }



    public ShopBean(){
        super();
    }


    public String getShopCommon1() {
        return shopCommon1;
    }

    public void setShopCommon1(String shopCommon1) {
        this.shopCommon1 = shopCommon1;
    }

    public String getShopCommon2() {
        return shopCommon2;
    }

    public void setShopCommon2(String shopCommon2) {
        this.shopCommon2 = shopCommon2;
    }

    public String getShopCommon3() {
        return shopCommon3;
    }

    public void setShopCommon3(String shopCommon3) {
        this.shopCommon3 = shopCommon3;
    }

    public String getShopCommon4() {
        return shopCommon4;
    }

    public void setShopCommon4(String shopCommon4) {
        this.shopCommon4 = shopCommon4;
    }

}
