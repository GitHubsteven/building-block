package com.variety.shop.indi.report;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/2/12.
 */
public class StaticClassOne {
    static List<ShopDailyBean> shopDailyBeanList = new ArrayList<>();
    static List<ShopWeekBean> shopWeekBeanList = new ArrayList<>();
    static List<ShopMonthBean> shopMonthBeanList = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            shopDailyBeanList.add(new ShopDailyBean(i + "shopDaily1", i + "shopDaily2", i + "shopDaily3", i + "shopDaily4", i + "shop1", i + "shop2", i + "shop3", i + "shop4"));
            shopWeekBeanList.add(new ShopWeekBean(i + "shopWeek1", i + "shopWeek2", i + "shopWeek3", i + "shopWeek4", i + "shopWeek1", i + "shopWeek6", i + "shopWeek7", i + "shopWeek8"));
            shopMonthBeanList.add(new ShopMonthBean(i + "shopMonth1", i + "shopMonth2", i + "shopMonth3", i + "shopMonth4", i + "shopMonth5", i + "shopMonth6", i + "shopMonth7", i + "shopMonth8"));
        }

    }
}
