package com.variety.shop.indi.report;

import java.math.BigDecimal;

/**
 * Created by rongbin.xie on 2017/6/8.
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        A b = new A();
        b.setA(new BigDecimal(0));


        System.out.println(null != b.getA());

        System.out.println(b.getA().add(new BigDecimal(1)));



    }


    static class  A{
        BigDecimal a;

        public BigDecimal getA() {
            return a;
        }

        public void setA(BigDecimal a) {
            this.a = a;
        }
    }
}
