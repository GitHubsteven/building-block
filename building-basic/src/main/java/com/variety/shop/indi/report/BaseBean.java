package com.variety.shop.indi.report;

import java.io.Serializable;

/**
 * Created by dell on 2017/2/12.
 */
public class BaseBean implements Serializable{
    String common1;
    String  common2;
    String common3;
    String  common4;

    BaseBean (){}
    BaseBean ( String common1, String  common2, String common3, String  common4){
        this.common2 = common2;
        this.common3 = common3;
        this.common4 = common4;
        this.common1 = common1;
    }
    public String getCommon1() {
        return common1;
    }

    public BaseBean setCommon1(String common1) {
        this.common1 = common1;
        return this;
    }

    public String getCommon2() {
        return common2;
    }

    public BaseBean setCommon2(String common2) {
        this.common2 = common2;
        return this;
    }

    public String getCommon3() {
        return common3;
    }

    public BaseBean setCommon3(String common3) {
        this.common3 = common3;
        return this;
    }

    public String getCommon4() {
        return common4;
    }

    public BaseBean setCommon4(String common4) {
        this.common4 = common4;
        return this;
    }
}
