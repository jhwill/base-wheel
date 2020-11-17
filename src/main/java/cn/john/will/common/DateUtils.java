package cn.john.will.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期处理工具类
 *
 * @author Gavin Gao
 * @version 2.2 2018/1/13 Gavin 新增获取当前季度时间
 * @title DateUtil
 * @since 2012/12/18
 */
public class DateUtils {

    public static final int MILLISECOND = Calendar.MILLISECOND;
    public static final int SECOND = Calendar.SECOND;
    public static final int MINUTE = Calendar.MINUTE;
    public static final int HOUR = Calendar.HOUR_OF_DAY;
    public static final int DAY = Calendar.DAY_OF_MONTH;
    public static final int MONTH = Calendar.MONTH;
    public static final int YEAR = Calendar.YEAR;
    public static final int DAY_OF_YEAR = Calendar.DAY_OF_YEAR;
    public static final int DAY_OF_WEEK = Calendar.DAY_OF_WEEK;
    public final static String DEFAULT_PATTERN = "yyyy-MM-dd";

    ;
    public final static String SIMPLE_PATTERN = "yyMMdd";

    private DateUtils() {
    }

    /**
     * 获取时间time的前后若干年的时间
     *
     * @param date Date类型，基础时间
     * @param step int类型，要向前或身后的年数
     * @return backDate Date类型，返回的时间
     */
    public static Date getNextYear(Date date, int step) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(YEAR, step);//加时
        return cal.getTime();
    }

    /**
     * 获取时间time的前后若干月的时间
     *
     * @param date Date类型，基础时间
     * @param step int类型，要向前或身后的月数
     * @return backDate Date类型，返回的时间
     */
    public static Date getNextMonth(Date date, int step) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(MONTH, step);//加时
        return cal.getTime();
    }

    /**
     * 获取时间time的前后若干天的时间
     *
     * @param date Date类型，基础时间
     * @param step int类型，要向前或身后的天数
     * @return backDate Date类型，返回的时间
     */
    public static Date getNextDay(Date date, int step) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(DAY, step);
        return cal.getTime();
    }

    /**
     * 获取时间time的前后若干天的时间
     *
     * @param time Long类型，基础时间的毫秒值
     * @param step int类型，要向前或身后的天数
     * @return Long类型，返回的时间毫秒值
     */
    public static Long getNextDay(Long time, int step) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        cal.add(DAY, step);
        return cal.getTimeInMillis();
    }

    /**
     * 获取时间time的前后若干的小时的时间
     *
     * @param date Date类型，基础时间
     * @param step int类型，要向前或身后的小时数
     * @return backDate Date类型，返回的时间
     */
    public static Date getNextHour(Date date, int step) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(HOUR, step);//加时
        return cal.getTime();
    }

    /**
     * 获取时间time的前后若干的分钟的时间
     *
     * @param date Date类型，基础时间
     * @param step int类型，要向前或身后的分钟数
     * @return backDate Date类型，返回的时间
     */
    public static Date getNextMinute(Date date, int step) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(MINUTE, step);//加时
        return cal.getTime();
    }

    /**
     * 获取时间time的前后若干的秒时间
     *
     * @param date Date类型，基础时间
     * @param step int类型，要向前或身后的秒数
     * @return backDate Date类型，返回的时间
     */
    public static Date getNextSecond(Date date, int step) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(SECOND, step);//加时
        return cal.getTime();
    }

    /**
     * 获取时间time的前后若干的毫秒的时间
     *
     * @param date Date类型，基础时间
     * @param step int类型，要向前或身后的毫秒数
     * @return backDate Date类型，返回的时间
     */
    public static Date getNextMillis(Date date, int step) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(MILLISECOND, step);//加时
        return cal.getTime();
    }

    /**
     * 根据时间字符串返回日期类型,time的格式为yyyy-MM-dd HH:mm:ss
     *
     * @param time String类型，时间字符串
     * @return date Date类型，返回的时间
     */
    public static Date getDateByStringNormal(String time) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = df.parse(time);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 根据时间字符串返回日期类型,time的格式为yyyy-MM-dd
     *
     * @param time String类型，时间字符串
     * @return date Date类型，返回的时间
     */
    public static Date getDateByStringDay(String time) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = df.parse(time);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 根据时间字符串返回日期类型,time的格式为yyyy-MM-dd HH:mm:ss.SSS
     *
     * @param time String类型，时间字符串
     * @return date Date类型，返回的时间
     */
    public static Date getDateByStringMillis(String time) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = null;
        try {
            date = df.parse(time);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 根据时间字符串返回日期类型,time的格式为format的定义
     *
     * @param time   String类型，时间字符串
     * @param format String类型，时间格式
     * @return date Date类型，返回的时间
     */
    public static Date getDateWithFormat(String time, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = df.parse(time);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将日期类型转换为日期字符串,自动匹配日期格式，效率较低
     *
     * @param date Date类型
     * @return String类型，日期字符串
     */
    public static String dateToString(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        try {
            return df.format(date);
        } catch (Exception e) {
            SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                return df2.format(date);
            } catch (Exception e2) {
                SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return df3.format(date);
                } catch (Exception e3) {
                    SimpleDateFormat df4 = new SimpleDateFormat("yyyy-MM");
                    try {
                        return df4.format(date);
                    } catch (Exception e4) {
                        return date.toString();
                    }
                }
            }
        }
    }

    /**
     * 将日期类型转换为日期字符串,无格式，默认：yyyy-MM-dd
     *
     * @param date Date类型
     * @return String类型，日期字符串
     */
    public static String dateToStringDay(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

    /**
     * 将日期类型转换为日期字符串,无格式，默认：yyyy-MM-dd HH:mm:ss
     *
     * @param date Date类型
     * @return String类型，日期字符串
     */
    public static String dateToStringNormal(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }

    /**
     * 将日期类型转换为日期字符串,无格式，默认：yyyy-MM-dd HH:mm:ss.SSS
     *
     * @param date Date类型
     * @return String类型，日期字符串
     */
    public static String dateToStringMillis(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return df.format(date);
    }

    /**
     * 将日期类型转换为日期字符串,自定义格式
     *
     * @param date   Date类型
     * @param format String类型，日期格式化格式
     * @return String类型，日期字符串
     */
    public static String dateToStringWithFormat(Date date, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * 两个日期类型相差的分钟数，取天花板数
     *
     * @param date1 Date类型，时间1
     * @param date2 Date类型，时间2
     * @return date2-date1的分钟数,int类型.因为int类型最大值够用4000年以上
     */
    public static int dValueOfTime(Date date1, Date date2) {
        return (int) (Math.ceil((date2.getTime() - date1.getTime()) / 60000));
    }

    /**
     * 两个日期类型相差的毫秒数
     *
     * @param date1 Date类型，时间1
     * @param date2 Date类型，时间2
     * @return date2-date1的毫秒数
     */
    public static long dValueOfTimeMillis(Date date1, Date date2) {
        return date2.getTime() - date1.getTime();
    }

    /**
     * 获取传入的string类型日期跟当前日期相差的天数,string日期大
     *
     * @param date String类型，时间
     * @return 天数, int类型
     */
    public static int dValueOfDay(String date) {
        Date date2 = getDateByStringNormal(date);
        return (int) ((date2.getTime() - new Date().getTime()) / (60000 * 1440));
    }

    /**
     * 获取传入的Long类型时间的秒值跟当前秒值相差的秒数,Long类型时间的秒值大
     *
     * @param time Long类型，时间的秒值
     * @return 间隔的秒数, long类型
     */
    public static long dValueOfTimeSecond(Long time) {
        Long interval = time - (new Date().getTime() / 1000);
        if (interval < 0) {
            interval = 0l;
        }
        return interval;
    }

    /**
     * 时间的分钟数（秒被截掉）
     *
     * @param date Date类型，时间
     * @return date的分钟数, int类型
     */
    public static int minuteOfTime(Date date) {
        return (int) (date.getTime() / 60000);
    }

    /**
     * 分钟数转换为日期类型
     *
     * @param minute int 分钟数
     * @return 日期
     */
    public static Date getDateByMinute(int minute) {
        Calendar cal = Calendar.getInstance();
        long millis = 60000;
        cal.setTimeInMillis(millis * minute);
        return cal.getTime();
    }

    /**
     * 毫秒转换为日期类型
     *
     * @param millis long 毫秒数
     * @return 日期
     */
    public static Date getDateByMillis(long millis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(millis);
        return cal.getTime();
    }

    /**
     * 获得时间的一个位置值
     *
     * @param date
     * @param field
     * @return
     */
    public static int getFiled(Date date, int field) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(field);
    }

    /**
     * 设置时间的一个域为另一个时间
     *
     * @param date  原始时间
     * @param field 时间域
     * @param value 时间值
     * @return 新时间
     */
    public static Date setFiled(Date date, int field, int value) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(field, value);
        return cal.getTime();
    }

    /**
     * 获得当年的起点时间
     */
    public static Date getThisYear() {
        return getThisYear(getCurrentTime());
    }

    /**
     * 获得设置日期的当年的起点时间
     */
    public static Date getThisYear(Date date) {
        Date month0 = getThisMonth(date);
        month0 = setFiled(month0, MONTH, 0);
        return month0;
    }

    /**
     * 获得当季的起点时间
     */
    public static Date getThisQuarter() {
        return getThisQuarter(getCurrentTime());
    }

    /**
     * 获得设置日期的当季的起点时间
     */
    public static Date getThisQuarter(Date date) {
        Date quarter = getThisMonth(date);
        int month = getFiled(quarter, DateUtils.MONTH);
        if (month < 3) {
            quarter = setFiled(quarter, MONTH, 0);
        } else if (month >= 3 && month < 6) {
            quarter = setFiled(quarter, MONTH, 3);
        } else if (month >= 6 && month < 9) {
            quarter = setFiled(quarter, MONTH, 6);
        } else {
            quarter = setFiled(quarter, MONTH, 9);
        }
        return quarter;
    }

    /**
     * 获得当月的起点时间
     */
    public static Date getThisMonth() {
        return getThisMonth(getCurrentTime());
    }

    /**
     * 获得设置日期的当月的起点时间
     */
    public static Date getThisMonth(Date date) {
        Date day0 = getThisDay(date);
        day0 = setFiled(day0, DAY, 1);
        return day0;
    }

    /**
     * 获得当前星期的起点时间（周日零点）
     */
    public static Date getThisWeek() {
        return getThisWeek(getCurrentTime());
    }

    /**
     * 获得设置日期所有星期的起点时间（周日零点）
     */
    public static Date getThisWeek(Date date) {
        int week = getFiled(date, DAY_OF_WEEK);
        Date sunday = getNextDay(date, -(week - 1));
        return getThisDay(sunday);
    }

    /**
     * 获得当日的起点时间
     */
    public static Date getThisDay() {
        return getThisDay(getCurrentTime());
    }

    /**
     * 获得设置日期的当天起点时间
     */
    public static Date getThisDay(Date date) {
        Date hour0 = getThisHour(date);
        hour0 = setFiled(hour0, HOUR, 0);
        return hour0;
    }

    /**
     * 获得当前小时的起点时间
     */
    public static Date getThisHour() {
        return getThisHour(getCurrentTime());
    }

    /**
     * 获得设置日期的当前小时的起点时间
     */
    public static Date getThisHour(Date date) {
        date = setFiled(date, MILLISECOND, 0);
        date = setFiled(date, SECOND, 0);
        date = setFiled(date, MINUTE, 0);
        return date;
    }

    /**
     * 获得当前时间
     */
    public static Date getCurrentTime() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 判断是否润年
     *
     * @param ddate
     * @return
     */
    public static boolean isLeapYear(Date ddate) {
        /**
         * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
         * 3.能被4整除同时能被100整除则不是闰年
         */
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(ddate);
        int year = gc.get(Calendar.YEAR);
        if ((year % 400) == 0) {
            return true;
        } else if ((year % 4) == 0) {
            if ((year % 100) == 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * 获取date的月份的时间范围
     *
     * @param date
     * @return
     */
    public static DateRange getMonthRangeObj(Date date) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(date);
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        setMaxTime(startCalendar);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(date);
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        setMaxTime(endCalendar);

        return new DateRange(format(startCalendar.getTime()) + " 00:00:00", format(endCalendar.getTime()) + " 23:59:59");
    }

    /**
     * 获取当前季度的时间范围
     *
     * @return current quarter
     */
    public static DateRange getThisQuarterObj() {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.set(Calendar.MONTH, (startCalendar.get(Calendar.MONTH) / 3) * 3);
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        setMinTime(startCalendar);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.set(Calendar.MONTH, ((int) startCalendar.get(Calendar.MONTH) / 3) * 3 + 2);
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        setMaxTime(endCalendar);

        return new DateRange(format(startCalendar.getTime()) + " 00:00:00", format(endCalendar.getTime()) + " 23:59:59");
    }

    /**
     * 获取当天的时间范围
     *
     * @return
     */
    public static DateRange getNowdayRangeObj() {
        LocalDate startCalendar = LocalDate.now();
        LocalDate endCalendar = LocalDate.now().plusDays(1);
        return new DateRange(startCalendar.atTime(0, 0).format(DateTimeFormatter.ofPattern(DEFAULT_PATTERN)) + " 00:00:00", endCalendar.atTime(0, 0).minusSeconds(1).format(DateTimeFormatter.ofPattern(DEFAULT_PATTERN)) + " 23:59:59");
    }

    /**
     * 获取昨天的时间范围
     *
     * @return
     */
    public static DateRange getYesterdayRangeObj() {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.add(Calendar.DAY_OF_MONTH, -1);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.add(Calendar.DAY_OF_MONTH, -1);

        return new DateRange(format(startCalendar.getTime()) + " 00:00:00", format(endCalendar.getTime()) + " 23:59:59");
    }

    /**
     * 获取本周的时间范围
     *
     * @return
     */
    public static DateRange getNowWeekRangeObj() {
        LocalDate startCalendar = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        LocalDate endCalendar = LocalDate.now().plusWeeks(1).with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        return new DateRange(startCalendar.atTime(0, 0).format(DateTimeFormatter.ofPattern(DEFAULT_PATTERN)) + " 00:00:00", endCalendar.atTime(0, 0).minusSeconds(1).format(DateTimeFormatter.ofPattern(DEFAULT_PATTERN)) + " 23:59:59");
    }

    /**
     * 获取上周的时间范围
     *
     * @return
     */
    public static DateRange getLastweekRangeObj() {
        LocalDate endCalendar = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        LocalDate startCalendar = endCalendar.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        return new DateRange(startCalendar.atTime(0, 0).format(DateTimeFormatter.ofPattern(DEFAULT_PATTERN)) + " 00:00:00", endCalendar.atTime(0, 0).minusSeconds(1).format(DateTimeFormatter.ofPattern(DEFAULT_PATTERN)) + " 23:59:59");
    }

    /**
     * 获取当前月份的时间范围
     *
     * @return
     */
    public static DateRange getThisMonthObj() {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        setMinTime(startCalendar);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        setMaxTime(endCalendar);

        return new DateRange(format(startCalendar.getTime()) + " 00:00:00", format(endCalendar.getTime()) + " 23:59:59");
    }

    /**
     * 获取上个月的时间范围
     *
     * @return
     */
    public static DateRange getLastMonthObj() {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.add(Calendar.MONTH, -1);
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        setMinTime(startCalendar);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.add(Calendar.MONTH, -1);
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        setMaxTime(endCalendar);

        return new DateRange(format(startCalendar.getTime()) + " 00:00:00", format(endCalendar.getTime()) + " 23:59:59");
    }

    /**
     * 获取上个季度的时间范围
     *
     * @return
     */
    public static DateRange getLastQuarterObj() {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.set(Calendar.MONTH, (startCalendar.get(Calendar.MONTH) / 3 - 1) * 3);
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        setMinTime(startCalendar);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.set(Calendar.MONTH, (endCalendar.get(Calendar.MONTH) / 3 - 1) * 3 + 2);
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        setMaxTime(endCalendar);

        return new DateRange(format(startCalendar.getTime()) + " 00:00:00", format(endCalendar.getTime()) + " 23:59:59");
    }

    private static void setMinTime(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    private static void setMaxTime(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
    }

    public static String format(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);
        return sdf.format(date);
    }

    public static String getSimplePattern(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_PATTERN);
        return sdf.format(date);
    }

//	public static void main(String[] args) {
//
//		DateRange currentQuarter = getThisQuarterObj();
//		System.out.println("当前季度的时间范围： "+currentQuarter.getStartTime()+" - "+currentQuarter.getEndTime());
//
//
//		DateRange yesterdayRange = getYesterdayRangeObj();
//		System.out.println("昨天的时间范围: "+yesterdayRange.getStartTime()+" - "+yesterdayRange.getEndTime());
//
//		DateRange thisMonth = getThisMonthObj();
//		System.out.println("当前月份的时间范围: "+thisMonth.getStartTime()+" - "+thisMonth.getEndTime());
//
//		DateRange lastMonth = getLastMonthObj();
//		System.out.println("上个月的时间范围: "+lastMonth.getStartTime()+" - "+lastMonth.getEndTime());
//
//		DateRange lastQuarter = getLastQuarterObj();
//		System.out.println("上个季度的时间范围: "+lastQuarter.getStartTime()+" - "+lastQuarter.getEndTime());
//
//		DateRange yesterWeek = getNowdayRangeObj();
//		System.out.println("上个周的时间范围: "+yesterWeek.getStartTime()+" - "+yesterWeek.getEndTime());
//
//
//	}

    /**
     * 判断当前时间是否在指定时间段内
     *
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
}
