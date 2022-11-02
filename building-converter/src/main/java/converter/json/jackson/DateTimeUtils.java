/*
 * Created on 2005-8-6
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package converter.json.jackson;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期时间工具类 <br>
 * 提供一些常用的日期时间操作方法，所有方法都为静态，不用实例化该类即可使用。 <br>
 * <br>
 * 下为日期格式的简单描述详情请参看java API中java.text.SimpleDateFormat <br>
 * The following pattern letters are defined (all other characters from
 * <code>'A'</code> to <code>'Z'</code> and from <code>'a'</code> to
 * <code>'z'</code> are reserved): <blockquote><table border=0 cellspacing=3
 * cellpadding=0>
 * <tr bgcolor="#ccccff">
 * <th align=left>Letter
 * <th align=left>Date or Time Component
 * <th align=left>Presentation
 * <th align=left>Examples
 * <tr>
 * <td><code>G</code>
 * <td>Era designator
 * <td><a href="#text">Text </a>
 * <td><code>AD</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>y</code>
 * <td>Year
 * <td><a href="#year">Year </a>
 * <td><code>1996</code>;<code>96</code>
 * <tr>
 * <td><code>M</code>
 * <td>Month in year
 * <td><a href="#month">Month </a>
 * <td><code>July</code>;<code>Jul</code>;<code>07</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>w</code>
 * <td>Week in year
 * <td><a href="#number">Number </a>
 * <td><code>27</code>
 * <tr>
 * <td><code>W</code>
 * <td>Week in month
 * <td><a href="#number">Number </a>
 * <td><code>2</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>D</code>
 * <td>Day in year
 * <td><a href="#number">Number </a>
 * <td><code>189</code>
 * <tr>
 * <td><code>d</code>
 * <td>Day in month
 * <td><a href="#number">Number </a>
 * <td><code>10</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>F</code>
 * <td>Day of week in month
 * <td><a href="#number">Number </a>
 * <td><code>2</code>
 * <tr>
 * <td><code>E</code>
 * <td>Day in week
 * <td><a href="#text">Text </a>
 * <td><code>Tuesday</code>;<code>Tue</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>a</code>
 * <td>Am/pm marker
 * <td><a href="#text">Text </a>
 * <td><code>PM</code>
 * <tr>
 * <td><code>H</code>
 * <td>Hour in day (0-23)
 * <td><a href="#number">Number </a>
 * <td><code>0</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>k</code>
 * <td>Hour in day (1-24)
 * <td><a href="#number">Number </a>
 * <td><code>24</code>
 * <tr>
 * <td><code>K</code>
 * <td>Hour in am/pm (0-11)
 * <td><a href="#number">Number </a>
 * <td><code>0</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>h</code>
 * <td>Hour in am/pm (1-12)
 * <td><a href="#number">Number </a>
 * <td><code>12</code>
 * <tr>
 * <td><code>m</code>
 * <td>Minute in hour
 * <td><a href="#number">Number </a>
 * <td><code>30</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>s</code>
 * <td>Second in minute
 * <td><a href="#number">Number </a>
 * <td><code>55</code>
 * <tr>
 * <td><code>S</code>
 * <td>Millisecond
 * <td><a href="#number">Number </a>
 * <td><code>978</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>z</code>
 * <td>Time zone
 * <td><a href="#timezone">General time zone </a>
 * <td><code>Pacific Standard Time</code>;<code>PST</code>;
 * <code>GMT-08:00</code>
 * <tr>
 * <td><code>Z</code>
 * <td>Time zone
 * <td><a href="#rfc822timezone">RFC 822 time zone </a>
 * <td><code>-0800</code> </table> </blockquote>
 * <h4>Examples</h4>
 * <p/>
 * The following examples show how date and time patterns are interpreted in the
 * U.S. locale. The given date and time are 2001-07-04 12:08:56 local time in
 * the U.S. Pacific Time time zone. <blockquote><table border=0 cellspacing=3
 * cellpadding=0>
 * <tr bgcolor="#ccccff">
 * <th align=left>Date and Time Pattern
 * <th align=left>Result
 * <tr>
 * <td><code>"yyyy.MM.dd G 'at' HH:mm:ss z"</code>
 * <td><code>2001.07.04 AD at 12:08:56 PDT</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>"EEE, MMM d, ''yy"</code>
 * <td><code>Wed, Jul 4, '01</code>
 * <tr>
 * <td><code>"h:mm a"</code>
 * <td><code>12:08 PM</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>"hh 'o''clock' a, zzzz"</code>
 * <td><code>12 o'clock PM, Pacific Daylight Time</code>
 * <tr>
 * <td><code>"K:mm a, z"</code>
 * <td><code>0:08 PM, PDT</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>"yyyyy.MMMMM.dd GGG hh:mm aaa"</code>
 * <td><code>02001.July.04 AD 12:08 PM</code>
 * <tr>
 * <td><code>"EEE, d MMM yyyy HH:mm:ss Z"</code>
 * <td><code>Wed, 4 Jul 2001 12:08:56 -0700</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>"yyMMddHHmmssZ"</code>
 * <td><code>010704120856-0700</code> </table> </blockquote>
 *
 * @author 创建日期： 2003.8.28
 */

public abstract class DateTimeUtils {
    private static Date createdDefaultDate;

    private final static Logger logger = LoggerFactory.getLogger(DateTimeUtils.class);

    /**
     * 缺省的日期显示格式： yyyy-MM-dd
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 缺省的日期时间显示格式：yyyy-MM-dd HH:mm:ss
     */
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATETIME_FORMAT_1 = "yyyy-MM-dd HH-mm-ss"; // 用在文件名中，不能带":"

    /**
     * 缺省时间显示格式：HH:mm:ss
     */
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    /**
     * 缺省的日期显示格式： MM/dd/yyyy
     */
    public static final String US_DATE_FORMAT = "MM/dd/yyyy HH:mm:ss";

    /**
     * 缺省的日期显示格式： MM/dd/yyyy
     */
    public static final String EN_DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";

    /**
     * 缺省的日期显示格式：yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final String DATE_TIME_FORMAT_1 = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 缺省的日期时间显示格式：yyyyMMddHHmmss
     */
    public static final String DATE_TIME_FORMAT_2 = "yyyyMMddHHmmss";

    /**
     * 缺省的日期时间显示格式：yyyyMMdd
     */
    public static final String DATE_TIME_FORMAT_3 = "yyyyMMdd";

    /**
     * 缺省的日期时间显示格式：HHmmss
     */
    public static final String DATE_TIME_FORMAT_4 = "HHmmss";

    /**
     * 缺省的日期时间显示格式：yyyy-MM-dd'T'HH:mm:ss（参照例：2014-11-11T14:00:00）
     */
    public static final String DATE_TIME_FORMAT_5 = "yyyy-MM-dd'T'HH:mm:ss";

    /**
     * 缺省的日期时间显示格式：yyyy-MM-dd'T'HH:mm:ssZ（参照例：2014-11-11T14:00:00+0800）
     */
    public static final String DATE_TIME_FORMAT_6 = "yyyy-MM-dd'T'HH:mm:ssZ";

    /**
     * 缺省的日期时间显示格式：MMddyyyy
     */
    public static final String DATE_TIME_FORMAT_7 = "MMddyyyy";

    /**
     * 缺省的日期时间显示格式：MMdd
     */
    public static final String DATE_TIME_FORMAT_8 = "MMdd";

    /**
     * 缺省的日期时间显示格式：MMddyy
     */
    public static final String DATE_TIME_FORMAT_9 = "MMddyy";
    /**
     * 缺省的日期时间显示格式：MMddyy
     */
    public static final String DATE_TIME_FORMAT_10 = "yyMMdd";
    /**
     * 缺省的日期时间显示格式：MMddyyyy
     */
    public static final String DATE_TIME_FORMAT_11 = "MM/dd/yyyy";
    /**
     * 缺省的日期时间显示格式：yyyy-MM
     */
    public static final String DATE_TIME_FORMAT_12 = "yyyy-MM";

    /**
     * 得到系统当前日期时间
     *
     * @return 当前日期时间
     */
    public static Date getDate() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 得到用缺省方式格式化的当前日期及时间
     *
     * @return 当前日期及时间
     */
    public static String getNow() {
        return getNow(DEFAULT_DATETIME_FORMAT);
    }

    /**
     * 得到系统当前日期及时间，并用指定的方式格式化
     *
     * @param pattern 显示格式
     * @return 当前日期及时间
     */
    public static String getNow(String pattern) {
        return format(getDate(), pattern);
    }

    /**
     * 得到用指定方式格式化的日期
     *
     * @param date    需要进行格式化的日期
     * @param pattern 显示格式
     * @return 日期时间字符串
     */
    public static String format(Date date, String pattern) {
        String patternTmp = pattern;
        if (null == patternTmp || "".equals(patternTmp)) {
            patternTmp = DEFAULT_DATETIME_FORMAT;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(patternTmp);
        return dateFormat.format(date);
    }

    /**
     * 得到指定日期年份
     *
     * @return 年份
     */
    public static int getDateYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 得到指定日期月份
     *
     * @return 月份
     */
    public static int getDateMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 取得指定日期以后若干天的日期。如果要得到以前的日期，参数用负数。
     *
     * @param date 基准日期
     * @param days 增加的日期数
     * @return 增加以后的日期
     */
    public static Date addDays(Date date, int days) {
        return add(date, days, Calendar.DATE);
    }

    /**
     * 取得指定日期以后某月的日期。如果要得到以前月份的日期，参数用负数。 注意，可能不是同一日子，例如2003-1-31加上一个月是2003-2-28
     *
     * @param date   基准日期
     * @param months 增加的月份数
     * @return 增加以后的日期
     */
    public static Date addMonths(Date date, int months) {
        return add(date, months, Calendar.MONTH);
    }

    /**
     * 内部方法。为指定日期增加相应的天数或月数
     *
     * @param date   基准日期
     * @param amount 增加的数量
     * @param field  增加的单位，年，月或者日
     * @return 增加以后的日期
     */
    private static Date add(Date date, int amount, int field) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        calendar.add(field, amount);

        return calendar.getTime();
    }

    /**
     * 计算两个日期相差天数。 用第一个日期减去第二个。如果前一个日期小于后一个日期，则返回负数
     *
     * @param one 第一个日期数，作为基准
     * @param two 第二个日期数，作为比较
     * @return 两个日期相差天数
     */
    public static long diffDays(Date one, Date two) {
        return (one.getTime() - two.getTime()) / (24 * 60 * 60 * 1000);
    }

    /**
     * 将一个字符串用默认为“yyyy-MM-dd HH:mm:ss”的形式转换为日期类型。 <br>
     * 注意：如果返回null，则表示解析失败
     *
     * @param dateStr 需要解析的日期字符串
     * @return 解析后的日期
     */
    public static Date parse(String dateStr) {
        return parse(dateStr, DEFAULT_DATETIME_FORMAT);
    }

    /**
     * 将一个字符串用给定的格式转换为日期类型。 <br>
     * 注意：如果返回null，则表示解析失败
     *
     * @param dateStr 需要解析的日期字符串
     * @param pattern 日期字符串的格式
     * @return 解析后的日期
     */
    public static Date parse(String dateStr, String pattern) {
        Date date = null;

        if (dateStr == null || dateStr.trim().length() == 0) {
            return null;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            logger.debug("日期转换错误", e);
        }

        return date;
    }

    /**
     * 将一个字符串用给定的格式转换为日期类型。 <br>
     * 注意：如果返回null，则表示解析失败
     *
     * @param dateStr 需要解析的日期字符串
     * @param pattern 日期字符串的格式
     * @return 解析后的日期
     */
    public static Date parseToGmt(String dateStr, String pattern) {
        Date date = null;

        if (dateStr == null || dateStr.trim().length() == 0) {
            return null;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            logger.debug("日期转换错误", e);
        }

        return date;
    }

    /**
     * 返回给定日期中的月份中的最后一天
     *
     * @param date 基准日期
     * @return 该月最后一天的日期
     */
    public static Date getMonthLastDay(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // 将日期设置为下一月第一天
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, 1);

        // 减去1天，得到的即本月的最后一天
        calendar.add(Calendar.DATE, -1);

        return calendar.getTime();
    }

    /**
     * 取得指定日期以后某年的日期。如果要得到以前月份的日期，参数用负数。
     *
     * @param date  基准日期
     * @param hours 增加的时间数
     */
    public static Date addHours(Date date, int hours) {
        return add(date, hours, Calendar.HOUR_OF_DAY);
    }

    /**
     * 根据时区，返回基于GMT时间的本地时间，并格式化
     *
     * @param date     GMT时间
     * @param timezone 时区
     * @return yyyy-MM-dd HH:mm:ss 格式的本地时间
     */
    public static String getLocalTime(String date, int timezone) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(DateTimeUtils.DEFAULT_DATETIME_FORMAT);
            Date fromDate = df.parse(date);

            Date toDate = DateTimeUtils.addHours(fromDate, timezone);

            return format(toDate, DateTimeUtils.DEFAULT_DATETIME_FORMAT);
        } catch (ParseException e) {
            return "getLocalTime :date format error";
        }
    }

    /**
     * 根据时区，返回基于GMT时间的本地时间，并格式化
     *
     * @param date     GMT时间
     * @param timezone 时区
     * @return yyyy-MM-dd HH:mm:ss 格式的本地时间
     */
    public static String getLocalTime(Date date, int timezone) {
        return getLocalTime(date, timezone, DateTimeUtils.DEFAULT_DATETIME_FORMAT);
    }

    /**
     * 根据时区，返回基于GMT时间的本地时间，并格式化
     *
     * @param date     GMT时间
     * @param timezone 时区
     * @param format   时间日期格式
     * @return 格式化后的本地时间
     */
    public static String getLocalTime(Date date, int timezone, String format) {
        Date toDate = DateTimeUtils.addHours(date, timezone);
        return format(toDate, format);
    }

    /**
     * 根据时区，返回本地时间，并格式化
     *
     * @param timezone 时区
     * @return yyyy-MM-dd HH:mm:ss 格式的本地时间
     */
    public static String getLocalTime(int timezone) {
        return getLocalTime(timezone, DateTimeUtils.DEFAULT_DATETIME_FORMAT);
    }

    /**
     * 根据时区，返回基于GMT时间的本地时间，并格式化
     *
     * @param timezone 时区
     * @param format   时间日期格式
     * @return 格式化后的本地时间
     */
    public static String getLocalTime(int timezone, String format) {
        try {
            String date = getGMTTime();
            SimpleDateFormat df = new SimpleDateFormat(DateTimeUtils.DEFAULT_DATETIME_FORMAT);
            Date fromDate = df.parse(date);

            Date toDate = DateTimeUtils.addHours(fromDate, timezone);

            return format(toDate, format);
        } catch (ParseException e) {
            return "getLocalTime :date format error";
        }
    }

    /**
     * 返回基于系统时间的GMT时间，并格式化
     *
     * @return yyyy-MM-dd HH:mm:ss 格式的GMT时间
     */
    public static String getGMTTime() {
        return getGMTTime(DateTimeUtils.DEFAULT_DATETIME_FORMAT);
    }

    /**
     * 返回基于系统时间的GMT时间，并格式化
     *
     * @param format 时间日期格式
     * @return 格式化后的GMT时间
     */
    public static String getGMTTime(String format) {

        // 取得系统当前时间
        Calendar now = Calendar.getInstance();
        // 取得系统时间和格林威治时间之间的偏移值
        int diffsecond = now.getTimeZone().getRawOffset();
        // 换算成格林威治时间
        now.add(Calendar.SECOND, diffsecond / 1000 * -1);
        Date dateTo = now.getTime();

        return format(dateTo, format);
    }

    /**
     * 返回基于系统时间的GMT时间
     *
     * @return Calendar GMT的Calendar
     */
    public static Calendar getCustomCalendar(int timezone) {
        // 取得系统当前时间
        Calendar now = Calendar.getInstance();
        // 取得系统时间和格林威治时间之间的偏移值
        int diffsecond = now.getTimeZone().getRawOffset();
        // 换算成格林威治时间
        now.add(Calendar.SECOND, diffsecond / 1000 * -1);
        now.add(Calendar.SECOND, timezone * 3600);
        return now;
    }

    /**
     * 取得本地时间对应的GMT时间(一天的开始)
     *
     * @param day      格式 yyyy-MM-dd
     * @param timezone like +8 / -7
     * @return String
     */
    public static String getGMTTimeFrom(String day, int timezone) {
        try {
            String date = day + " 00:00:00";

            SimpleDateFormat df = new SimpleDateFormat(DateTimeUtils.DEFAULT_DATETIME_FORMAT);
            Date fromDate = df.parse(date);

            Date toDate = DateTimeUtils.addHours(fromDate, timezone * -1);

            return format(toDate, DateTimeUtils.DEFAULT_DATETIME_FORMAT);
        } catch (ParseException e) {
            return "getGMTTimeTo :date format error";
        }
    }

    /**
     * 取得本地时间对应的GMT时间(一天的结束)
     *
     * @param day      格式 yyyy-MM-dd
     * @param timezone like +8 / -7
     * @return String
     */
    public static String getGMTTimeTo(String day, int timezone) {
        try {
            String date = day + " 23:59:59";

            SimpleDateFormat df = new SimpleDateFormat(DateTimeUtils.DEFAULT_DATETIME_FORMAT);
            Date fromDate = df.parse(date);

            Date toDate = DateTimeUtils.addHours(fromDate, timezone * -1);

            return format(toDate, DateTimeUtils.DEFAULT_DATETIME_FORMAT);
        } catch (ParseException e) {
            return "getGMTTimeTo :date format error";
        }
    }

    /***
     * 取得指定天数之前的日期
     * @param intDays int
     * @return 返回的日期
     */
    public static String getDateBeforeDays(int intDays) {
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat simple = new SimpleDateFormat(DEFAULT_DATE_FORMAT);

        // 取得指定天数之前的日期
        currentDate.add(Calendar.HOUR, -(24 * intDays));
        return simple.format(currentDate.getTime());
    }

    /**
     * 取得指定时间以后多少分钟的时间。如果要得到以前多少分钟的时间，参数用负数。
     *
     * @param date    基准日期
     * @param minutes 增加的时间数
     */
    public static Date addMinutes(Date date, int minutes) {
        return add(date, minutes, Calendar.MINUTE);
    }

    /**
     * 根据Date型dateTime获得pattern格式的字符串日期
     *
     * @param dateTime Date
     * @param pattern  String
     * @return String
     */
    public static String getDateTime(Date dateTime, String pattern) {
        String patternTmp = pattern;
        if (StringUtils.isBlank(patternTmp)) {
            patternTmp = DEFAULT_DATETIME_FORMAT;
        }

        SimpleDateFormat sf = new SimpleDateFormat(patternTmp);
        return sf.format(dateTime);
    }

    /**
     * 得到当前时间TimeStamp
     *
     * @return 当前日期及时间
     */
    public static String getNowTimeStamp() {
        return new Timestamp(System.currentTimeMillis()).toString();
    }

    /**
     * 得到当前时间TimeStamp
     *
     * @return 当前日期及时间
     */
    public static long getNowTimeStampLong() {
        return System.currentTimeMillis();
    }

    public static Date getCreatedDefaultDate() {
        if (createdDefaultDate == null) {
            createdDefaultDate = parse("2000-01-01 00:00:00");
        }
        return createdDefaultDate;
    }

    /**
     * 获取更改时区后的日期
     *
     * @param date    日期
     * @param oldZone 旧时区对象
     * @param newZone 新时区对象
     * @return 日期
     */
    public static Date changeTimeZone(Date date, TimeZone oldZone, TimeZone newZone) {
        Date dateTmp = null;
        if (date != null) {
            int timeOffset = oldZone.getRawOffset() - newZone.getRawOffset();
            dateTmp = new Date(date.getTime() - timeOffset);
        }
        return dateTmp;
    }
}