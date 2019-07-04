package com.variety.shop.indi.java8;

import com.variety.shop.utils.StringUtils;

import java.math.BigDecimal;

/**
 * Created by rongbin.xie on 2017/11/3.
 */
public class data {


    public static void main(String[] args) {
//        String value = "1.592145";
//        BigDecimal newValue = BigDecimal.valueOf(Double.parseDouble(value));
//
////        newValue.setScale(2,BigDecimal.ROUND_HALF_UP);
//        newValue = newValue.setScale(2,BigDecimal.ROUND_HALF_UP);
//        System.out.println(newValue);
        Param targetItem = new Param();
        targetItem.setClientPrice("12.343554");
        String targetItemClientPrice = null;
        targetItemClientPrice.trim();
        BigDecimal clientPrice = !StringUtils.isNumeric(targetItemClientPrice) ? BigDecimal.valueOf(0)
                : BigDecimal.valueOf(Double.parseDouble(targetItemClientPrice));
    }
}
