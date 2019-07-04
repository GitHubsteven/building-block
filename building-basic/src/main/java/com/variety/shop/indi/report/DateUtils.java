package com.variety.shop.indi.report;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by dell on 2017/2/14.
 */
public class DateUtils {

    private static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
    private static Calendar calendar = Calendar.getInstance();

    public static void getTheWeekOfYear ( String  date)
    {
        Date date1 = stringToDate(date);
        calendar.setTime(date1);
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
    }

    /**
     * 时间转化为String类型
     * @param date
     * @return
     */
    public static String dateToString(Date date)
    {
        return sdfDate.format(date);
    }
    public static Date stringToDate (String  dateStr)
    {
        Date date = null;
        try {
            date = sdfDate.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    public static void main(String[] args) {
        String date="2015-12-28";
        getTheWeekOfYear(date);
    }
}
