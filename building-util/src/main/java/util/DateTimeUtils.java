//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class DateTimeUtils {
    private static Date createdDefaultDate;
    private static final Logger logger = LoggerFactory.getLogger(DateTimeUtils.class);
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATETIME_FORMAT_1 = "yyyy-MM-dd HH-mm-ss";
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    public static final String US_DATE_FORMAT = "MM/dd/yyyy HH:mm:ss";
    public static final String EN_DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final String DATE_TIME_FORMAT_1 = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DATE_TIME_FORMAT_2 = "yyyyMMddHHmmss";
    public static final String DATE_TIME_FORMAT_3 = "yyyyMMdd";
    public static final String DATE_TIME_FORMAT_4 = "HHmmss";
    public static final String DATE_TIME_FORMAT_5 = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATE_TIME_FORMAT_6 = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final String DATE_TIME_FORMAT_7 = "MMddyyyy";
    public static final String DATE_TIME_FORMAT_8 = "MMdd";
    public static final String DATE_TIME_FORMAT_9 = "MMddyy";
    public static final String DATE_TIME_FORMAT_10 = "yyMMdd";
    public static final String DATE_TIME_FORMAT_11 = "MM/dd/yyyy";
    public static final String DATE_TIME_FORMAT_12 = "yyyy-MM";

    private DateTimeUtils() {
    }

    public static Date getDate() {
        return Calendar.getInstance().getTime();
    }

    public static String getNow() {
        return getNow("yyyy-MM-dd HH:mm:ss");
    }

    public static String getNow(String pattern) {
        return format(getDate(), pattern);
    }

    public static String format(Date date, String pattern) {
        String patternTmp = pattern;
        if (null == pattern || "".equals(pattern)) {
            patternTmp = "yyyy-MM-dd HH:mm:ss";
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(patternTmp);
        return dateFormat.format(date);
    }

    public static int getDateYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(1);
    }

    public static int getDateMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(2) + 1;
    }

    public static Date addDays(Date date, int days) {
        return add(date, days, 5);
    }

    public static Date addMonths(Date date, int months) {
        return add(date, months, 2);
    }

    private static Date add(Date date, int amount, int field) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    public static long diffDays(Date one, Date two) {
        return (one.getTime() - two.getTime()) / 86400000L;
    }

    public static Date parse(String dateStr) {
        return parse(dateStr, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date parse(String dateStr, String pattern) {
        Date date = null;
        if (dateStr != null && dateStr.trim().length() != 0) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                date = dateFormat.parse(dateStr);
            } catch (ParseException var4) {
                logger.debug("日期转换错误", var4);
            }

            return date;
        } else {
            return null;
        }
    }

    public static Date parseToGmt(String dateStr, String pattern) {
        Date date = null;
        if (dateStr != null && dateStr.trim().length() != 0) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                date = dateFormat.parse(dateStr);
            } catch (ParseException var4) {
                logger.debug("日期转换错误", var4);
            }

            return date;
        } else {
            return null;
        }
    }

    public static Date getMonthLastDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(1), calendar.get(2) + 1, 1);
        calendar.add(5, -1);
        return calendar.getTime();
    }

    public static Date addHours(Date date, int hours) {
        return add(date, hours, 11);
    }

    public static String getLocalTime(String date, int timezone) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date fromDate = df.parse(date);
            Date toDate = addHours(fromDate, timezone);
            return format(toDate, "yyyy-MM-dd HH:mm:ss");
        } catch (ParseException var5) {
            return "getLocalTime :date format error";
        }
    }

    public static String getLocalTime(Date date, int timezone) {
        return getLocalTime(date, timezone, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getLocalTime(Date date, int timezone, String format) {
        Date toDate = addHours(date, timezone);
        return format(toDate, format);
    }

    public static String getLocalTime(int timezone) {
        return getLocalTime(timezone, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getLocalTime(int timezone, String format) {
        try {
            String date = getGMTTime();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date fromDate = df.parse(date);
            Date toDate = addHours(fromDate, timezone);
            return format(toDate, format);
        } catch (ParseException var6) {
            return "getLocalTime :date format error";
        }
    }

    public static String getGMTTime() {
        return getGMTTime("yyyy-MM-dd HH:mm:ss");
    }

    public static String getGMTTime(String format) {
        Calendar now = Calendar.getInstance();
        int diffsecond = now.getTimeZone().getRawOffset();
        now.add(13, diffsecond / 1000 * -1);
        Date dateTo = now.getTime();
        return format(dateTo, format);
    }

    public static Calendar getCustomCalendar(int timezone) {
        Calendar now = Calendar.getInstance();
        int diffsecond = now.getTimeZone().getRawOffset();
        now.add(13, diffsecond / 1000 * -1);
        now.add(13, timezone * 3600);
        return now;
    }

    public static String getGMTTimeFrom(String day, int timezone) {
        try {
            String date = day + " 00:00:00";
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date fromDate = df.parse(date);
            Date toDate = addHours(fromDate, timezone * -1);
            return format(toDate, "yyyy-MM-dd HH:mm:ss");
        } catch (ParseException var6) {
            return "getGMTTimeTo :date format error";
        }
    }

    public static String getGMTTimeTo(String day, int timezone) {
        try {
            String date = day + " 23:59:59";
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date fromDate = df.parse(date);
            Date toDate = addHours(fromDate, timezone * -1);
            return format(toDate, "yyyy-MM-dd HH:mm:ss");
        } catch (ParseException var6) {
            return "getGMTTimeTo :date format error";
        }
    }

    public static String getDateBeforeDays(int intDays) {
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        currentDate.add(10, -(24 * intDays));
        return simple.format(currentDate.getTime());
    }

    public static Date addMinutes(Date date, int minutes) {
        return add(date, minutes, 12);
    }

    public static String getDateTime(Date dateTime, String pattern) {
        String patternTmp = pattern;
        if (StringUtils.isEmpty(pattern)) {
            patternTmp = "yyyy-MM-dd HH:mm:ss";
        }

        SimpleDateFormat sf = new SimpleDateFormat(patternTmp);
        return sf.format(dateTime);
    }

    public static String getNowTimeStamp() {
        return (new Timestamp(System.currentTimeMillis())).toString();
    }

    public static long getNowTimeStampLong() {
        return System.currentTimeMillis();
    }

    public static Date getCreatedDefaultDate() {
        if (createdDefaultDate == null) {
            createdDefaultDate = parse("2000-01-01 00:00:00");
        }

        return createdDefaultDate;
    }

    public static Date changeTimeZone(Date date, TimeZone oldZone, TimeZone newZone) {
        Date dateTmp = null;
        if (date != null) {
            int timeOffset = oldZone.getRawOffset() - newZone.getRawOffset();
            dateTmp = new Date(date.getTime() - (long) timeOffset);
        }

        return dateTmp;
    }
}
