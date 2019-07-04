package com.variety.shop.indi.report.DAte;

import com.variety.shop.indi.report.DateTimeUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by rongbin.xie on 2017/5/11.
 */
public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(DateTimeUtils.format(date,DateTimeUtils.DEFAULT_DATETIME_FORMAT));
        System.out.println(DateTimeUtils.format(date,DateTimeUtils.DATE_TIME_FORMAT_1));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        Date date1 = calendar.getTime();
        System.out.println(DateTimeUtils.format(date1,DateTimeUtils.DEFAULT_DATETIME_FORMAT));
        System.out.println(DateTimeUtils.format(date1,DateTimeUtils.DATE_TIME_FORMAT_1));

        calendar.set(Calendar.SECOND,calendar.get(Calendar.SECOND)-1);
        System.out.println(DateTimeUtils.format(calendar.getTime(),DateTimeUtils.DEFAULT_DATETIME_FORMAT));
    }
}
